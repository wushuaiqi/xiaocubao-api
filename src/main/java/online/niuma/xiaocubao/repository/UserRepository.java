package online.niuma.xiaocubao.repository;

import online.niuma.xiaocubao.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
