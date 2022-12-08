package online.niuma.xiaocubao.service.impl;

import online.niuma.xiaocubao.pojo.entity.User;
import online.niuma.xiaocubao.repository.UserRepository;
import online.niuma.xiaocubao.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements IUserService {

}
