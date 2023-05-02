package com.example.expense_tracker_szemanlevi.dao;

import com.example.expense_tracker_szemanlevi.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseCategoryDao extends JpaRepository<ExpenseCategory, Long> {

}
