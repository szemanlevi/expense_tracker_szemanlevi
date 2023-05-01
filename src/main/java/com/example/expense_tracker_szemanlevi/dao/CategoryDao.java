package com.example.expense_tracker_szemanlevi.dao;

import com.example.expense_tracker_szemanlevi.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryDao extends JpaRepository<ExpenseCategory, UUID> {

}
