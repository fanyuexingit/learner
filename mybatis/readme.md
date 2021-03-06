#mybatis
官网：https://mybatis.org/mybatis-3/getting-started.html
##1. 准备
用mybatis-generator生成mapper层和model层代码

包括model.java, mapper.java + mapper.xml(或 有注解的mapper.java )

##2. mybatis配置文件
mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!-- 根标签 -->
<configuration>
    <properties>
        <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://127.0.0.1:3306/database1?serverTimezone=Asia/Shanghai&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;allowMultiQueries=true"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </properties>

    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    <!--        <setting name="cacheEnabled" value="true"/>-->
    <!--        <setting name="lazyLoadingEnabled" value="true"/>-->
    <!--        <setting name="multipleResultSetsEnabled" value="true"/>-->
    <!--        <setting name="useColumnLabel" value="true"/>-->
    <!--        <setting name="useGeneratedKeys" value="false"/>-->
    <!--        <setting name="autoMappingBehavior" value="PARTIAL"/>-->
    <!--        <setting name="autoMappingUnknownColumnBehavior" value="WARNING"/>-->
    <!--        <setting name="defaultExecutorType" value="SIMPLE"/>-->
    <!--        <setting name="defaultStatementTimeout" value="25"/>-->
    <!--        <setting name="defaultFetchSize" value="100"/>-->
    <!--        <setting name="safeRowBoundsEnabled" value="false"/>-->
    <!--        <setting name="mapUnderscoreToCamelCase" value="false"/>-->
    <!--        <setting name="localCacheScope" value="SESSION"/>-->
    <!--        <setting name="jdbcTypeForNull" value="OTHER"/>-->
    <!--        <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/>-->
    </settings>
    <!--    <typeAliases>-->
    <!--        <typeAlias alias="Author" type="domain.blog.Author"/>-->
    <!--    </typeAliases>-->
    <!--    <typeHandlers>-->
    <!--        <typeHandler handler="org.mybatis.example.ExampleTypeHandler"/>-->
    <!--    </typeHandlers>-->
    <!--    <objectFactory type="org.mybatis.example.ExampleObjectFactory">-->
    <!--        <property name="someProperty" value="100"/>-->
    <!--    </objectFactory>-->
    <!--    <plugins>-->
    <!--        <plugin interceptor="org.mybatis.example.ExamplePlugin">-->
    <!--            <property name="someProperty" value="100"/>-->
    <!--        </plugin>-->
    <!--    </plugins>-->

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC">
                <!--                <property name="..." value="..."/>-->
            </transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>

    <!--    <databaseIdProvider type="DB_VENDOR">-->
    <!--        <property name="SQL Server" value="sqlserver"/>-->
    <!--        <property name="DB2" value="db2"/>-->
    <!--        <property name="Oracle" value="oracle" />-->
    <!--    </databaseIdProvider>-->

    <mappers>
        <mapper resource="mappers/userMapper.xml" />
    </mappers>

</configuration>

```
##3. 读取配置文件并使用
###3.1 读取xml文件方式
```
InputStream inputStream = Surrogate.Generator.class.getResourceAsStream("/mybatis-config.xml");
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
SqlSession sqlSession = sqlSessionFactory.openSession();
```

###3.2 java代码方式
```
PooledDataSource pooledDataSource = new PooledDataSource();
pooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
pooledDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/database1?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true");
pooledDataSource.setUsername("root");
pooledDataSource.setPassword("123456");
TransactionFactory transactionFactory = new JdbcTransactionFactory();
Environment environment = new Environment("development", transactionFactory, pooledDataSource);
Configuration configuration = new Configuration(environment);
configuration.addMapper(TbUserMapper.class);
return configuration;
```
###3.3 操作方式
```
TbUserMapper mapper = sqlSession.getMapper(TbUserMapper.class);
TbUser tbUser = mapper.selectByPrimaryKey(1);
```