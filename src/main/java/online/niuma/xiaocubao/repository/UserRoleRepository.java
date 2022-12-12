package online.niuma.xiaocubao.repository;

import online.niuma.xiaocubao.pojo.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author 一颗蛋50斤
 * @since 2022-12-08
 */
@Mapper
public interface UserRoleRepository extends BaseMapper<UserRole> {

    /**
     * 以用户的id为条件删除记录
     * @param id 用户id
     */
    @Delete("delete from tb_user_role where user_id = #{id};")
    void deleteByUserId(@Param("id") Long id);

}
