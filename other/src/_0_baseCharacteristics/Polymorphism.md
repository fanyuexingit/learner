# 多 态（面向对象特征之一）：。
* 含义：函数本身就具备多态性，某一种事物有不同的具体的体现
* 体现：父类引用或者接口的引用指向了自己的子类对象。//Animal a = new Cat();
* 好处：提高了程序的扩展性。
* 弊端：当父类引用指向子类对象时，虽然提高了扩展性，但是只能访问父类中具备的方法，不可以访问子类中特有的方法。(前期不能使用后期产生的功能，即访问的局限性)
* 前提：
　　1. 必须要有关系，比如继承、或者实现。
　　2. 通常会有覆盖操作。
* 多态的出现思想上也做着变化：以前是创建对象并指挥对象做事情。有了多态以后，我们可以找到对象的共性类型，直接操作共性类型做事情即可，这样可以指挥一批对象做事情，即通过操作父类或接口实现。

```text
    class 毕姥爷{
　　　　void 讲课(){
　　　　　　System.out.println("企业管理");
　　　　}
　　　　void 钓鱼(){
　　　　　　System.out.println("钓鱼");
　　　　}
　　}
　　class 毕老师 extends 毕姥爷{
　　　　void 讲课(){
　　　　　　System.out.println("JAVA");
　　　　}
　　　　void 看电影(){
　　　　　　System.out.println("看电影");
　　　　}
　　}
　　class {
　　　　public static void main(String[] args) {
　　　　　　毕姥爷 x = new 毕老师(); //毕老师对象被提升为了毕姥爷类型。 
　　　　　　// x.讲课();
　　　　　　// x.看电影();  //错误.
　　　　　　毕老师 y = (毕老师)x; //将毕姥爷类型强制转换成毕老师类型。 
　　　　　　y.看电影();//在多态中，自始自终都是子类对象在做着类型的变化。
　　　　}
　　}
```

```text
   如果想用子类对象的特有方法，如何判断对象是哪个具体的子类类型呢？
　　可以可以通过一个关键字 instanceof ;//判断对象是否实现了指定的接口或继承了指定的类
 
　　格式：<对象 instanceof 类型> ，判断一个对象是否所属于指定的类型。
　　Student instanceof Person = true;//student继承了person类
 
　　多态在子父类中的成员上的体现的特点：
　  1，成员变量：在多态中，子父类成员变量同名。
　  　　在编译时期：参考的是引用型变量所属的类中是否有调用的成员。（编译时不产生对象，只检查语法错误）
　  　　运行时期：也是参考引用型变量所属的类中是否有调用的成员。
　  　　简单一句话：无论编译和运行，成员变量参考的都是引用变量所属的类中的成员变量。
　  　　再说的更容易记忆一些：成员变量 ——— 编译运行都看 = 左边。
　　2，成员函数。
　　　　编译时期：参考引用型变量所属的类中是否有调用的方法。
　　　　运行事情：参考的是对象所属的类中是否有调用的方法。
　　　　为什么是这样的呢？因为在子父类中，对于一模一样的成员函数，有一个特性：覆盖。
　　　　简单一句：成员函数，编译看引用型变量所属的类，运行看对象所属的类。
　　　　更简单：成员函数 ——— 编译看 = 左边，运行看 = 右边。
　　3，静态函数。 
　　　　编译时期：参考的是引用型变量所属的类中是否有调用的成员。
　　　　运行时期：也是参考引用型变量所属的类中是否有调用的成员。
　　　　为什么是这样的呢？因为静态方法，其实不所属于对象，而是所属于该方法所在的类。
　　　　调用静态的方法引用是哪个类的引用调用的就是哪个类中的静态方法。
　　　　简单说：静态函数 ——— 编译运行都看 = 左边。
```

* Object
```text
java.lang.Object
　　Object：所有类的直接或者间接父类，Java认为所有的对象都具备一些基本的共性内容，这些内容可以不断的向上抽取，最终就抽取到了一个最顶层的类中的，该类中定义的就是所有对象都具备的功能。
 
具体方法：
　　1，boolean equals(Object obj)：用于比较两个对象是否相等，其实内部比较的就是两个对象地址。
　　而根据对象的属性不同，判断对象是否相同的具体内容也不一样。所以在定义类时，一般都会复写equals方法，建立本类特有的判断对象是否相同的依据。
　　public boolean equals(Object obj){
　　　　if(!(obj instanceof Person))
　　　　return false;
　　　　Person p = (Person)obj;
　　　　return this.age == p.age;
　　}
　　2，String toString()：将对象变成字符串；默认返回的格式：类名@哈希值 = getClass().getName() + '@' + Integer.toHexString(hashCode())
　　为了对象对应的字符串内容有意义，可以通过复写，建立该类对象自己特有的字符串表现形式。 
　　public String toString(){
　　　　return "person : "+age;
　　}
　　3，Class getClass()：获取任意对象运行时的所属字节码文件对象。
　　4，int hashCode()：返回该对象的哈希码值。支持此方法是为了提高哈希表的性能。
 
　　通常equals，toString，hashCode，在应用中都会被复写，建立具体对象的特有的内容。
```

