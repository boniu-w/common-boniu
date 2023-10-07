import io.github.boniu.util.DateUtil;
import org.junit.Test;

/************************************************************************
 * author: wg
 * description: Test 
 * createTime: 10:15 2023/8/17
 * updateTime: 10:15 2023/8/17
 ************************************************************************/
// @RunWith(value = MockitoJunitRunner.class)
public class TestBoniu {

    @Test
    public void dateTest(){
        String dateStr="20230909";

        boolean b = DateUtil.isDate(dateStr);
        System.out.println("b = " + b);
    }
}
