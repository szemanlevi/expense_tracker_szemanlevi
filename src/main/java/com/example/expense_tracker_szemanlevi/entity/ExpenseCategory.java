package com.example.expense_tracker_szemanlevi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense_category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ExpenseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expenseCategory")
    @JsonBackReference
    private List<Expense> expenses;

    public ExpenseCategory(String name) {
        this.name = name;
        this.expenses = List.of();
    }
}


