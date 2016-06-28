package pj.ctrl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.User;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class UserController {

	/*用户登陆验证*/
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
    
    /*用户注册*/
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
    
    /*用户修改账号密码*/
    @RequestMapping("/user/updatePassword/{user_id}/{user_password}")
    public Ret updatePassword(@PathVariable("user_id")String user_id, @PathVariable("user_password")String user_password,
    		HttpServletRequest request,HttpServletResponse response){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	
    	SqlSession session = Utils.getSession();
        
        String statement = "mapping.userMapper.updatePassword";
        int num = session.update(statement, new User(user_id, null, user_password, null));
        session.commit();
        return new Ret(num);
    }
    
    /*用户修改用户名和头像*/
    @RequestMapping("/user/updateNameAndPic/{user_id}/{user_name}/{user_pic}")
    public Ret updatePassword(@PathVariable("user_id")String user_id, @PathVariable("user_name")String user_name, @PathVariable("user_pic")String user_pic,
    		HttpServletRequest request,HttpServletResponse response){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	
    	SqlSession session = Utils.getSession();
        
        String statement = "mapping.userMapper.updateNameAndPic";
        int num = session.update(statement, new User(user_id, user_name, null, user_pic));
        session.commit();
        return new Ret(num);
    }
    
    /*根据user_id获取user_name*/
    @RequestMapping("/user/name/{user_id}")
    public String getUserName(@PathVariable("user_id")String user_id,
    		HttpServletRequest request,HttpServletResponse response){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	
    	SqlSession session = Utils.getSession();
        
        String statement = "mapping.userMapper.getUserName";
        String name = session.selectOne(statement, user_id);
        return name;
    }
    
    /*根据user_id获取user_pic*/
    @RequestMapping("/user/pic/{user_id}")
    public String getUserPic(@PathVariable("user_id")String user_id,
    		HttpServletRequest request,HttpServletResponse response){
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	
    	SqlSession session = Utils.getSession();
        
        String statement = "mapping.userMapper.getUserPic";
        String pic = session.selectOne(statement, user_id);
        return pic;
    }
}
