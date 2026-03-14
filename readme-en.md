

> 🏠 Back to Home: [SimpleDAO Core Features & Design Philosophy](https://gitee.com/gao_zhenzhong/simple-dao/blob/master/readme-en.md)


## 🚀 Quick Start
No complex configuration required. Run a complete CRUD + audit + pagination + soft delete example in 5 minutes. Just run it first!
> ⚠️ Environment Requirements: JDK 21+ (required), Maven 3.9+

### 1. Build from Source
If you need to debug the framework source code locally, run the following commands to install it into your local repository:
```bash
# Clone the framework source
git clone https://gitee.com/gao_zhenzhong/simple-dao.git
cd simple-dao
# Maven package and install (Windows/Linux/Mac)
mvn clean install -DskipTests
```
> Alternatively, open the project with IDEA, right-click `Maven > Lifecycle > install` to execute.

### 2. Run Examples Quickly (Recommended)
Directly download runnable examples – ready to use out of the box, no need to build the source:
```bash
# Clone the example repository (command line is faster)
git clone https://gitee.com/gao_zhenzhong/simple-dao-demo.git
```
Or download the example packages directly:  
👉 [01 SimpleDAO Single-table CRUD, Pagination, Conditions](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo01_basic_crud)

👉 [02 SimpleDAO Join Queries, Condition Application](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo02_join_query)

👉 [03 SimpleDAO Join Queries, Advanced Conditions](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo03_condition_advance)

👉 [04 SimpleDAO Join Queries, Higher-Order Conditions](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo04_condition_join_in)

👉 [05 SimpleDAO Reporting Scenarios](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo05_report_aggregate)

👉 [06 SimpleDAO mergeParams Parameter Merging](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo06_mergeParams)

It is recommended to git clone the entire example repository.

### 3. Run Examples
1. Open the `simple-dao-demo` project's `demo01_basic_crud` module with IDEA.
2. Run the `DemoApplication` main class directly.
3. The console will automatically output complete execution logs, including:
   - Automatically generated SQL statements
   - CRUD + pagination + audit field population results
   - Soft delete execution effects

Or:
```bash
cd simple-dao-demo/v1/demo01_basic_crud
mvn spring-boot:run
# Similarly for other demos
cd ../demo02_join_query && mvn spring-boot:run
cd ../demo03_condition_advance && mvn spring-boot:run
cd ../demo04_condition_join_in && mvn spring-boot:run
cd ../demo05_report_aggregate && mvn spring-boot:run
cd ../demo06_mergeParams && mvn spring-boot:run
```

### ✨ Key Notes
- The examples include an embedded **H2 in-memory database** – no need to manually configure the database or create tables.
- After running, no additional actions are required; you can directly see the complete execution flow in the console.
- All core features (automatic ID generation, audit field population, soft delete) are enabled by default – no configuration needed.
