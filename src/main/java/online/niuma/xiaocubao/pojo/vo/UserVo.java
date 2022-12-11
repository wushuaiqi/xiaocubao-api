package online.niuma.xiaocubao.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online.niuma.xiaocubao.pojo.BaseVo;

import java.util.List;

/**
 * {@code @date} 2022/12/9
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserVo extends BaseVo {

    private String username;

    private String nickname;

    private String email;

    private String asUsername;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVo> roles;

}
