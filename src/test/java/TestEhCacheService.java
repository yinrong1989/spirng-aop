import com.yinrong.exception.BookNotFoundException;
import com.yinrong.model.Book;
import com.yinrong.service.CacheService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yinrong
 * @className TestEhCache
 * @description ${description}
 * @date 2017/3/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-ehcache.xml"})
public class TestEhCacheService {
    @Before
    public void init(){
        cacheService.loadBooks();
    }
    @Autowired
    private CacheService cacheService;
    @Test
    public void testCacheable() throws BookNotFoundException {

        Book book = null;
        for (int i = 0; i < 10; i++) {
            book = cacheService.findBook("123");
        }

        cacheService.findBook("456");
        cacheService.findBook("456");
        cacheService.findBook("456");
    }
}
