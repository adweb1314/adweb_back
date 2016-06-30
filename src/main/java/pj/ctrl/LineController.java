package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Line;
import pj.support.Utils;

@RestController
public class LineController {
	
	/*获取某个景点的所有line表项*/
	@RequestMapping("/line/{sight_name}")
	public List<Line> getLinesBySight(@PathVariable("sight_name")String sight_name,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.lineMapper.getLinesBySight";
        List<Line> list = session.selectList(statement, sight_name);
        return list;
	}
}
