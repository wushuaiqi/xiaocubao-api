package online.niuma.xiaocubao.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import online.niuma.xiaocubao.pojo.BaseDto;

/**
 * {@code @date} 2022/12/9
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDto extends BaseDto {

    private String name;

    private String title;

}
