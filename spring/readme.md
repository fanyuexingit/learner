# Spring
## 1. Spring Framework
* core (**_IoC Container_**, **_AOP_**, Validation, Data Binding, Type Conversion...)
* testing (Mock Objects, TestContext Framework, Spring MVC Test)
* data access (Transactions, DAO Support, JDBC, O/R Mapping)
* web servlet (**_Spring MVC_**, WebSocket, SockJS, STOMP Messaging)
* web reactive (Spring WebFlux, WebClient, WebSocket)
* integration (Remoting, JMS, JCA, JMX, Email, Tasks, Scheduling, Caching)

## 2. IOC(概念) DI(一种具体实现) 代码发展史
1. 对象通过 new 创建，改业务需要改代码，对象耦合，耦合性特别大
2. 反射加工厂方式，字符串耦合，但要修改Dao的实现类，还是得修改service层的源代码
3. 把字符串写进文件，如properties，读取文件，就不用了直接改代码了，但是需要维护文件
4. 利用泛型和注入（分为setter和constructor）
5. **spring ioc(xml, annotation, java config)**

### 2.1 xml
* setter injection vs constructor injection
    * Constructor注入能够强制要求调用者注入构造函数中的所有参数，否则在容器初始化时就会失败；但是如果要注入的对象过多，就会导致构造函数过于庞大。
    * Setter注入，类似于Builder模式，将原本庞大的构造函数，拆解为了一个小的构造函数和许多个set方法。setter注入不能保证对象一定会被注入，但是可以使用@Required注解，强制要求使用者注入对象，否则在容器初始化时就会报错。
* xml方式简略代码如下
```
ApplicationContext context = new ClassPathXmlApplicationContext("ioc1.xml");
PersonService personService = (PersonServiceImpl)context.getBean("personServiceImpl");
personService.add(person);
```
* 缺点：类型不安全，例如xml文件字符串拼写错误
### 2.2 annotation
* 注解
    * @Component 作用于实现类上，注意区分@bean
    * @Configuration 配置类
    * @ComponentScan(basePackageClasses={PersonServiceImpl.class, PersonDaoImpl.class}) 扫描包
    * @Autowired 作用于setter constructor properties，表示注入，注意区分@jection
        * @required
    * @RunWith(SpringJUnit4ClassRunner.class) 用于测试类上
    * @ContextConfiguration(classes= PersonAnnotationConfig.class) 用于测试类上
* 缺点：@Component修饰不了第三方包里的类
### 2.3 java config
* 注解
    * @Bean 作用在配置类里的bean
* 优点：方面 自由 没有侵入性


### 2.4 bean的作用域(scope)
1. Singleton
* 当一个bean的作用域为Singleton，那么Spring IoC容器中只会存在一个共享的bean实例，并且所有对bean的请求，只要id与该bean定义相匹配，则只会返回bean的同一实例。Singleton是单例类型，就是在创建起容器时就同时自动创建了一个bean的对象，不管你是否使用，他都存在了，每次获取到的对象都是同一个对象。注意，Singleton作用域是Spring中的缺省作用域。
2. Prototype
* 当一个bean的作用域为Prototype，表示一个bean定义对应多个对象实例。Prototype作用域的bean会导致在每次对该bean请求（将其注入到另一个bean中，或者以程序的方式调用容器的getBean()方法）时都会创建一个新的bean实例。Prototype是原型类型，它在我们创建容器的时候并没有实例化，而是当我们获取bean的时候才会去创建一个对象，而且我们每次获取到的对象都不是同一个对象。根据经验，对有状态的bean应该使用prototype作用域，而对无状态的bean则应该使用singleton作用域。
3. Request
* 当一个bean的作用域为Request，表示在一次HTTP请求中，一个bean定义对应一个实例；即每个HTTP请求都会有各自的bean实例，它们依据某个bean定义创建而成。该作用域仅在基于web的Spring ApplicationContext情形下有效。
* 针对每次HTTP请求，Spring容器会根据loginAction bean的定义创建一个全新的LoginAction bean实例，且该loginAction bean实例仅在当前HTTP request内有效，因此可以根据需要放心的更改所建实例的内部状态，而其他请求中根据loginAction bean定义创建的实例，将不会看到这些特定于某个请求的状态变化。当处理请求结束，request作用域的bean实例将被销毁。
4. Session
* 当一个bean的作用域为Session，表示在一个HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。
* 针对某个HTTP Session，Spring容器会根据userPreferences bean定义创建一个全新的userPreferences bean实例，且该userPreferences bean仅在当前HTTP Session内有效。与request作用域一样，可以根据需要放心的更改所创建实例的内部状态，而别的HTTP Session中根据userPreferences创建的实例，将不会看到这些特定于某个HTTP Session的状态变化。当HTTP Session最终被废弃的时候，在该HTTP Session作用域内的bean也会被废弃掉。

