package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Sight;
import pj.support.Utils;

@RestController
public class SightController {
	
	@RequestMapping("/sight")
    public List<Sight> getAllSights(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		SqlSession session = Utils.getSession();
		
		String statement = "mapping.sightMapper.getAllSights";
		List<Sight> list = session.selectList(statement);
		return list;
	}
}
