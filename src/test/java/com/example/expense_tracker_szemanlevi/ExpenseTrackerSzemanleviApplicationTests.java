package com.example.expense_tracker_szemanlevi;

import com.example.expense_tracker_szemanlevi.entity.Expense;
import com.example.expense_tracker_szemanlevi.entity.ExpenseCategory;
import com.example.expense_tracker_szemanlevi.service.ExpenseCategoryService;
import com.example.expense_tracker_szemanlevi.service.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.json.JacksonTester;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExpenseTrackerSzemanleviApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ExpenseCategoryService expenseCategoryService;
    @Autowired
    private ExpenseService expenseService;
    private JacksonTester<ExpenseCategory> jsonExpenseCategory;
    private JacksonTester<Expense> jsonExpense;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAllExpenseCategories() throws Exception {
        mockMvc.perform(get("/expense/category")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetExpenseCategoryById() throws Exception {
        ExpenseCategory category = new ExpenseCategory();
        category.setName("TestCategory");

        ExpenseCategory savedCategory = expenseCategoryService.save(category);

        mockMvc.perform(get("/expense/category/{id}", savedCategory.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TestCategory"));
    }

    @Test
    public void testAddExpenseCategory() throws Exception {
        ExpenseCategory category = new ExpenseCategory();
        category.setName("TestCategory");

        mockMvc.perform(post("/expense/category/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonExpenseCategory.write(category).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TestCategory"));
    }

    @Test
    public void testUpdateExpenseCategory() throws Exception {
        ExpenseCategory category = new ExpenseCategory();
        category.setName("TestCategory");

        ExpenseCategory savedCategory = expenseCategoryService.save(category);

        ExpenseCategory updatedCategory = new ExpenseCategory();
        updatedCategory.setName("UpdatedTestCategory");

        mockMvc.perform(put("/expense/category/{id}", savedCategory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonExpenseCategory.write(updatedCategory).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("UpdatedTestCategory"));
    }

    @Test
    public void testDeleteExpenseCategory() throws Exception {
        ExpenseCategory category = new ExpenseCategory();
        category.setName("TestCategory");

        ExpenseCategory savedCategory = expenseCategoryService.save(category);

        mockMvc.perform(delete("/expense/category/{id}", savedCategory.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/expense/category/{id}", savedCategory.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAddExpense() throws Exception {
        Expense expense = new Expense();
        expense.setDescription("TestExpense");
        expense.setAmount(100.0);

        mockMvc.perform(post("/expense")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonExpense.write(expense).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("TestExpense"))
                .andExpect(jsonPath("$.amount").value(100.0));
    }

    @Test
    public void testUpdateExpense() throws Exception {
        Expense expense = new Expense();
        expense.setDescription("TestExpense");
        expense.setAmount(100.0);

        Expense savedExpense = expenseService.save(expense);

        Expense updatedExpense = new Expense();
        updatedExpense.setDescription("UpdatedTestExpense");
        updatedExpense.setAmount(200.0);

        mockMvc.perform(put("/expense/{id}", savedExpense.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonExpense.write(updatedExpense).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("UpdatedTestExpense"))
                .andExpect(jsonPath("$.amount").value(200.0));
    }

    @Test
    public void testDeleteExpense() throws Exception {
        Expense expense = new Expense();
        expense.setDescription("TestExpense");
        expense.setAmount(100.0);

        Expense savedExpense = expenseService.save(expense);

        mockMvc.perform(delete("/expense/{id}", savedExpense.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/expense/{id}", savedExpense.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}

