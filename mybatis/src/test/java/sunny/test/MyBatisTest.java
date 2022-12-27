package sunny.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import sunny.mapper.UserMapper;
import sunny.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream  = Resources.getResourceAsStream(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectAll();
            System.out.println(users);
        }
    }

    @Test
    public void testSelectByUserId() {
        int id = 1;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectByUserId(id);
            System.out.println(user);
        }
    }

    @Test
    public void testSelectByUserIdAnnotation() {
        int id = 1;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectByUserIdAnnotation(id);
            System.out.println(user);
        }
    }

    @Test
    public void testSelectByCondition() {
        String name = "%" + "A" + "%";  // after process
        int newAge = 1;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users;

            // discrete parameters
            users = mapper.selectByCondition(name, newAge);
            System.out.println(users);

            // using a class variable
            User user = new User();
            user.setName(name);
            user.setNewAge(newAge);
            users = mapper.selectByCondition(user);
            System.out.println(users);

            // using a map<variable name, value>
            Map<String, Object> map = new HashMap<>();
            map.put("name", name);
            // map.put("age", newAge); // NOT working because newAge is the class variables
            map.put("newAge", newAge);
            users = mapper.selectByCondition(map);
            System.out.println(users);
        }
    }


    @Test
    public void testSelectByOneCondition() {
        String name = "%" + "B" + "%";  // in fact B:2, but name is in the first if statement
        int newAge = 1;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setName(name);
            user.setNewAge(newAge);
            List<User> users = mapper.selectByOneCondition(user);
            System.out.println(users);
        }
    }

    @Test
    public void testAdd() {
        String name = "C";
        int newAge = 3;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setName(name);
            user.setNewAge(newAge);

            System.out.println(user);
            mapper.add(user);
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        String name = "C";
        int newAge = 3;
        int id = 2;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setName(name);
            // user.setNewAge(newAge);
            user.setId(id);

            System.out.println(mapper.update(user));
        }
    }

    @Test
    public void testDeleteById() {
        int id = 1;

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.deleteById(id);
        }
    }


    @Test
    public void testDeleteByIds() {
        int[] ids = {1, 2, 3};

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            mapper.deleteByIds(ids);
        }
    }
}
