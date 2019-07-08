import application.App;
import application.mappers.DeptMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @author: wuhui
 * @time: 2019/7/1 13:11
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class Test01 {

    @Autowired
    DeptMapper mapper;
    @Autowired
    DataSource dataSource;
    @Test
    public void test(){
        System.out.println(mapper.selectByPrimaryKey(1L));
        System.out.println(dataSource.toString());
    }
}
