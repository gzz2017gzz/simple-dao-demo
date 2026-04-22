> 🏠 返回主页：[SimpleDAO 核心特性 & 设计理念](https://gitee.com/gao_zhenzhong/simple-dao/blob/master/readme.md)

## 🚀 快速开始

> ⚠️ 环境要求：JDK 21+（必须）、Maven 3.9+

### 🎯 Demo工程场景速查
| 序号 | Demo工程名称 | 对应场景 | 核心能力 |
|:---:|--------------|----------|----------|
| 01  | demo01_basic_crud | 单表 CRUD | 全量 CRUD、分页、逻辑删除、审计字段填充 |
| 02  | demo02_join_query | 联表查询 | 原生 SQL 联表，自定义查询逻辑 |
| 03  | demo03_condition_advance | 复杂条件查询 | 嵌套子查询、SQL 片段拼接 |
| 04  | demo04_condition_join_in | IN/区间查询 | 自动处理非空判断，消灭 if 逻辑 |
| 05  | demo05_report_aggregate | 报表汇总 | 多表汇总、数据库函数直接调用 |
| 06  | demo06_mergeParams | 多条件合并 | 多位置条件自动合并，报表开发效率翻倍 |
| 07  | demo07_data_auth | 数据权限 | 完全透明、高度可控、易于扩展的数据权限体系|
| 08  | demo08_desensitize | 字段脱敏 | 逻辑删除字段名配置、审计字段自定义、字段脱敏 |

### 引入依赖
在你自己的项目 `pom.xml` 中添加：
```xml
<dependency>
    <groupId>io.gitee.simpledao</groupId>
    <artifactId>simple-dao</artifactId>
    <version>1.2.0</version>
</dependency>
```
### 1. 下载代码
```bash
git clone https://gitee.com/gao_zhenzhong/simple-dao-demo.git
```
 

### 2. 运行案例
1. 用 IDEA 打开 `simple-dao-demo` 项目的 `demo01_basic_crud` 模块。
2. 直接运行 `DemoApplication` 启动类。
3. 控制台自动输出完整执行日志，包含：
   - 自动生成的 SQL 语句
   - 增删改查 + 分页 + 审计字段填充结果
   - 逻辑删除执行效果

或者：
```bash
cd simple-dao-demo/v1/demo01_basic_crud
mvn spring-boot:run
```

### ✨ 关键说明
- 案例内置 **H2 内存数据库**，无需手动配置数据库、建表。
- 运行后无需任何操作，控制台可直接看到完整执行流程。
- 所有核心功能（ID 自动生成、审计字段填充、逻辑删除）已默认开启，无需任何配置。