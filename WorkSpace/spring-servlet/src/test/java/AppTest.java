import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.web.servlet.UserServlet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {
	
	@Autowired
	private UserServlet userServlet;
	
	@Test
	public void testName() throws Exception {
		System.out.println(userServlet.getClass());
		System.out.println(userServlet.getUserService().getClass());
	}
	
}
