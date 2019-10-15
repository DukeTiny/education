1. 创建maven项目

2. 配置pom.xml
	<parent>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-parent</artifactId>
	    <version>1.5.15.RELEASE</version>
	</parent>
	
	spring-boot-starter-aop
	spring-boot-starter-jdbc
	mybatis-spring-boot-starter
	spring-boot-starter-web
	mysql
	
3. 建库建表
	CREATE TABLE `users` (
	  `id` INT(11) NOT NULL AUTO_INCREMENT,
	  `name` VARCHAR(20) DEFAULT NULL,
	  `birthday` DATE DEFAULT NULL,
	  `money` DOUBLE DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8
	
4. 创建实体类
	
5. 创建dao接口
	@Repository
	public interface UsersMapper {
		@Insert("insert into users values(null, #{name}, #{birthday}, #{money})")
		public void save(Users user);
	}

6. 创建Controller
	@RestController
	public class UsersController {
		private UsersMapper mapper;
		@RequestMapping("/save")
		public String save() {
			return "save ok";
		}
	}

7. 创建主程序
	@SpringBootApplication
	@EnableTransactionManagement
	@ComponentScan("com.gao.controller")
	@MapperScan("com.gao.dao")
	public class App {
		public static void main(String[] args) {
			SpringApplication.run(App.class, args);
		}
	}
	
8. springboot主配置文件
	spring.datasource.url=jdbc:mysql://localhost:3306/test
	spring.datasource.username=root
	spring.datasource.password=123
	spring.datasource.driverClassName=com.mysql.jdbc.Driver
	mybatis.type-aliases-package=com.gao.entity
	
	
