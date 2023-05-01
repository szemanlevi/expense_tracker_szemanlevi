package com.example.expense_tracker_szemanlevi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "expenses")
public class Expense {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "id", nullable = false)
        private UUID id;

        private String description;

    private double amount;

//    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ExpenseCategory category;

        public Expense(String description, double amount, Date date, ExpenseCategory category) {
                this.description = description;
                this.amount = amount;
                this.date = date;
                this.category = category;
        }

        public Expense(String description, double amount, Date date) {
                this.description = description;
                this.amount = amount;
                this.date = date;
                this.category = null;
        }
}
