package sunny.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sunny.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectAll();

    User selectByUserId(int id);  // one argument doesn't need @Param

    @Select("select * from user where id = #{id}")
    User selectByUserIdAnnotation(int id);

    // The placeholder should be names of class variables!!!
    List<User> selectByCondition(@Param("name") String name, @Param("newAge") int newAge);

    List<User> selectByCondition(User user);

    List<User> selectByCondition(Map<String, Object> map);

    List<User> selectByOneCondition(User user);

    void add(User user);

    int update(User user);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);
}
