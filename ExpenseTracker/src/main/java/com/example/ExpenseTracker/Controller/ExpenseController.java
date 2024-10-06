package com.example.ExpenseTracker.Controller;

import com.example.ExpenseTracker.Model.Expense;
import com.example.ExpenseTracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/expense-tracker")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add-income")
    public ResponseEntity<Expense> addIncome(@RequestBody Expense income){
        return ResponseEntity.ok().body(expenseService.addIncome(income));
    }

    @PostMapping("/add-expense")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense){
        return ResponseEntity.ok().body(expenseService.addExpense(expense));
    }
    @GetMapping("/expense/{date}")
    public ResponseEntity<List<Expense>> getExpenseByDate(@PathVariable("date") String date){
     //parsing a date
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return ResponseEntity.ok().body(expenseService.getExpensebyDate(parsedDate));
    }

    @GetMapping("/expense/{startDate}/{endDate}")
    public ResponseEntity<List<Expense>> getExpenseByMonth(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        LocalDate parsedstartDate = LocalDate.parse(startDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate parsedenddate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return ResponseEntity.ok().body(expenseService.getExpenseByMonth(parsedstartDate,parsedenddate));
    }

    @GetMapping("/latestbalance")
    public ResponseEntity<Expense> getLatestBalance(){
        return expenseService.getLatestBalance().map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
}
