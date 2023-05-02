package com.example.expense_tracker_szemanlevi.service;

import com.example.expense_tracker_szemanlevi.dao.ExpenseCategoryDao;
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
import java.util.UUID;

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


    public Optional<Income> findById(UUID id) {
        return incomeDao.findById(id);
    }

    public Income save(Income income) {
        return incomeDao.save(income);
    }

    public Income update(UUID id, Income income) {
        Income incomeToUpdate = incomeDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Income not found"));
        incomeToUpdate.setDescription(income.getDescription());
        incomeToUpdate.setAmount(income.getAmount());
        incomeToUpdate.setDate(income.getDate());
        incomeToUpdate.setCategory(income.getCategory());
        return incomeDao.save(incomeToUpdate);
    }


    public void delete(UUID id) {
        incomeDao.deleteById(id);
    }

    public Double getBalance() {
        double allIncomes = incomeDao.findAll().stream().mapToDouble(Income::getAmount).sum();
        double allExpenses = expenseDao.findAll().stream().mapToDouble(Expense::getAmount).sum();
        return allIncomes - allExpenses;
    }

//    public IncomeDto createIncome(IncomeDto incomeDto) {
//        Income income = convertToEntity(incomeDto);
//        IncomeCategory category = categoryDao.findById(incomeDto.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
//        income.setCategory(category);
//        income = incomeDao.save(income);
//        return convertToDto(income);
//    }

//    private IncomeDto convertToDto(Income income) {
//        IncomeDto incomeDto = new IncomeDto();
////        incomeDto.setId(income.getId());
//        incomeDto.setDescription(income.getDescription());
//        expenseDto.setAmount(expense.getAmount());
//        expenseDto.setDate(expense.getDate());
//        expenseDto.setCategory(new CategoryDto(expense.getCategory().getName()));
//        return expenseDto;
//    }
//
//    private Income convertToEntity(IncomeDto expenseDto) {
//        Income expense = new Income();
//        expense.setDescription(expenseDto.getDescription());
//        expense.setAmount(expenseDto.getAmount());
//        expense.setDate(expenseDto.getDate());
//        return expense;
//    }
}


