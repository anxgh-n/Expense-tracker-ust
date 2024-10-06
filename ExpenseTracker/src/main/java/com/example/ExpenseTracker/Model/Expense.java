package com.example.ExpenseTracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="expense_tracker")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id = UUID.randomUUID();
    private LocalDate date;
    private String itemName;
    private String paymentMethod;
    private Double expenseAmount;
    private Double incomeAmount;
    private Double balanceAmount;


}
