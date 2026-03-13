

```markdown
> 🏠 Back to Home: [SimpleDAO Core Features & Design Philosophy](https://gitee.com/gao_zhenzhong/simple-dao/blob/master/readme-en.md)

## 🚀 Quick Start
No complex configuration required - run a complete CRUD + Audit + Pagination + Logical Delete example in 5 minutes. Just get it up and running first!
> ⚠️ Environment Requirements: JDK 21+ (Mandatory), Maven 3.9+

### 1. Build from Source Code
If you need to debug the framework source code locally, execute the following command to install it to your local repository:
```bash
# Clone the framework source code
git clone https://gitee.com/gao_zhenzhong/simple-dao.git
cd simple-dao
# Maven package and install (Works for Windows/Linux/Mac)
mvn clean install -DskipTests
```
> Alternatively, open the project directly with IDEA, then right-click `Maven > Lifecycle > install` to execute.

### 2. Run the Demo Quickly (Recommended)
Download the runnable demo directly - out-of-the-box, no need to build source code:
```bash
# Clone the demo repository (Command line is recommended for faster access)
git clone https://gitee.com/gao_zhenzhong/simple-dao-demo.git
```
Or download the demo package directly:  
👉 [simple-dao-demo/v1/demo01_basic_crud](https://gitee.com/gao_zhenzhong/simple-dao-demo/tree/master/v1/demo01_basic_crud)

It is recommended to clone the entire demo repository using `git clone`.

### 3. Run the Demo
1. Open the `demo01_basic_crud` module of the `simple-dao-demo` project with IDEA
2. Run the `DemoApplication` startup class directly
3. The console will automatically output the complete execution logs, including:
   - Automatically generated SQL statements
   - Results of CRUD + Pagination + Audit Field Population
   - Execution effect of Logical Delete

Alternatively:
```bash
cd simple-dao-demo/v1/demo01_basic_crud
mvn spring-boot:run
```

### ✨ Key Notes
- The demo comes with an embedded **H2 in-memory database** - no need to manually configure a database or create tables
- No manual operations are required after running; the complete execution process can be directly viewed in the console
- All core features (Auto ID Generation, Audit Field Population, Logical Delete) are enabled by default with zero configuration
```
