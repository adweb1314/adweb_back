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
public class CollectionController {
	
	/*检查某个用户是否收藏该景点*/
	@RequestMapping("/collection/{user_id}/{sight_name}")
	public Ret isCokkectioned(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.collectionMapper.getCollection";
        int num = session.selectOne(statement, new UserSight(user_id, sight_name));
        return new Ret(num>0?1:0);
	}
	
	/*用户收藏/取消收藏*/
	@RequestMapping("/collection/toggle/{user_id}/{sight_name}")
	public Ret toggleCollection(@PathVariable("user_id")String user_id,
    		@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.collectionMapper.getCollection";
        int count = session.selectOne(statement, new UserSight(user_id, sight_name));
        
        if(count > 0){
        	statement = "mapping.collectionMapper.deleteCollection";
        	session.delete(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(0);
        }else {
        	statement = "mapping.collectionMapper.addCollection";
        	session.insert(statement, new UserSight(user_id, sight_name));
        	session.commit();
        	return new Ret(1);
        }
	}
	
	/*获取某个景点被收藏的次数*/
	@RequestMapping("/collectionNum/{sight_name}")
	public Ret getCollectionNumBySight(@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.collectionMapper.queryCollectionNum";
        int num = session.selectOne(statement, sight_name);
        return new Ret(num>0?1:0, num);
	}
	
	/*获取某个用户的所有收藏*/
	@RequestMapping("/collection/{user_id}")
	public List<String> getUserCollections(@PathVariable("user_id")String user_id,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.collectionMapper.getCollectionByUser";
        List<String> list = session.selectList(statement, user_id);
        return list;
	}
}
