package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Share;
import entity.UserSight;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class ShareController {
	
	/*检查某个用户是否已分享某个景点*/
	@RequestMapping("/share/{user_id}/{sight_name}")
	public Ret isShare(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.shareMapper.getShare";
        int num = session.selectOne(statement, new UserSight(user_id, sight_name));
        return new Ret(num>0?1:0);
	}
	
	/*用户分享/取消分享某个景点*/
	@RequestMapping("/share/toggle/{user_id}/{sight_name}")
	public Ret toggleShare(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.shareMapper.getShare";
        int count = session.selectOne(statement, new UserSight(user_id, sight_name));
        
        if(count > 0){
        	statement = "mapping.shareMapper.deleteShare";
        	session.delete(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(0);
        }else {
        	statement = "mapping.shareMapper.addShare";
        	session.insert(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(1);
        }
	}
	
	/*获取某个景点的被分享次数*/
	@RequestMapping("/shareNum/{sight_name}")
	public Ret getShareNumBySight(@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.shareMapper.queryShareNumBySight";
        int num = session.selectOne(statement, sight_name);
        return new Ret(num>0?1:0, num);
	}
	
	/*获取某个用户的所有分享记录*/
	@RequestMapping("share/{user_id}")
	public List<Share> getUserShares(@PathVariable("user_id")String user_id,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.shareMapper.getShareByUser";
        List<Share> list = session.selectList(statement, user_id);
        return list;
	}
}
