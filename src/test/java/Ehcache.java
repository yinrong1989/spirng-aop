import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yinrong
 * @className Ehcache
 * @description ${description}
 * @date 2017/3/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-ehcache.xml"})
public class Ehcache {
    @Test
    public void testEhcache(){
        // Creating a CacheManager based on a specified configuration file.
        CacheManager manager = CacheManager.newInstance("src/main/resources/ehcache.xml");
        // obtains a Cache called sampleCache1, which has been preconfigured in the configuration file
        Cache cache = manager.getCache("sampleCache1");
        // puts an element into a cache
        Element element = new Element("key1", "哈哈");
        cache.put(element);
        //The following gets a NonSerializable value from an element with a key of key1.
        Object value = element.getObjectValue();
        System.out.println(value.toString());
        System.out.println(cache.get("key1").getObjectValue());
        manager.shutdown();
    }
}
