package com.example.expense_tracker_szemanlevi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String description;
    private Double amount;
    //    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_category_id")
    private ExpenseCategory expenseCategory;

    public Expense(String description, double amount, Date date, ExpenseCategory expenseCategory) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.expenseCategory = expenseCategory;
    }

    public Expense(String description, double amount, Date date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.expenseCategory = null;
    }
}
