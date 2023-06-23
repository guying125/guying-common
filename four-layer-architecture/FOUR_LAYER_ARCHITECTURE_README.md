# 包结构
>基础包名（com.guying.fourlayer)

```text
|-adapter                       # 适配器层，负责应用与外部交互，包含 Web 控制器、定时任务适配器、消息适配器等适配器，主要处理输入解析、验证、转换、序列化/反序列化、用户登录权限校验等。
    |--consumer                 # 可选。消费服务。类命名为xxxConsumer.java，定义接口，基础设施按照消息中间件不同定义实现
    |--controller               # 接口层，⾯向UI提供controller接⼝定义，负责输⼊输出参数获取、解析、参数校验等。命名 xxxController.java
        |--xxx                  # 基于业务模块拆分不同的包
        |--yyy                  # 基于业务模块拆分不同的包
    |--etin                     # 对接etin页面的配置。
    |--ghost                    # 对接ghost。命名 xxxGhostAdapter.java    
    |--health                   # 健康探针。xxxHealthProbe.java
    |--model                    # 可选。输入输出对象及转换器。xxxRequest.java，xxxResponse.java，xxxConverter.java
        |---converter           # 可选。输入输出参数与dto的转换。类命名为xxxConverter.java
        |---request             # 可选。输入参数。类命名为xxxRequest.java，如果和application中的DTO，可以直接使用DTO
        |---response            # 可选。输出参数。类命名为xxxResponse.java，如果和application中的DTO，可以直接使用DTO
    |--scheduler                # 处理定时任务。类命名为xxxTask.java 或 xxxJob.java
|-application                   # app层/应用服务层，面向用例设计，主要负责处理跨域业务流程的组合编排、事务处理等，可以调用领域层，也可以直接调用基础设施层。不包含业务逻辑。
    |--xxx                      # 基于业务模块拆分不同的包
        |---assembler           # 输入输出参数转换。XxxAssembler.java。推荐使用 mapstruct 进行对象转换
        |---service             # app层接口。命名XxxService.java
            |----impl           # app层接口实现类。命名XxxServiceImpl.java
        |---support             # 可选。application层调用infrastructure层时的接口定义，返回application层定义的DTO
        |---wrapper             # DTO、request等数据传输对象。命名 xxxDTO.java、xxxRequest.java 等
            |----dto            # DTO传输对象。命名XxxDTO.java对象
            |----request        # 可选。
            |----response       # 可选。
    |--yyy                      # 基于业务模块拆分不同的包
|-domain                        # 领域层，定义业务模型，通过领域服务和领域对象行为封装核心业务逻辑。另外在领域层定义support接口，在Infrastructure层进行实现， 利用依赖倒置实现业务领域和外部依赖的解耦。
    |--xxx                      # 基于业务模块拆分不同的包
        |---domainservice       # 领域服务接口。命名 XxxDomainService.java
            |----impl           # 领域服务实现类。领域服务实现类，领域服务，跨实体操作，或者复杂业务规则。命名 xxxDomainServiceImpl.java
        |---entity              # 实体对象。命名 xxxEntity.java
        |---factory             # 定义工厂方法，封装领域对象的创建，类命名为实体+Factory
        |---support             # 调用infrastructure层时的接口定义，返回domain层定义的VO或DTO
            |----event          # 可选，事件相关的接口定义。类命名xxxEventSupport，其中xxx为实体或者模块含义
            |----gateway        # 调用第三方/网关层（接口）。命名 xxxGateway.java
            |----repository     # 持久层仓库（接口）。命名 xxxRepository.java
        |---valueobject         # 值对象，命名XxxVO.java
    |--yyy                      # 基于业务模块拆分不同的包
|-infrastructure                # 基础设施层，实现领域层support接口，封装持久化操作和外部依赖防腐，包括DB、redis、消息中间件、外部接口等。通过基础设施层对外部依赖进行防腐，将外部依赖提供的能力包裹⼀层，当依赖发⽣变化时，只需要修改infrastructure的具体实现即可，对于上层逻辑来说，无论外部环境发生什么变化，业务逻辑本身不需要改动。
    |--xxx                      # 基于业务模块拆分不同的包
        |---converter           # 数据对象转换，将数据库PO和第三方DTO对象转换为领域对象，命名为xxxConverter
        |---mapper              # 数据库访问，命名为xxxMapper.java，xxx对应数据库表名
            |----dto            # application层直接查询返回场景，可能需要关联多张表查询，定义查询对象DTO承载查询结果
            |----po             # 持久化对象，命名为xxxPO.java
        |---supportimpl         # 领域层仓储接口实现
            |----repository     # 持久层仓库实现类。命名 xxxRepositoryImpl.java
            |----gateway        # 网关层实现类。命名 xxxGatewayImpl.java
                |-----dto       # 传输对象
    |--yyy                      # 基于业务模块拆分不同的包
    |--commons                  # 通用配置
        |---client              # 
        |---cache               # 
        |---interceptor         # 
        |---validator           # 
        |---elasticsearch       # 
        |---annotation          # 注解（自定义注解）
        |---aspect              # 切面
        |---config              # 配置类
            |----datasource     # 
            |----xxx            # 
        |---consts              # 常量类
        |---enums               # 枚举类
        |---global              # 全局
        |---util                # 工具类
```

# 统一日志打印
