package com.example.expense_tracker_szemanlevi.dao;

import com.example.expense_tracker_szemanlevi.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeDao extends JpaRepository<Income, Long> {

}
