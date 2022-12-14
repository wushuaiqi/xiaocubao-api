package online.niuma.xiaocubao.Mapper;

import online.niuma.xiaocubao.pojo.dto.RoleDto;
import online.niuma.xiaocubao.pojo.entity.Role;
import online.niuma.xiaocubao.pojo.vo.RoleVo;
import org.mapstruct.Mapper;

/**
 * {@code @date} 2022/12/14
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    RoleVo toVo(RoleDto roleDto);

}
