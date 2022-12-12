package online.niuma.xiaocubao.Mapper;

import online.niuma.xiaocubao.pojo.dto.UserDto;
import online.niuma.xiaocubao.pojo.entity.User;
import online.niuma.xiaocubao.pojo.entity.UserDetail;
import online.niuma.xiaocubao.pojo.request.CreateUserRequest;
import online.niuma.xiaocubao.pojo.request.UpdateUserRequest;
import online.niuma.xiaocubao.pojo.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * {@code @date} 2022/12/9
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(CreateUserRequest createUserRequest);

    UserDto detailToDto(UserDetail userDetail);

    User updateEntity(@MappingTarget User user, UpdateUserRequest updateUserRequest);

}
