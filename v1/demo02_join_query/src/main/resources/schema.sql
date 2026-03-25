-- 用户表
CREATE TABLE IF NOT EXISTS t_user (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50),
    age INTEGER,
    email VARCHAR(100),
    create_time TIMESTAMP,
    create_by INTEGER,
    update_time TIMESTAMP,
    update_by INTEGER,
    dr INTEGER DEFAULT 0
);

-- 订单表（用于子查询）
CREATE TABLE IF NOT EXISTS t_order (
    id INTEGER PRIMARY KEY,
    order_no VARCHAR(50),
    user_id INTEGER,
    create_time TIMESTAMP,
    create_by INTEGER,
    update_time TIMESTAMP,
    update_by INTEGER,    
    dr INTEGER DEFAULT 0
);

-- 插入用户数据（严格H2语法）
INSERT INTO t_user (id, name, age, email, create_time, create_by, update_time, update_by) VALUES
(1, '张三', 25, 'zhangsan@test.com', CURRENT_TIMESTAMP, 1000, CURRENT_TIMESTAMP, 1000),
(2, '李四', 30, 'lisi@test.com', CURRENT_TIMESTAMP, 1000, CURRENT_TIMESTAMP, 1000),
(3, '王五', 28, 'wangwu@test.com', CURRENT_TIMESTAMP, 1000, CURRENT_TIMESTAMP, 1000);

-- 插入订单数据（严格H2语法）
INSERT INTO t_order (id, order_no, user_id, create_time, create_by, dr) VALUES
(1, 'ORD2026001', 1, CURRENT_TIMESTAMP, 1000, 0),
(2, 'ORD2026002', 2, CURRENT_TIMESTAMP, 1000, 0);