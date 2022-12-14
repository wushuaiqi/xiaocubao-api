package online.niuma.xiaocubao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.niuma.xiaocubao.Mapper.RoleMapper;
import online.niuma.xiaocubao.pojo.dto.RoleDto;
import online.niuma.xiaocubao.pojo.entity.Role;
import online.niuma.xiaocubao.repository.RoleRepository;
import online.niuma.xiaocubao.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private RoleRepository repository;
    @Resource
    private RoleMapper mapper;

    @Override
    public List<RoleDto> getByUserId(Long id) {
        return repository.queryByUserId(id)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
