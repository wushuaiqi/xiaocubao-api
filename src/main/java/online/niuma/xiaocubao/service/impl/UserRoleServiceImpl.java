package online.niuma.xiaocubao.service.impl;

import online.niuma.xiaocubao.pojo.entity.UserRole;
import online.niuma.xiaocubao.repository.UserRoleRepository;
import online.niuma.xiaocubao.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleRepository, UserRole> implements IUserRoleService {

    @Resource
    private UserRoleRepository repository;

    @Override
    public void create(Long id) {
        UserRole userRole = new UserRole();
        userRole.setUserId(id);
        userRole.setRoleId(1L);
        repository.insert(userRole);
    }

    @Override
    public void deleteByUserId(Long id) {
        repository.deleteByUserId(id);
    }

}
