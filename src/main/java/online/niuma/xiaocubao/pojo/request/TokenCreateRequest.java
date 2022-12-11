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
public class TokenCreateRequest {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 64, message = "用户名的长度在 4 - 64 个字符之间")
    private String username;

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 64, message = "密码的长度在 4 - 64 个字符之间")
    private String password;
}
