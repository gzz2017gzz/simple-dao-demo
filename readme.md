以下是完整的「快速开始」章节，包含修正后的场景速查表（竖版），可直接替换你仓库 `readme.md` 中的对应内容：

```markdown
> 🏠 返回主页：[SimpleDAO 核心特性 & 设计理念](https://gitee.com/gao_zhenzhong/simple-dao/blob/master/readme.md)

## 🚀 快速开始
无需复杂配置，5分钟跑通完整 CRUD + 审计 + 分页 + 逻辑删除示例，先跑起来再说！
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

### 1. 从源码构建
如果需要本地调试框架源码，执行以下命令安装到本地仓库：
```bash
# 克隆框架源码
git clone https://gitee.com/gao_zhenzhong/simple-dao.git
cd simple-dao
# Maven 打包安装（Windows/Linux/Mac 通用）
mvn clean install -DskipTests
```
> 也可直接用 IDEA 打开项目，右键 `Maven > Lifecycle > install` 执行

### 2. 快速运行案例（推荐）
直接下载可运行案例，开箱即用，无需构建源码：
```bash
# 克隆案例仓库（推荐命令行方式，更快捷）
git clone https://gitee.com/gao_zhenzhong/simple-dao-demo.git
```
或直接下载案例包：  
👉 [01 SimpleDAO 单表 CRUD、分页、条件](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo01_basic_crud)  
👉 [02 SimpleDAO 联表、条件应用](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo02_join_query)  
👉 [03 SimpleDAO 联表、条件进阶](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo03_condition_advance)  
👉 [04 SimpleDAO 联表、条件高阶](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo04_condition_join_in)  
👉 [05 SimpleDAO 报表场景](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo05_report_aggregate)  
👉 [06 SimpleDAO mergeParams 参数合并](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo06_mergeParams)

推荐用 `git clone` 整个案例仓库。

### 3. 运行案例
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
# 其他模块类似
cd ../demo02_join_query && mvn spring-boot:run
cd ../demo03_condition_advance && mvn spring-boot:run
cd ../demo04_condition_join_in && mvn spring-boot:run
cd ../demo05_report_aggregate && mvn spring-boot:run
cd ../demo06_mergeParams && mvn spring-boot:run
```

### ✨ 关键说明
- 案例内置 **H2 内存数据库**，无需手动配置数据库、建表。
- 运行后无需任何操作，控制台可直接看到完整执行流程。
- 所有核心功能（ID 自动生成、审计字段填充、逻辑删除）已默认开启，无需任何配置。
```

**改动说明**：
- 修正了原文中的“CURD”为“CRUD”。
- 表格第一列使用居中标记 `:---:`，表头清晰。
- 运行案例的 `cd` 命令合并为一行，并添加了注释。
- 链接列表用换行分隔，保持整洁。

你可以直接复制以上内容到你的 `readme.md` 中，覆盖原有的「快速开始」部分。