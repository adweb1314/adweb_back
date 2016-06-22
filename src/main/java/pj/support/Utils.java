package pj.support;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pj.ctrl.UserController;

public class Utils {
	public static SqlSession getSession(){
		String resource = "mybatis-config.xml";
        InputStream is = UserController.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        return session;
	}
}
