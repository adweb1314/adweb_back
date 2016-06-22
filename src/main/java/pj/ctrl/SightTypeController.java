package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.SightType;
import pj.support.Utils;

@RestController
public class SightTypeController {
	
	@RequestMapping("/sight_type")
    public List<SightType> loginConfirm(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		SqlSession session = Utils.getSession();
		
		String statement = "mapping.sighttypeMapper.getAllSightTypes";
		List<SightType> list = session.selectList(statement);
		return list;
	}
}
