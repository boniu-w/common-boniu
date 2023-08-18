import io.github.boniu.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

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

        boolean b = DateUtils.isDate(dateStr);
        System.out.println("b = " + b);
    }
}
