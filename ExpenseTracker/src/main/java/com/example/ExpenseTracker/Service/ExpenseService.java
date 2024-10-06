package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.Model.Expense;
import com.example.ExpenseTracker.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addIncome(Expense income){
        return expenseRepository.save(income);
    }

    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensebyDate(LocalDate date){
        return expenseRepository.findByDate(date);
    }

    public List<Expense> getExpenseByMonth(LocalDate startDate, LocalDate endDate){
        return expenseRepository.findByDateBetween(startDate, endDate);
    }

    public Optional<Expense> getLatestBalance(){
        return expenseRepository.findByDateDesc();
    }

}
