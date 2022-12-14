package online.niuma.xiaocubao.repository;

import online.niuma.xiaocubao.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.niuma.xiaocubao.pojo.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Mapper
public interface UserRepository extends BaseMapper<User> {

    /**
     * 根据用户名查询用户的信息
     * @param username 用户名
     * @return 所查询的用户信息
     */
    UserDetail searchByUsernameDetail(@Param("username") String username);

}
