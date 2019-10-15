servlet生命周期
1. 在客户端浏览器第一次访问servlet的时候，servlet容器（tomcat）就会实例化servlet。
	该实例会驻留在内存中，以便响应后续请求。
2. 在servlet容器实例化servlet之后，servlet容器就会调用servlet的init方法，
          该方法在整个servlet生命周期之间只执行一次！
3. 在每次servlet接受到请求的时候，都会调用service方法。
4. 在web应用即将被卸载的时候，servlet容器就会调用servlet的destroy方法，
         该方法在整个servlet生命周期之间只执行一次！
         
补充，当配置servlet时，加上了<load-on-startup>1</load-on-startup>时，
那么在web应用被部署的时候，servlet容器（tomcat）就会实例化servlet！

注意，得出一个结论： 此时，servlet是tomcat实例化的！