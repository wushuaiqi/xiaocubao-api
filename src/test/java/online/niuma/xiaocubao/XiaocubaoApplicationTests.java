package online.niuma.xiaocubao;

import online.niuma.xiaocubao.pojo.dto.RoleDto;
import online.niuma.xiaocubao.service.IRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XiaocubaoApplicationTests {

    @Autowired
    IRoleService roleService;

    @Test
    void contextLoads() {
        Long userId = 1601119904939913218L;
        List<RoleDto> roles = roleService.getByUserId(userId);
        roles.forEach(System.out::println);
    }

}