* 内部类
```text
如果A类需要直接访问B类中的成员，而B类又需要建立A类的对象。
这时,为了方便设计和访问，直接将A类定义在B类中。就可以了。A类就称为内部类。
内部类可以直接访问外部类中的成员。而外部类想要访问内部类，必须要建立内部类的对象。

class Outer{
　　int num = 4;
　　class  Inner {
　　　　void show(){
　　　　　　System.out.println("inner show run "+num);
　　　　}
　　}
　　public void method(){
　　Inner in = new Inner();//创建内部类的对象。
　　in.show();//调用内部类的方法。 
　　}
}
```

```text
   当内部类定义在外部类中的成员位置上，可以使用一些成员修饰符修饰 private、static。
　　1：默认修饰符。
　　　　直接访问内部类格式：外部类名.内部类名 变量名 =  外部类对象.内部类对象;
　　　　Outer.Inner in = new Outer.new Inner();//这种形式很少用。
　　　　但是这种应用不多见，因为内部类之所以定义在内部就是为了封装。想要获取内部类对象通常都通过外部类的方法来获取。这样可以对内部类对象进行控制。
　　2：私有修饰符。
　　　　通常内部类被封装，都会被私有化，因为封装性不让其他程序直接访问。 
　　3：静态修饰符。
　　　　如果内部类被静态修饰，相当于外部类，会出现访问局限性，只能访问外部类中的静态成员。
　　　　注意；如果内部类中定义了静态成员，那么该内部类必须是静态的。
 
　　内部类编译后的文件名为：“外部类名$内部类名.java”；
 
　　为什么内部类可以直接访问外部类中的成员呢？
　　　　那是因为内部中都持有一个外部类的引用。这个是引用是 外部类名.this 
　　　　内部类可以定义在外部类中的成员位置上，也可以定义在外部类中的局部位置上。
　　　　当内部类被定义在局部位置上，只能访问局部中被final修饰的局部变量。
 
　　匿名内部类：没有名字的内部类。就是内部类的简化形式。一般只用一次就可以用这种形式。匿名内部类其实就是一个匿名子类对象。想要定义匿名内部类：需要前提，内部类必须继承一个类或者实现接口。
 
　　匿名内部类的格式：new 父类名&接口名(){ 定义子类成员或者覆盖父类方法 }.方法。
 
　　匿名内部类的使用场景：
　　　　当函数的参数是接口类型引用时，如果接口中的方法不超过3个。可以通过匿名内部类来完成参数的传递。
　　　　其实就是在创建匿名内部类时，该类中的封装的方法不要过多，最好两个或者两个以内。
```

* 面试
```text
  //1
　new Object(){
　　　void show(){
　　　　　System.out.println("show run");
　　　}
　}.show();
　//2
　Object obj = new Object(){
　　　void show(){
　　　　　System.out.println("show run");
　　　}
　};
　obj.show();

　1和2的写法正确吗？有区别吗？说出原因。
　写法是正确，1和2都是在通过匿名内部类建立一个Object类的子类对象。
　区别：
　　　第一个可是编译通过，并运行。
　　　第二个编译失败，因为匿名内部类是一个子类对象，当用Object的obj引用指向时，就被提升为了
　　　Object类型，而编译时检查Object类中是否有show方法，所以编译失败。
———————————————————————————————————————————————————
　　class InnerClassDemo6 {
　　　　+（static）class Inner{
　　　　　　void show(){}
　　　　}
　　　　public void method(){
　　　　　　this.new Inner().show();//可以
　　　　}
　　　　public static void main(String[] args) {//static不允许this
　　　　　　This.new Inner().show();//错误，Inner类需要定义成static
　　　　}
　　}
——————————————————————————————————————————————————————
　　interface Inter{
　　　　void show();
　　}
　　class Outer{//通过匿名内部类补足Outer类中的代码。
　　　　public static Inter method(){
　　　　　　return new Inter(){
　　　　　　　　public void show(){}
　　　　　　};
　　　　}
　　}
　　class InnerClassDemo7 {
　　　　public static void main(String[] args) {
　　　　　　Outer.method().show();
/*
　　Outer.method():意思是：Outer中有一个名称为method的方法，而且这个方法是静态的。
　　Outer.method().show():当Outer类调用静态的method方法运算结束后的结果又调用了show方法，意味着：method()方法运算完一个是对象，而且这个对象是Inter类型的。
*/
　　　　　　function (new Inter(){
　　　　　　　　public void show(){}
　　　　　　}); //匿名内部类作为方法的参数进行传递。
　　　　}
　　　　public static void function(Inter in){
　　　　　　in.show();
　　　　}
　　}
```
