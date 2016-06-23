package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.History;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class HistoryController {
	@RequestMapping("/history/{user_id}/{history_content}")
    public Ret addUserHistory(@PathVariable("user_id")String user_id, @PathVariable("history_content")String history_content,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		SqlSession session = Utils.getSession();
		
		String statement = "mapping.historyMapper.getHistoryCount";
		History his = session.selectOne(statement, new History(-1, user_id, history_content));
		
		if(his != null){
			statement = "mapping.historyMapper.deleteHistory";
			session.delete(statement, his.getHistory_id());
			session.commit();
		}
		
		statement = "mapping.historyMapper.addHistory";
		int add = session.insert(statement, new History(-1, user_id, history_content));
		session.commit();
		System.out.println(add);
		
		return new Ret(add);
	}
	
	@RequestMapping("/history/{user_id}")
	public List<History> getUserHistory(@PathVariable("user_id")String user_id,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		SqlSession session = Utils.getSession();
		
		String statement = "mapping.historyMapper.getUserHistory";
		List<History> list = session.selectList(statement, user_id);
		return list;
	}
	
	@RequestMapping("/history/{history_id}")
	public Ret deleteUserHistory(@PathVariable("history_id")int history_id,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		SqlSession session = Utils.getSession();
		
		String statement = "mapping.historyMapper.deleteHistory";
		int delete = session.delete(statement, history_id);
		System.out.println(delete);
		return new Ret(delete);
	}
}
