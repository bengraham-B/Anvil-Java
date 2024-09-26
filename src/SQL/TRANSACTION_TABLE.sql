CREATE TABLE transaction (
    transaction_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    details TEXT,
    amount NUMERIC(10, 2),  -- Use NUMERIC for monetary values with two decimal places
    transaction_date DATE,
    user_id TEXT,
    transaction_type VARCHAR(10),
    day INT,
    month INT,
    month_name VARCHAR(10),
    year INT
);
