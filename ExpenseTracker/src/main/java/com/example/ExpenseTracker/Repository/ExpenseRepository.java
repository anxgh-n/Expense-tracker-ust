package com.example.ExpenseTracker.Repository;

import com.example.ExpenseTracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
    List<Expense> findByDate(LocalDate date);

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT e FROM Expense e ORDER BY e.date DESC")
    Optional<Expense> findByDateDesc();
}
