# mybatis-generator
官网：http://mybatis.org/generator/quickstart.html
## 1、command line
```
java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml
java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml -overwrite
java -cp mybatis-generator-core-x.x.x.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml
java -cp mybatis-generator-core-x.x.x.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
```
**generatorConfig.xml 文件**

以下是最简单的例子

targetRuntime含义：MyBatis3DynamicSql(default );MyBatis3Kotlin;MyBatis3;MyBatis3Simple<br>

javaClientGenerator含义 ：type:XMLMAPPER(xml方式);ANNOTATEDMAPPER(annotation方式)
```xml
<!DOCTYPE generatorConfiguration PUBLIC
 "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
 "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
	<classPathEntry  location="D:\repository\mysql\mysql-connector-java\8.0.11\mysql-connector-java-8.0.11.jar"/>
	<context id="simple" targetRuntime="MyBatis3Simple">
		<jdbcConnection driverClass="com.mysql.cj.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1/database1?serverTimezone=UTC" userId="root" password="123456"></jdbcConnection>
		<javaModelGenerator targetPackage="example.model" targetProject="src/main/java"/>
		<sqlMapGenerator targetPackage="example.mapper" targetProject="src/main/resources"/>
		<javaClientGenerator type="XMLMAPPER" targetPackage="example.mapper" targetProject="src/main/java"/>
		<table tableName="tb_user" />
	</context>
</generatorConfiguration>
```
或
```xml
<!DOCTYPE generatorConfiguration PUBLIC
 "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
 "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
	<classPathEntry  location="D:\repository\mysql\mysql-connector-java\8.0.11\mysql-connector-java-8.0.11.jar"/>
	<context id="simple" targetRuntime="MyBatis3Simple">
		<jdbcConnection driverClass="com.mysql.cj.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1/database1?serverTimezone=UTC" userId="root" password="123456"></jdbcConnection>
		<javaModelGenerator targetPackage="example.model" targetProject="src/main/java"/>
		<javaClientGenerator type="ANNOTATEDMAPPER" targetPackage="example.mapper" targetProject="src/main/java"/>
		<table tableName="tb_user" />
	</context>
</generatorConfiguration>
```
下面是标签比较全的例子

[更多标签见官网](http://mybatis.org/generator/configreference/generatorConfiguration.html)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!-- 数据库驱动:选择你的本地硬盘上面的数据库驱动包-->
    <classPathEntry  location="D:\repository\mysql\mysql-connector-java\8.0.11\mysql-connector-java-8.0.11.jar"/>
    <context id="DB2Tables"  targetRuntime="MyBatis3">
        <commentGenerator>
            <property name="suppressDate" value="true"/>
            <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>
        <!--数据库链接URL，用户名、密码 -->
        <jdbcConnection driverClass="com.mysql.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1/database1?serverTimezone=UTC" userId="root" password="123456">
        </jdbcConnection>
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>
        <!-- 生成模型的包名和位置-->
        <javaModelGenerator targetPackage="com.fan.entity" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
        <!-- 生成映射文件的包名和位置-->
        <sqlMapGenerator targetPackage="com.fan.mapper" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>
        <!-- 生成DAO的包名和位置-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.fan.mapper" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>
        <!-- 要生成的表 tableName是数据库中的表名或视图名 domainObjectName是实体类名-->
        <table tableName="user" domainObjectName="User" enableCountByExample="false" enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false"/>
    </context>
</generatorConfiguration>
```

##2、maven(MyBatis Generator (MBG) includes a Maven plugin for integration into a maven build)
**pom 文件**
```
<project ...>
     ...
     <build>
       ...
       <plugins>
        ...
        <plugin>
          <groupId>org.mybatis.generator</groupId>
          <artifactId>mybatis-generator-maven-plugin</artifactId>
          <version>1.4.0</version>
        </plugin>
        ...
      </plugins>
      ...
    </build>
    ...
  </project>
```

执行

`mvn mybatis-generator:generate`

或

`mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate` 

##3、java
###3.1利用 generatorConfig.xml 文件
```
List<String> warnings = new ArrayList<String>();
boolean overwrite = true;
File configFile = new File("generatorConfig.xml");
ConfigurationParser cp = new ConfigurationParser(warnings);
Configuration config = cp.parseConfiguration(configFile);
DefaultShellCallback callback = new DefaultShellCallback(overwrite);
MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
myBatisGenerator.generate(null);
```

###3.2纯 java 代码
```
List<String> warnings = new ArrayList<String>();
boolean overwrite = true;
Configuration config = new Configuration();

//   ... fill out the config object as appropriate...

DefaultShellCallback callback = new DefaultShellCallback(overwrite);
MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
myBatisGenerator.generate(null);
```
纯 java 完整代码如下
```
List<String> warnings = new ArrayList<String>();
boolean overwrite = true;
Configuration config = new Configuration();
config.addClasspathEntry("D:\\repository\\mysql\\mysql-connector-java\\8.0.11\\mysql-connector-java-8.0.11.jar");
Context context = new Context(FLAT);
context.setId("simple");
context.setTargetRuntime("MyBatis3Simple");
JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
jdbcConnectionConfiguration.setConnectionURL("jdbc:mysql://127.0.0.1/database1?serverTimezone=UTC");
jdbcConnectionConfiguration.setDriverClass("com.mysql.cj.jdbc.Driver");
jdbcConnectionConfiguration.setUserId("root");
jdbcConnectionConfiguration.setPassword("123456");
JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
javaModelGeneratorConfiguration.setTargetPackage("example.model");
javaModelGeneratorConfiguration.setTargetProject("src/main/java");
JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
javaClientGeneratorConfiguration.setTargetPackage("example.mapper");
javaClientGeneratorConfiguration.setTargetProject("src/main/java");
javaClientGeneratorConfiguration.setConfigurationType("ANNOTATEDMAPPER");
TableConfiguration tableConfiguration = new TableConfiguration(context);
tableConfiguration.setTableName("tb_user");
context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);
context.addTableConfiguration(tableConfiguration);
config.addContext(context);
DefaultShellCallback callback = new DefaultShellCallback(overwrite);
MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
myBatisGenerator.generate(null);
```

##4、其他方式
ant

eclipse