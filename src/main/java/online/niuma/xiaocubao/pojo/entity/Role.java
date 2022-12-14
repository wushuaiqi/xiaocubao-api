package online.niuma.xiaocubao.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.niuma.xiaocubao.pojo.BaseEntity;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Getter
@Setter
@ToString
@TableName("tb_role")
@ApiModel(value = "Role对象", description = "角色表")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色标识")
    private String title;


}
