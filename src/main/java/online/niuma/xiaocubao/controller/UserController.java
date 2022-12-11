package online.niuma.xiaocubao.controller;

import online.niuma.xiaocubao.Mapper.UserMapper;
import online.niuma.xiaocubao.pojo.request.CreateUserRequest;
import online.niuma.xiaocubao.pojo.vo.UserVo;
import online.niuma.xiaocubao.service.IUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private UserMapper userMapper;

    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public UserVo create(@Validated @RequestBody CreateUserRequest createUserRequest) {
        return userMapper.toVo(userService.create(createUserRequest));
    }

}
