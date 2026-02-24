
## 🚀 快速开始
无需复杂配置，5分钟跑通完整CRUD+审计+分页+逻辑删除示例，先跑起来再说！
> ⚠️ 环境要求：JDK 21+（必须）、Maven 3.9+

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
👉 [simple-dao-demo/v1/demo01_basic_crud](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo01_basic_crud)

推荐用 git clone 整个案例仓库

### 3. 运行案例
1. 用 IDEA 打开 `simple-dao-demo` 项目的demo01_basic_crud 模块
2. 直接运行 `DemoApplication` 启动类
3. 控制台自动输出完整执行日志，包含：
   - 自动生成的 SQL 语句
   - 增删改查+分页+审计字段填充结果
   - 逻辑删除执行效果

或者：
```bash
cd simple-dao-demo/v1/demo01_basic_crud
mvn spring-boot:run
```

### ✨ 关键说明
- 案例内置 **H2 内存数据库**，无需手动配置数据库、建表
- 运行后无需任何操作，控制台可直接看到完整执行流程
- 所有核心功能（ID 自动生成、审计字段填充、逻辑删除）已默认开启,无需任何配置


🏠 返回主页：[SimpleDAO-Readme](https://gitee.com/gao_zhenzhong/simple-dao/blob/master/readme.md)
