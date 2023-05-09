package com.example.expense_tracker_szemanlevi.service;

import com.example.expense_tracker_szemanlevi.dao.ExpenseDao;
import com.example.expense_tracker_szemanlevi.dao.IncomeCategoryDao;
import com.example.expense_tracker_szemanlevi.dao.IncomeDao;
import com.example.expense_tracker_szemanlevi.entity.Expense;
import com.example.expense_tracker_szemanlevi.entity.Income;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeDao incomeDao;

    @Autowired
    private ExpenseDao expenseDao;

    @Autowired
    private IncomeCategoryDao categoryDao;


    public List<Income> findAll() {
        return incomeDao.findAll();
    }


    public Optional<Income> findById(Long id) {
        return incomeDao.findById(id);
    }

    public Income save(Income income) {
        return incomeDao.save(income);
    }

    public Income update(Long id, Income income) {
        Income incomeToUpdate = incomeDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Income not found"));
        incomeToUpdate.setDescription(income.getDescription());
        incomeToUpdate.setAmount(income.getAmount());
        incomeToUpdate.setDate(income.getDate());
        incomeToUpdate.setIncomeCategory(income.getIncomeCategory());
        return incomeDao.save(incomeToUpdate);
    }


    public void delete(Long id) {
        incomeDao.deleteById(id);
    }

    public Double getBalance() {
        double allIncomes = incomeDao.findAll().stream().mapToDouble(Income::getAmount).sum();
        double allExpenses = expenseDao.findAll().stream().mapToDouble(Expense::getAmount).sum();
        return allIncomes - allExpenses;
    }
}


