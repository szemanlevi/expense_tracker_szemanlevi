drop table if exists expense CASCADE;
drop table if exists expense_category CASCADE;
drop table if exists income CASCADE;
drop table if exists income_category CASCADE;

CREATE TABLE expense_category
(
    id   bigint NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE expense
(
    id                  UUID NOT NULL,
    description         VARCHAR(255),
    amount              DOUBLE PRECISION,
    date                TIMESTAMP,
    expense_category_id UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (expense_category_id) REFERENCES expense_category (id)
);

CREATE TABLE income_category
(
    id   bigint NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE income
(
    id                  UUID NOT NULL,
    description         VARCHAR(255),
    amount              DOUBLE PRECISION,
    date                TIMESTAMP,
    income_category_id UUID,
    PRIMARY KEY (id),
    FOREIGN KEY (income_category_id) REFERENCES income_category (id)
);