-- 用户表
CREATE TABLE IF NOT EXISTS sys_user (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50) NOT NULL,          -- 用户名
    age INTEGER,                        -- 年龄
    email VARCHAR(100) UNIQUE NOT NULL, -- 邮箱
    phone VARCHAR(20) UNIQUE,           -- 手机号（新增）
    password VARCHAR(64) NOT NULL,      -- 密码（新增）
    sex CHAR(1),                        -- 性别 1男 2女（新增）
    avatar VARCHAR(255),                -- 头像地址（新增）
    status INTEGER DEFAULT 1,           -- 状态 1正常 0禁用（新增）
    birthday DATE,                      -- 生日（新增）
    address VARCHAR(255),                -- 地址（新增）
    user_type INTEGER DEFAULT 1,        -- 用户类型 1普通 2管理员（新增）
    remark VARCHAR(500),                -- 备注（新增）
    create_time TIMESTAMP,
    create_by INTEGER,
    update_time TIMESTAMP,
    update_by INTEGER,
    dr INTEGER DEFAULT 0
);

-- 订单表（用于子查询）
CREATE TABLE IF NOT EXISTS bus_order (
    id INTEGER PRIMARY KEY,
    order_no VARCHAR(50) UNIQUE NOT NULL, -- 订单编号
    user_id INTEGER NOT NULL,             -- 用户ID
    order_name VARCHAR(100),              -- 订单名称（新增）
    total_amount DECIMAL(12,2) NOT NULL,  -- 订单总金额（新增）
    pay_amount DECIMAL(12,2),             -- 实付金额（新增）
    pay_type INTEGER,                     -- 支付方式 1微信 2支付宝（新增）
    order_status INTEGER DEFAULT 0,        -- 订单状态 0待支付 1已支付 2已完成（新增）
    pay_time TIMESTAMP,                   -- 支付时间（新增）
    delivery_type INTEGER,                -- 配送方式（新增）
    receiver_name VARCHAR(50),            -- 收货人姓名（新增）
    receiver_phone VARCHAR(20),           -- 收货人电话（新增）
    receiver_address VARCHAR(255),        -- 收货地址（新增）
    remark VARCHAR(500),                 -- 订单备注（新增）
    create_time TIMESTAMP,
    create_by INTEGER,
    update_time TIMESTAMP,
    update_by INTEGER,
    dr INTEGER DEFAULT 0
);

-- 插入用户数据（严格H2语法）
INSERT INTO sys_user (id, name, age, email, phone, password, sex, avatar, status, birthday, address, user_type, remark, create_time, create_by, update_time, update_by) VALUES
(1, '张三', 25, 'zhangsan@test.com', '13800138001', 'e10adc3949ba59abbe56e057f20f883e', 1, 'https://xxx.com/avatar1.jpg', 1, '2000-01-10', '北京市海淀区', 1, '普通用户', CURRENT_TIMESTAMP, 1000, CURRENT_TIMESTAMP, 1000),
(2, '李四', 30, 'lisi@test.com', '13800138002', 'e10adc3949ba59abbe56e057f20f883e', 1, 'https://xxx.com/avatar2.jpg', 1, '1995-05-15', '上海市浦东新区', 1, '普通用户', CURRENT_TIMESTAMP, 1000, CURRENT_TIMESTAMP, 1000),
(3, '王五', 28, 'wangwu@test.com', '13800138003', 'e10adc3949ba59abbe56e057f20f883e', 2, 'https://xxx.com/avatar3.jpg', 1, '1997-09-20', '广州市天河区', 1, '普通用户', CURRENT_TIMESTAMP, 1000, CURRENT_TIMESTAMP, 1000);

-- 插入订单数据（严格H2语法）
INSERT INTO bus_order (id, order_no, user_id, order_name, total_amount, pay_amount, pay_type, order_status, pay_time, delivery_type, receiver_name, receiver_phone, receiver_address, remark, create_time, create_by, dr) VALUES
(1, 'ORD2026001', 1, '电子产品订单', 1999.00, 1999.00, 1, 1, CURRENT_TIMESTAMP, 1, '张三', '13800138001', '北京市海淀区', '尽快发货', CURRENT_TIMESTAMP, 1000, 0),
(2, 'ORD2026002', 2, '生活用品订单', 299.00, 299.00, 2, 1, CURRENT_TIMESTAMP, 1, '李四', '13800138002', '上海市浦东新区', '无需包装', CURRENT_TIMESTAMP, 1000, 0),
(3, 'ORD2026003', 1, '手机配件订单', 399.00, 399.00, 1, 1, CURRENT_TIMESTAMP, 1, '张三', '13800138001', '北京市海淀区', '加急配送', CURRENT_TIMESTAMP, 1000, 0),
(4, 'ORD2026004', 1, '电脑周边订单', 1299.00, 1299.00, 1, 1, CURRENT_TIMESTAMP, 1, '张三', '13800138001', '北京市海淀区', '正常发货', CURRENT_TIMESTAMP, 1000, 0);