import com.yinrong.exception.BookNotFoundException;
import com.yinrong.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yinrong
 * @className TestCacheService
 * @description ${description}
 * @date 2017/3/9
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by GWCheng on 2016/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-cache.xml"})
public class TestCacheService {
    @Autowired
    private CacheService cacheService;

    @Test
    public void testCacheable() throws BookNotFoundException {
        for (int i = 0; i < 10; i++) {
            cacheService.findBook("123");
        }
    }
}