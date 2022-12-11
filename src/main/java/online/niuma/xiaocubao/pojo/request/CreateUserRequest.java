package online.niuma.xiaocubao.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * {@code @date} 2022/12/9
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class CreateUserRequest {

    @NotBlank
    @Size(min = 4, max = 64, message = "用户名长度在 4 - 6 个字符之间")
    private String username;

    @NotBlank
    @Size(min = 4, max = 64, message = "密码长度在 4 - 6 个字符之间")
    private String password;

//    @Email(regexp = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-z]{2,}$",
//            message = "邮箱格式不正确")
    private String email;

}
