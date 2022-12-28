package org.sunny;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sunny.mapper.UserMapper;
import org.sunny.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // old methods
//            List<User> users = sqlSession.selectList("sunny.mapper.UserMapper.selectUsers");
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectAll();
            System.out.println(users);
        }

    }
}
