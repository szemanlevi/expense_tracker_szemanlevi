-- Expense categories
INSERT INTO expense_category (name) VALUES ('Groceries');
INSERT INTO expense_category (name) VALUES ('Rent');
INSERT INTO expense_category (name) VALUES ('Utilities');
INSERT INTO expense_category (name) VALUES ('Transportation');
INSERT INTO expense_category (name) VALUES ('Entertainment');
INSERT INTO expense_category (name) VALUES ('Healthcare');
INSERT INTO expense_category (name) VALUES ('Other');

-- Income categories
INSERT INTO income_category (name) VALUES ('Salary');
INSERT INTO income_category (name) VALUES ('Freelance');
INSERT INTO income_category (name) VALUES ('Investments');
INSERT INTO income_category (name) VALUES ('Gifts');
INSERT INTO income_category (name) VALUES ('Other');

-- Expenses
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Grocery shopping', 100.00, '2023-02-01', 1);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Rent payment', 1000.00, '2023-02-12', 2);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Electricity bill', 70.00, '2023-02-13', 3);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Gas bill', 50.00, '2023-03-06', 3);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Water bill', 30.00, '2023-03-14', 3);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Bus pass', 60.00, '2023-03-17', 4);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Gasoline', 40.00, '2023-03-24', 4);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Movie tickets', 25.00, '2023-04-11', 5);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Dinner at restaurant', 80.00, '2023-04-19', 5);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Doctor appointment', 120.00, '2023-04-21', 6);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Medicine', 45.00, '2023-04-22', 6);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Gym membership', 50.00, '2023-04-24', 7);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('New shoes', 90.00, '2023-04-25', 7);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Internet subscription', 60.00, '2023-05-01', 3);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Mobile phone bill', 75.00, '2023-05-01', 3);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Home insurance', 80.00, '2023-05-01', 7);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Car maintenance', 150.00, '2023-05-01', 4);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Netflix subscription', 15.00, '2023-05-01', 5);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Dental checkup', 100.00, '2023-05-01', 6);
INSERT INTO expense (description, amount, date, expense_category_id) VALUES ('Birthday gift', 50.00, '2023-05-01', 7);

-- Incomes
INSERT INTO income (description, amount, date, income_category_id) VALUES ('January salary', 2500.00, '2023-02-01', 1);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Freelance web development', 800.00, '2023-02-02', 2);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Stock dividends', 200.00, '2023-03-01', 3);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Birthday gift', 100.00, '2023-03-21', 4);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Bank interest', 50.00, '2023-03-22', 5);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('March salary', 2500.00, '2023-04-01', 1);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Sold old laptop', 300.00, '2023-04-01', 5);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Garage sale', 150.00, '2023-04-13', 5);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Tax refund', 500.00, '2023-04-14', 5);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Rental income', 400.00, '2023-05-01', 1);
INSERT INTO income (description, amount, date, income_category_id) VALUES ('Side job', 200.00, '2023-05-01', 2);

