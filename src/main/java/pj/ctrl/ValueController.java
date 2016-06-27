package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Value;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class ValueController {
	
	/*获取一个景点所有value表项*/
	@RequestMapping("/value/{sight_name}")
	public List<Value> getValuesBySight(@PathVariable("sight_name")String sight_name,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.valueMapper.getValuesBySight";
        List<Value> list = session.selectList(statement, sight_name);
        return list;
	}
	
	/*增加一条value表项*/
	@RequestMapping("/value/{sight_name}/{value_lati}/{value_longi}/{value_type}/{value_description}/{value_content}")
	public Ret addValue(@PathVariable("sight_name")String sight_name,@PathVariable("value_lati")String value_lati,@PathVariable("value_longi")String value_longi,
			@PathVariable("value_type")int value_type,@PathVariable("value_description")String value_description,@PathVariable("value_content")String value_content,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.valueMapper.addValue";
        int num = session.insert(statement, new Value(-1, sight_name, value_lati, value_longi, value_type, value_description, value_content));
        session.commit();
        return new Ret(num>0?1:0, num);
	}
}
