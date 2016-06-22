package pj.ctrl;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.User;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class LoginController {

    @RequestMapping("/login/{id}/{password}")
    public Ret loginConfirm(@PathVariable("id")String id,
    		@PathVariable("password")String password,
    		HttpServletRequest request,HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.userMapper.getUser";
        User user = session.selectOne(statement, id);
    	
    	if (user!=null && password.equals(user.getUser_password()))
    		return new Ret(1);
    	else
    		return new Ret(0);
    }
    
    @RequestMapping("/register/{id}/{password}")
    public Ret register(@PathVariable("id")String id, @PathVariable("password")String password,
    		HttpServletRequest request,HttpServletResponse response){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	
    	SqlSession session = Utils.getSession();
        
        String statement = "mapping.userMapper.getUser";
        User user = session.selectOne(statement, id);
        
        if(user != null){
        	return new Ret(0);
        }else {
        	statement = "mapping.userMapper.addUser";
        	session.insert(statement, new User(id, id, password, null));
        	session.commit();
        	return new Ret(1);	
        }
    }
}
