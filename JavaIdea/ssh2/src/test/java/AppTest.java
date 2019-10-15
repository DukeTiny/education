import com.cxz.RootConfig;
import com.cxz.dao.IDeptDao;
import com.cxz.dao.IEmpDao;
import com.cxz.domain.Dept;
import com.cxz.domain.Emp;
import com.cxz.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {

    @Autowired
    private IDeptService service;

    @Test
    public void test() throws Exception {
        Dept d1 = new Dept();
        Dept d2 = new Dept();
        d1.setDname("Design@@");
        d2.setDname("Sale@@");
        service.save(d1);
        service.save(d2);
//        IEmpDao empService = (IEmpDao) ctx.getBean("empDaoImpl");
//
//        Emp e = new Emp();
//        e.setEname("LiFei");
//        empService.save(e);
    }
}
