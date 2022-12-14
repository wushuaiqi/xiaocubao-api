package online.niuma.xiaocubao.service;

import online.niuma.xiaocubao.pojo.dto.RoleDto;
import online.niuma.xiaocubao.pojo.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据用户的id获取到用户的角色信息
     * @param id 用户的id
     * @return 用户的的角色信息集合
     */
    List<RoleDto> getByUserId(Long id);

}
