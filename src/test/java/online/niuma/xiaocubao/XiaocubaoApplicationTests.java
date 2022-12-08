package online.niuma.xiaocubao;

import online.niuma.xiaocubao.pojo.entity.User;
import online.niuma.xiaocubao.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XiaocubaoApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        Long id = 717287426L;
        User user = userRepository.selectById(id);
        System.out.println("user = " + user);
    }

}
