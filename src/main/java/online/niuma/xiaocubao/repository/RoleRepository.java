package online.niuma.xiaocubao.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.niuma.xiaocubao.pojo.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Mapper
public interface RoleRepository extends BaseMapper<Role> {

    /**
     * 根据用户的id查询用户的角色信息
     * @param id 用户的id
     * @return 用户的角色信息集合
     */
    @Select("select id, `name`, title, created_time, updated_time from tb_user_role ur join tb_role r on r.id = ur.role_id where user_id = #{userId}")
    List<Role> queryByUserId(@Param("userId") Long id);

}
