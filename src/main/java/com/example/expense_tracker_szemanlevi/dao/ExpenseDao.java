package com.example.expense_tracker_szemanlevi.dao;

import com.example.expense_tracker_szemanlevi.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseDao extends JpaRepository<Expense, Long> {

}
