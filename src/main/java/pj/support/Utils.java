package pj.support;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pj.ctrl.LoginController;

public class Utils {
	public static SqlSession getSession(){
		String resource = "mybatis-config.xml";
        InputStream is = LoginController.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        return session;
	}
}
