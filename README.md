## k8s demo

### 目录说明

`deploy`目录下为基础组件镜像，所有镜像均基于`alpine`构建，由于网络限制，均使用了安装包,需要构建提供同名安装包即可

`k8s-tomcat-demo`为测试部署的，无实际意义

`tomcat-session-manager` 提供了将`session`交由redis管理的基础功能，进而以此构建镜像

`user-svc` 为演示微服务-提供者，采用dubbo（后续弃用，采用springcloud）

`web` 为演示微服务-消费者，采用dubbo