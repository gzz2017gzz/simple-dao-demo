-- 用户表（复用）
CREATE TABLE IF NOT EXISTS t_user (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    email VARCHAR(100),
    create_time TIMESTAMP,
    create_by BIGINT,
    update_time TIMESTAMP,
    update_by BIGINT,
    dr TINYINT DEFAULT 0
);

-- 订单表（复用，用于子查询）
CREATE TABLE IF NOT EXISTS t_order (
    id BIGINT PRIMARY KEY,
    order_no VARCHAR(50),
    user_id BIGINT,
    create_time TIMESTAMP,
    create_by BIGINT,
    dr TINYINT DEFAULT 0
);