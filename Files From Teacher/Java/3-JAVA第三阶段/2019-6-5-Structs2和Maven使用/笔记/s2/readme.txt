什么是框架：
框架就是半成品，框架会把通用功能提前封装好。框架的使用者就不用重写通用的功能。

框架的作用：
提高开发效率，能够达到事半功倍的效果。


什么是MVC
M model  		模型
V view   		视图
C controller 	控制器


struts2就是一个框架，而且是一个MVC框架。

也就是说，使用了struts2框架，就是让mvc开发变得简单！！


=====================================================================

搭建struts2环境
a. 导入依赖：
	<!-- https://mvnrepository.com/artifact/org.apache.struts/struts2-core -->
	<dependency>
	    <groupId>org.apache.struts</groupId>
	    <artifactId>struts2-core</artifactId>
	    <version>2.5.20</version>
	</dependency>

b. 在web.xml中，配置struts2的“前端控制器”
	<?xml version="1.0" encoding="UTF-8"?>
	<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">
		<filter>
			<filter-name>StrutsPrepareAndExecuteFilter</filter-name>
			<filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>StrutsPrepareAndExecuteFilter</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
	</web-app> 

c. 在com.woniuxy.web.action中，创建一个控制器：
	public class UserAction {
		public void f1() {
			System.out.println("UserAction.f1()");
		}
	}
	
d. 在src/main/resources下创建struts2的配置文件：struts.xml
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE struts PUBLIC
		"-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
		"http://struts.apache.org/dtds/struts-2.5.dtd">
	<struts>
		<package name="default" namespace="/user" extends="struts-default">
			<action name="abc" class="com.woniuxy.web.action.UserAction" method="f1">
			</action>
		</package>
	</struts>
	
	
==================================================================================

struts2运行原理（简易版） 看图即可！

	

