package online.niuma.xiaocubao.controller;

import online.niuma.xiaocubao.pojo.request.TokenCreateRequest;
import online.niuma.xiaocubao.service.IUserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * {@code @date} 2022/12/9
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Resource
    private IUserService userService;

    @PostMapping
    public String create(@Validated @RequestBody TokenCreateRequest tokenCreateRequest) {
        return userService.createToken(tokenCreateRequest);
    }
}
