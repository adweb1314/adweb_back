package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.UserSight;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class WishController {

	/*检查某个用户是否已经将某个景点标记为心愿*/
	@RequestMapping("/wish/{user_id}/{sight_name}")
	public Ret isWish(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.wishMapper.getWish";
        int num = session.selectOne(statement, new UserSight(user_id, sight_name));
        return new Ret(num>0?1:0);
	}
	
	/*用户标记/取消标记某个景点为心愿*/
	@RequestMapping("/wish/toggle/{user_id}/{sight_name}")
	public Ret toggleWish(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.wishMapper.getWish";
        int count = session.selectOne(statement, new UserSight(user_id, sight_name));
        
        if(count > 0){
        	statement = "mapping.wishMapper.deleteWish";
        	session.delete(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(0);
        }else {
        	statement = "mapping.wishMapper.addWish";
        	session.insert(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(1);
        }
	}
	
	/*获取一个景点被标记为心愿的次数*/
	@RequestMapping("/wishNum/{sight_name}")
	public Ret getWishNumBySight(@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.wishMapper.queryWishNumBySight";
        int num = session.selectOne(statement, sight_name);
        return new Ret(num>0?1:0, num);
	}
	
	/*获取某个用户的所有心愿记录*/
	@RequestMapping("/wish/{user_id}")
	public List<String> getWishByUser(@PathVariable("user_id")String user_id,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.wishMapper.getWishByUser";
        List<String> list = session.selectList(statement, user_id);
        return list;
	}
}
