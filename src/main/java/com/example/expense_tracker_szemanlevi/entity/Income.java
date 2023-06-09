package com.example.expense_tracker_szemanlevi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private Double amount;
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "income_category_id")
    private IncomeCategory incomeCategory;

    public Income(String description, double amount, Date date, IncomeCategory incomeCategory) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.incomeCategory = incomeCategory;
    }

    public Income(String description, double amount, Date date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.incomeCategory = null;
    }
}
