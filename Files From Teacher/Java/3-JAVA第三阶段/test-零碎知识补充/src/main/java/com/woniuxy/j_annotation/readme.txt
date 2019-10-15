注解是从jdk1.5版本引入的。 主要目的是代替xml配置方式。 

java中的注解，分为3类：
1. jdk内置注解， 就是jdk中提前定义好的注解，可以直接拿来使用
	a. @Override，用于方法之上，表示方法必须重写父类的方法，否则会报错！
	b. @SuppressWarning，抑制警告
	c. @Deprecated，用于标注某个api已过时
	
2. 元注解，元注解就是描述注解的注解。
	a. @Target，用于指定自定义的注解，能用在什么地方
		类	字段	构造器	方法	形参	局部变量  	（包）
	b. @Retenttion，用于指定自定义的注解，保留在什么级别
		SOURCE 把该元注解所描述的自定义注解，只保留在源代码级别。
		CLASS  把该元注解所描述的自定义注解，保留在源代码级别，和字节码级别
		RUNTIME 把该元注解所描述的自定义注解，保留在源代码级别、字节码级别以及运行时级别
		注意，只有RUNTIME级别，才能利用反射机制把注解信息反射出来！
	c. @Inherit 让该元注解所描述的自定义注解，也能被子类继承，所以利用子类的字节码也能反射出父类的被标注了 @Inherit的注解
	
3. 自定义注解
	注解属性的那些事儿....
	
	
4. 利用反射机制，反射出注解：
	clazz.getAnnotations()，获取一个类上的所有注解
	clazz.getAnnotation(Class clazz) 获取一个类上的指定类型的注解，如果没有则返回null
	clazz.isAnnotationPresent(Class clazz) 判断一个类上是否有某个注解！


	
