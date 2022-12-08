package online.niuma.xiaocubao.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import online.niuma.xiaocubao.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Getter
@Setter
@TableName("tb_user")
@ApiModel(value = "User对象", description = "用户表")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("加密后的密码")
    private String password;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("关联的账号")
    private String asUsername;

    @ApiModelProperty("是否锁定，1-是，0-否")
    private Boolean locked;

    @ApiModelProperty("是否可用，1-是，0否")
    private Boolean enabled;

    @ApiModelProperty("乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer deleted;


}
