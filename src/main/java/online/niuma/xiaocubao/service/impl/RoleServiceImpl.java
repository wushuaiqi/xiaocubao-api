package online.niuma.xiaocubao.service.impl;

import online.niuma.xiaocubao.pojo.entity.Role;
import online.niuma.xiaocubao.repository.RoleRepository;
import online.niuma.xiaocubao.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleRepository, Role> implements IRoleService {

}
