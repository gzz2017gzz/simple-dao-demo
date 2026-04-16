-- 用户表
CREATE TABLE IF NOT EXISTS sys_user (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INTEGER,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE,
    password VARCHAR(64) NOT NULL,
    sex TINYINT,                -- 1男 2女
    avatar VARCHAR(255),
    status TINYINT DEFAULT 1,   -- 1正常 0禁用
    birthday DATE,
    address VARCHAR(255),
    user_type TINYINT DEFAULT 1, -- 1普通 2管理员
    remark VARCHAR(500),
    create_time TIMESTAMP,
    create_by BIGINT,
    update_time TIMESTAMP,
    update_by BIGINT,
    is_deleted TINYINT DEFAULT 0         -- 逻辑删除 0未删 1已删
);