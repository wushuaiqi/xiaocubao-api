package online.niuma.xiaocubao;

import online.niuma.xiaocubao.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XiaocubaoApplicationTests {

    @Autowired
    IUserService userService;

    @Test
    void contextLoads() {
    }

}
