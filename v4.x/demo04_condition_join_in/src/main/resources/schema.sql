-- 1.用户表（3条）
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
    id BIGINT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(50),
    dr TINYINT DEFAULT 0 COMMENT '删除标记 0-未删 1-已删'
);
INSERT INTO sys_user (id, name, age, email) VALUES
(1, '张三', 25, 'zhangsan@test.com'),
(2, '李四', 30, 'lisi@test.com'),
(3, '王五', 28, 'wangwu@test.com');

-- 2.订单表（4条）- 新增时间/操作人字段
DROP TABLE IF EXISTS bus_order;
CREATE TABLE bus_order (
    id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL COMMENT '关联t_user.id',
    order_no VARCHAR(30) NOT NULL COMMENT '订单号',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    create_by BIGINT NOT NULL COMMENT '创建人',
    update_time DATETIME NOT NULL COMMENT '修改时间',
    update_by BIGINT NOT NULL COMMENT '修改人',
    dr TINYINT DEFAULT 0 COMMENT '删除标记 0-未删 1-已删',
    FOREIGN KEY (user_id) REFERENCES sys_user(id)
);
-- 初始化数据：时间字段用固定值，操作人关联用户ID，贴合业务
INSERT INTO bus_order (id, user_id, order_no, create_time, create_by, update_time, update_by) VALUES
(1, 1, 'ORD2026001', '2026-02-01 10:00:00', 1, '2026-02-01 10:00:00', 1),
(2, 1, 'ORD2026002', '2026-02-02 14:30:00', 1, '2026-02-02 14:30:00', 1),
(3, 2, 'ORD2026003', '2026-02-03 09:15:00', 2, '2026-02-03 09:15:00', 2),
(4, 3, 'ORD2026004', '2026-02-04 16:20:00', 3, '2026-02-04 16:20:00', 3);

-- 3.商品表（3条）
DROP TABLE IF EXISTS bus_goods;
CREATE TABLE bus_goods (
    id BIGINT PRIMARY KEY,
    order_id BIGINT NOT NULL COMMENT '关联t_order.id',
    goods_name VARCHAR(50) NOT NULL COMMENT '商品名',
    price DECIMAL(10,2) NOT NULL COMMENT '商品价格',
    dr TINYINT DEFAULT 0 COMMENT '删除标记 0-未删 1-已删',
    FOREIGN KEY (order_id) REFERENCES bus_order(id)
);
INSERT INTO bus_goods (id, order_id, goods_name, price) VALUES
(1, 1, '手机', 1999.00),
(2, 2, '耳机', 199.00),
(3, 3, '键盘', 299.00);