# 包结构
>基础包名（com.guying.fourlayer)

|-adapter          # 适配器层，负责应用与外部交互，包含 Web 控制器、定时任务适配器、消息适配器等适配器，主要处理输入解析、验证、转换、序列化/反序列化、用户登录权限校验等。
    |---consumer            # 可选。消费服务。类命名为xxxConsumer.java，定义接口，基础设施按照消息中间件不同定义实现
    |---controller          # 接口层，⾯向UI提供controller接⼝定义，负责输⼊输出参数获取、解析、参数校验等。命名 xxxController.java
    |---etin                # 对接etin页面的配置。
    |---ghost               # 对接倚天ghost。命名 xxxGhostAdapterImpl.java，注意，要添加@Service注解
    |---model               # 可选。输入输出对象及转换器。xxxRequest.java，xxxResponse.java，xxxConverter.java
        |-----converter     # 可选。输入输出参数与dto的转换。类命名为xxxConverter.java
        |-----request       # 可选。输入参数。类命名为xxxRequest.java，如果和application中的DTO，可以直接使用DTO
        |-----response      # 可选。输出参数。类命名为xxxResponse.java，如果和application中的DTO，可以直接使用DTO
    |---scheduler           # 处理定时任务。类命名为xxxTask.java 或 xxxJob.java

|-application      # app层/应用服务层，面向用例设计，主要负责处理跨域业务流程的组合编排、事务处理等，可以调用领域层，也可以直接调用基础设施层。不包含业务逻辑。
|---
|---
|---
|---
|---
|---

|-domain           # 领域层，定义业务模型，通过领域服务和领域对象行为封装核心业务逻辑。另外在领域层定义support接口，在Infrastructure层进行实现， 利用依赖倒置实现业务领域和外部依赖的解耦。
|-infrastructure   # 基础设施层，实现领域层support接口，封装持久化操作和外部依赖防腐，包括DB、redis、消息中间件、外部接口等。通过基础设施层对外部依赖进行防腐，将外部依赖提供的能力包裹⼀层，当依赖发⽣变化时，只需要修改infrastructure的具体实现即可，对于上层逻辑来说，无论外部环境发生什么变化，业务逻辑本身不需要改动。







# 统一日志打印
