package com.example.expense_tracker_szemanlevi.service;

import com.example.expense_tracker_szemanlevi.dao.ExpenseCategoryDao;
import com.example.expense_tracker_szemanlevi.dao.ExpenseDao;
import com.example.expense_tracker_szemanlevi.entity.Expense;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseDao expenseDao;

    @Autowired
    private ExpenseCategoryDao categoryDao;


    public List<Expense> findAll() {
        return expenseDao.findAll();
    }


    public Optional<Expense> findById(Long id) {
        return expenseDao.findById(id);
    }

    public Expense save(Expense expense) {
        return expenseDao.save(expense);
    }

    public Expense update(Long id, Expense expense) {
        Expense expenseToUpdate = expenseDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Expense not found"));
        expenseToUpdate.setDescription(expense.getDescription());
        expenseToUpdate.setAmount(expense.getAmount());
        expenseToUpdate.setDate(expense.getDate());
        expenseToUpdate.setExpenseCategory(expense.getExpenseCategory());
        return expenseDao.save(expenseToUpdate);
    }


    public void delete(Long id) {
        expenseDao.deleteById(id);
    }
}

