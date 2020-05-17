package com.hjj.toy.experience;

public class Maven {

    /**
     * 中央仓库：
     * http://repo1.maven.org/maven2/
     *
     * maven项目目录结构
       src/main/java
       src/main/resources
       src/test/java
       src/test/resources
     * groupId 组织 一般用com.xxx 小写
     * artifactId 项目 小写
     * version 版本
     * scope 依赖范围-缺省默认:主代码和测试代码;test:测试代码
     * packaging 打包 jar war pom
     *
     * 执行过程 clean:clean-resources:resources-compiler:compile-resources:testResources-compiler:testCompile-surefire:test-jar:jar-install:install-deploy:deploy
     * 构件的名称 artifactId-version.packaging
     *
     * 依赖
     * groupId
     * artifactId
     * version
     * type 对应packaging
     * scope （三套classpath-编译、测试、运行）默认是 compile-编译、测试、运行；test-测试（如junit）；provided-编译、测试（如servlet-api）；runtime-测试、运行(如jdbc);
     * system-编译、测试有效，但需要<systemPath></systemPath>元素显示指定依赖文件路径，不是通过maven仓库解析。与本机绑定
     * optional 可选
     * exclusions 排除依赖
     *
     * 仓库：本地仓库、中央仓库、私服库
     * 中央仓库-http://repo1.maven.org/maven2/
     * 配置远程仓库-在pom文件里：<repositories><repository></repository></repositories>
     * 远程仓库认证-在setting文件配置:<servers><server></server></servers>
     * 部署到远程仓库-在pom文件里：<distributionManagement><repository></repository><snapshotRepository></snapshotRepository></distributionManagement>
     * 快照版本：不稳定，snapshot后会有不同时间戳，仅用于项目内部开发阶段。
     * 解析依赖顺序：先本地再远程（会遍历所有远程仓库）
     *
     * 镜像：存储某个仓库的所有内容，提供快速服务
     * 配置镜像-在setting文件里：<mirrors><mirror>..</mirror></mirrors>
     * 一般结合私服库使用，用私服库做所有仓库镜像
     *
     * 插件：执行maven各命令，对应生命周期
     * http:maven.apache.org/plugins/index.html
     * 配置插件-pom里：<build><plugins><plugin></plugin></plugins></build>
     * 配置打包资源文件-pom里：<build><resources><resource></resource></resources></build>
     *
     * 继承：pom中可继承groupId version build dependencyManagement dependencies distributionManagement repositories 等
     * dependencyManagement 不会实际引入依赖，可以统一version和scope信息，子模块要使用这个依赖，只需要在pom中配置groupId和
     * artifactId即可
     *
     */
}
