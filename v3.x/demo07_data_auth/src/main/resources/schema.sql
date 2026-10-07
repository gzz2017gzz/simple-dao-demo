-- 用户表
CREATE TABLE IF NOT EXISTS sys_user (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    posts VARCHAR(100)  -- 岗位，用于模拟身份判断
);

-- 公告表
CREATE TABLE IF NOT EXISTS sys_notice (
    id BIGINT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(500),
    receiver BIGINT  -- 接收人ID，用于数据权限过滤
);

-- 测试数据
INSERT INTO sys_user (id, name, posts) VALUES (1001, '张三', 'repairer');
INSERT INTO sys_user (id, name, posts) VALUES (1002, '李四', 'manager');
INSERT INTO sys_user (id, name, posts) VALUES (0, '系统', 'system');

INSERT INTO sys_notice (id, title, content, receiver) VALUES (1, '维修通知', '明天检修', 1001);
INSERT INTO sys_notice (id, title, content, receiver) VALUES (2, '管理通知', '季度会议', 1002);
INSERT INTO sys_notice (id, title, content, receiver) VALUES (3, '全员通知', '放假安排', 0); -- receiver=0 表示全员可见