package online.niuma.xiaocubao.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import online.niuma.xiaocubao.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Getter
@Setter
@TableName("tb_user_role")
@ApiModel(value = "UserRole对象", description = "用户角色表")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户给ID")
    private Long userId;

    @ApiModelProperty("角色ID")
    private Long roleId;


}
