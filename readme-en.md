
> 🏠 Back to Home: [SimpleDAO Core Features & Design Philosophy](https://gitee.com/gao_zhenzhong/simple-dao/blob/master/readme-en.md)


## 🚀 Quick Start

> ⚠️ Environment & Compatible Versions:

| Dependency     | Version Requirement | Note                    |
|----------------|---------------------|-------------------------|
| JDK            | 21+                 | Required                |
| Maven          | 3.9+                | Required                |
| Spring Boot    | 3.x                 | Recommended (tested)    |
| Swagger Core   | 2.x                 | Recommended (tested)    |

> Other versions may be compatible but are not guaranteed.


### 🎯 Demo Project Overview
| No. | Module Name | Scenario | Key Capabilities |
|:---:|-------------|----------|------------------|
| 01  | demo01_basic_crud | Single-table CRUD | Full CRUD, pagination, logical deletion, audit field population |
| 02  | demo02_join_query | Join queries | Native SQL joins, custom query logic |
| 03  | demo03_condition_advance | Complex conditions | Nested subqueries, SQL fragment composition |
| 04  | demo04_condition_join_in | IN / range queries | Automatic null-check, eliminating if-else logic |
| 05  | demo05_report_aggregate | Report aggregation | Multi-table summaries, direct database function calls |
| 06  | demo06_mergeParams | Multi-condition merging | Automatic merging of conditions from multiple sources |
| 07  | demo07_data_auth | Data permissions | Transparent, controllable, and extensible data permission system |
| 08  | demo08_desensitize | Field desensitization | Logical deletion field customization, audit field customization, field masking |
### 📦 Add Dependency
Add the following to your `pom.xml`:
```xml
<dependency>
    <groupId>io.gitee.simpledao</groupId>
    <artifactId>simple-dao</artifactId>
    <version>1.2.0</version>
</dependency>
```
This dependency is published to Maven Central, so it can be fetched directly from any standard Maven mirror worldwide without requiring a private repository.

### 1. Download the Code
```bash
git clone https://gitee.com/gao_zhenzhong/simple-dao-demo.git
```

### 2. Run the Examples
1. Open the `simple-dao-demo` project in IntelliJ IDEA and navigate to the `demo01_basic_crud` module.
2. Run the `DemoApplication` main class directly.
3. The console will automatically output complete execution logs, including:
   - Auto-generated SQL statements
   - CRUD + pagination + audit field population results
   - Logical deletion effects

Alternatively, using the command line:
```bash
cd simple-dao-demo/v1/demo01_basic_crud
mvn spring-boot:run
```

### ✨ Important Notes
- The examples come with an embedded **H2 in-memory database**—no manual database setup or table creation required.
- Simply run the application and observe the complete execution flow in the console.
- All core features (auto ID generation, audit field population, logical deletion) are enabled by default with zero configuration.
