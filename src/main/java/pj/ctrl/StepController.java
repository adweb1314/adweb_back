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
public class StepController {

	/*检查某个用户是否将某景点标记为足迹*/
	@RequestMapping("/step/{user_id}/{sight_name}")
	public Ret isStep(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.stepMapper.getStep";
        int num = session.selectOne(statement, new UserSight(user_id, sight_name));
        return new Ret(num>0?1:0);
	}
	
	/*用户标记/取消标记某个景点为足迹*/
	@RequestMapping("/step/toggle/{user_id}/{sight_name}")
	public Ret toggleStep(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.stepMapper.getStep";
        int count = session.selectOne(statement, new UserSight(user_id, sight_name));
        
        if(count > 0){
        	statement = "mapping.stepMapper.deleteStep";
        	session.delete(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(0);
        }else {
        	statement = "mapping.stepMapper.addStep";
        	session.insert(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(1);
        }
	}
	
	/*获取某个景点被标记为足迹的次数*/
	@RequestMapping("/stepNum/{sight_name}")
	public Ret getStepNumBySight(@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.stepMapper.queryStepNumBySight";
        int num = session.selectOne(statement, sight_name);
        return new Ret(num>0?1:0, num);
	}
	
	/*获取某个用户的所有的足迹记录*/
	@RequestMapping("/step/{user_id}")
	public List<String> getUserShares(@PathVariable("user_id")String user_id,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.stepMapper.getStepByUser";
        List<String> list = session.selectList(statement, user_id);
        return list;
	}
}
