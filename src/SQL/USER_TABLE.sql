CREATE TABLE user_details(
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
 );