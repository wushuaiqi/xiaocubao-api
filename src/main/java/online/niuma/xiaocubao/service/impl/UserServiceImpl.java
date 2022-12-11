package online.niuma.xiaocubao.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import online.niuma.xiaocubao.Mapper.UserMapper;
import online.niuma.xiaocubao.cofig.SecurityConfig;
import online.niuma.xiaocubao.exception.BizException;
import online.niuma.xiaocubao.exception.ExceptionType;
import online.niuma.xiaocubao.pojo.dto.UserDto;
import online.niuma.xiaocubao.pojo.entity.User;
import online.niuma.xiaocubao.pojo.entity.UserDetail;
import online.niuma.xiaocubao.pojo.request.CreateUserRequest;
import online.niuma.xiaocubao.pojo.request.TokenCreateRequest;
import online.niuma.xiaocubao.repository.UserRepository;
import online.niuma.xiaocubao.service.IUserRoleService;
import online.niuma.xiaocubao.service.IUserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserMapper userMapper;
    @Resource
    private IUserRoleService userRoleService;

    @Override
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetail = userRepository.searchByUsernameDetail(username);
        if (userDetail == null) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return userDetail;
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        UserDetail userDetail = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), userDetail.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!userDetail.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }
        if (!userDetail.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }
        return JWT.create()
                .withSubject(userDetail.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public UserDto create(CreateUserRequest createUserRequest) {
        checkUsername(createUserRequest.getUsername());
        User user = userMapper.createEntity(createUserRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.insert(user);
        userRoleService.create(user.getId());
        UserDetail userDetail = userRepository.searchByUsernameDetail(user.getUsername());
        return userMapper.detailToDto(userDetail);
    }

    /**
     * 验证用户是否存在
     * @param username 用户名
     */
    private void checkUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = userRepository.selectOne(queryWrapper);
        if (user != null) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }
}
