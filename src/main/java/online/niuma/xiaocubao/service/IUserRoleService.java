package online.niuma.xiaocubao.service;

import online.niuma.xiaocubao.pojo.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
public interface IUserRoleService extends IService<UserRole> {

    /**
     * 创建用户的初始化的用户权限关联
     * @param id 用户的id
     */
    void create(Long id);
}
