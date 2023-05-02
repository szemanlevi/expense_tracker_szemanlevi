-- Expense categories
INSERT INTO expense_category (id, name) VALUES (1, 'Groceries');
INSERT INTO expense_category (id, name) VALUES (2, 'Rent');
INSERT INTO expense_category (id, name) VALUES (3, 'Utilities');
INSERT INTO expense_category (id, name) VALUES (4, 'Transportation');
INSERT INTO expense_category (id, name) VALUES (5, 'Entertainment');
INSERT INTO expense_category (id, name) VALUES (6, 'Healthcare');
INSERT INTO expense_category (id, name) VALUES (7, 'Other');

-- Income categories
INSERT INTO income_category (id, name) VALUES (1, 'Salary');
INSERT INTO income_category (id, name) VALUES (2, 'Freelance');
INSERT INTO income_category (id, name) VALUES (3, 'Investments');
INSERT INTO income_category (id, name) VALUES (4, 'Gifts');
INSERT INTO income_category (id, name) VALUES (5, 'Other');

-- Expenses
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('1', 'Grocery shopping', 100.00, '2023-02-01', 1);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('2', 'Rent payment', 1000.00, '2023-02-12', 2);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('3', 'Electricity bill', 70.00, '2023-02-13', 3);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('4', 'Gas bill', 50.00, '2023-03-06', 3);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('5', 'Water bill', 30.00, '2023-03-14', 3);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('6', 'Bus pass', 60.00, '2023-03-17', 4);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('7', 'Gasoline', 40.00, '2023-03-24', 4);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('8', 'Movie tickets', 25.00, '2023-04-11', 5);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('9', 'Dinner at restaurant', 80.00, '2023-04-19', 5);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('10', 'Doctor appointment', 120.00, '2023-04-21', 6);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('11', 'Medicine', 45.00, '2023-04-22', 6);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('12', 'Gym membership', 50.00, '2023-04-24', 7);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('13', 'New shoes', 90.00, '2023-04-25', 7);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('14', 'Internet subscription', 60.00, '2023-05-01', 3);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('15', 'Mobile phone bill', 75.00, '2023-05-01', 3);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('16', 'Home insurance', 80.00, '2023-05-01', 7);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('17', 'Car maintenance', 150.00, '2023-05-01', 4);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('18', 'Netflix subscription', 15.00, '2023-05-01', 5);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('19', 'Dental checkup', 100.00, '2023-05-01', 6);
INSERT INTO expense (id, description, amount, date, expense_category_id) VALUES ('20', 'Birthday gift', 50.00, '2023-05-01', 7);

-- Incomes
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('1', 'January salary', 2500.00, '2023-02-01', 1);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('2', 'Freelance web development', 800.00, '2023-02-02', 2);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('3', 'Stock dividends', 200.00, '2023-03-01', 3);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('4', 'Birthday gift', 100.00, '2023-03-21', 4);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('5', 'Bank interest', 50.00, '2023-03-22', 5);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('6', 'Sold old laptop', 300.00, '2023-04-01', 5);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('7', 'Garage sale', 150.00, '2023-04-13', 5);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('8', 'Tax refund', 500.00, '2023-04-14', 5);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('9', 'Rental income', 400.00, '2023-05-01', 1);
INSERT INTO income (id, description, amount, date, income_category_id) VALUES ('10', 'Side job', 200.00, '2023-05-01', 2);

