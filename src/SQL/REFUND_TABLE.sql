CREATE TABLE refund (
  refund_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  details TEXT,
  amount FLOAT,
  refunded_amount FLOAT,
  refunded BOOLEAN,
  payer TEXT,
  user_id UUID,
  created TIMESTAMP DEFAULT current_timestamp
 );