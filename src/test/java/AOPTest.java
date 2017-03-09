import com.yinrong.components.StudentsManage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yinrong
 * @className AOPTest
 * @description ${description}
 * @date 2017/3/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations={"classpath:applicationContext.xml", "classpath*:mvc-dispatcher-servlet.xml"})
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AOPTest {
    @Autowired
   private  StudentsManage studentsManage;

    @Test
    public void testUpdate() throws Exception {

   //     StudentsManage studentsManage = (StudentsManage) context.getBean("studentsManage");
        // studentMgr.saveOne("wuguowei");
        System.out.println("-----------");
        studentsManage.update("wuguowei");
    }
}
