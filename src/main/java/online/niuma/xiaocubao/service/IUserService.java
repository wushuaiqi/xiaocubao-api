package online.niuma.xiaocubao.service;

import online.niuma.xiaocubao.pojo.dto.UserDto;
import online.niuma.xiaocubao.pojo.request.CreateUserRequest;
import online.niuma.xiaocubao.pojo.request.TokenCreateRequest;
import online.niuma.xiaocubao.pojo.request.UpdateUserRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
public interface IUserService extends UserDetailsService {
    /**
     * 根据用户名获取到登陆用户的信息
     * @param username the username identifying the user whose data is required.
     * @return 登陆用户的信息
     * @throws UsernameNotFoundException
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    /**
     * 创建 token
     * @param tokenCreateRequest 用户登陆的参数
     * @return token 值
     */
    String createToken(TokenCreateRequest tokenCreateRequest);

    /**
     * 创建用户
     * @param createUserRequest 创建用户的的参数
     * @return 创建用户后的信息
     */
    UserDto create(CreateUserRequest createUserRequest);

    /**
     * 根据用户的id删除用户的信息
     * @param id 用户id
     */
    void delete(Long id);

    /**
     * 更改用户的信息
     * @param id 用户的 id
     * @param updateUserRequest 用户的更新信息
     * @return 用户更新后的信息
     */
    UserDto update(Long id, UpdateUserRequest updateUserRequest);

    /**
     * 根据id获取用户的信息
     * @param id 用户的id
     * @return 用户的信息
     */
    UserDto get(String id);
}
