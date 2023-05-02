package com.example.expense_tracker_szemanlevi.dao;

import com.example.expense_tracker_szemanlevi.entity.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IncomeCategoryDao extends JpaRepository<IncomeCategory, Long> {

}
