package online.niuma.xiaocubao.pojo.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * {@code @date} 2022/12/12
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class UpdateUserRequest {

    @NotBlank
    @Size(min = 4, max = 64, message = "用户名的长度在 4 - 64 个字符之间")
    private String username;

    private String nickname;

    @Email(regexp = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$",
            message = "邮箱格式不正确")
    private String email;

    private String asUsername;

}