### 2.5 总结
|XXX                    |xml   |annotation   |java config   |
|---|---|---|---|
|类型是否安全            |N   |Y   |Y |
|查找实现类是否方便       |N   |Y   |Y   |
|可读性                 |N   |Y   |Y   |
|简洁性                 |N   |Y   |Y   |
|修改配置是否需要重新编译 |xml   |java   |java   |
|是否会代码入侵          |N   |Y   |N   |
|自由度                 |低   |低   |高   |
|是否可注入第三方类       |Y   |N   |Y   |

* xml配置相对于其他两种方式来说，几乎没什么优势，唯一的优势就是修改后不需要重新编译，因此对于一些经常切换实现类的对象，可以采用xml的方式进行配置。还有就是由于xml是Spring一开始就提供的配置方式，因此很多旧代码还是采用xml，所以在维护旧代码时会免不了用到xml。
* 注解用起来非常地简洁，代码量十分少，因此是项目的第一选择。只有当需要注入代码不是自己维护的第三方jar包中的类时，或者需要更为灵活地注入，比如说需要调用某个接口，查询数据，然后把这个数据赋值给要注入的对象，那么这时候就需要用到Java Config。

## 3. AOP 
1. 静态代理
    1. 基于接口
    2. 基于类
2. 动态代理
    1. jdk代理
    2. cglib代理
3. 工厂
4. **spring aop** （目标有接口，动态代理；目标没接口，cglib代理）

### 3.1 xml
* 配置文件
```xml
<!--切面类-->
<bean id="aop" class="com.fan.learn.aop1.Aop"></bean>
<!--AOP配置-->
<aop:config>
    <!--切点方法-->
    <aop:pointcut id="pt" expression="execution(* com.fan.learn.aop1..*.*(..))"/>
    <!--<aop:pointcut id="pt" expression="com.fan.learn.aop1.Aop.pt()"/>-->
    <!--切面类-->
    <aop:aspect ref="aop">
        <!--切面方法-->
        <aop:before method="begin" pointcut-ref="pt"></aop:before>
        <aop:before method="after" pointcut-ref="pt"></aop:before>
    </aop:aspect>
</aop:config>
```
### 3.2 annotation
* 配置类
```
@Configuration
@ComponentScan(basePackages = "com.fan.learn.aop1")
@EnableAspectJAutoProxy
```
* 关键注解：
    * @EnableAspectJAutoProxy
    * @Component
    * @Aspect  指定一个类为切面类
    * @Pointcut("execution(* com.fan.learn.aop1..*.*(..))") 指定切入点表达式
    * @Before   前置通知: 目标方法之前执行
    * @After    后置通知：目标方法之后执行（始终执行）
    * @AfterReturning    返回后通知： 执行方法结束前执行(异常不执行)
    * @AfterThrowing    异常通知:  出现异常时候执行
    * @Around   环绕通知： 环绕目标方法执行
* 切入点表达式
    * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
    ```
    符号讲解：
    ?号代表0或1，可以不写
    “*”号代表任意类型，0或多
    方法参数为..表示为可变参数
    
    参数讲解：
    modifiers-pattern?【修饰的类型，可以不写】
    ret-type-pattern【方法返回值类型，必写】
    declaring-type-pattern?【方法声明的类型，可以不写】
    name-pattern(param-pattern)【要匹配的名称，括号里面是方法的参数】
    throws-pattern?【方法抛出的异常类型，可以不写】
    ```
### 3.3 java config
* 略

## 4. dao
### 4.1 spring dao(data access object)
* 略
### 4.2 事务的隔离级别
|事务的隔离级别                    |可能出现   |可以解决               |原因|
|---|---|---|---|
|TRANSACTION_READ_UNCOMMITTED   |脏读       |X                    |未提交 |
|TRANSACTION_READ_COMMITTED     |不可重复读  |脏读                 |未锁行   |
|TRANSACTION_REPEATABLE_READ    |幻读       |脏读 不可重复读         |未锁表   |
|TRANSACTION_SERIALIZABLE       |X          |脏读 不可重复读 幻读    |X   |
### 4.2 事务的传播方式
|事务的传播方式               |解释   |
|---|---|
|PROPAGATION_REQUIRED       |如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择       |
|PROPAGATION_SUPPORTS       |支持当前事务，如果当前没有事务，就以非事务方式执行                                            |
|PROPAGATION_MANDATORY      |使用当前的事务，如果当前没有事务，就抛出异常                                                 |
|PROPAGATION_REQUIRES_NEW   |新建事务，如果当前存在事务，把当前事务挂起                                                   |
|PROPAGATION_NOT_SUPPORTED  |以非事务方式执行操作，如果当前存在事务，就把当前事务挂起                                       |
|PROPAGATION_NEVER          |以非事务方式执行，如果当前存在事务，则抛出异常                                               |
|PROPAGATION_NESTED         |如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作   |
