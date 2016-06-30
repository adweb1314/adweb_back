package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Resource;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class ResourceController {

	/*获取一个景点所有resource表项*/
	@RequestMapping("/resource/{sight_name}")
	public List<Resource> getResourceBySight(@PathVariable("sight_name")String sight_name,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.resourceMapper.getResourceBySight";
        List<Resource> list = session.selectList(statement, sight_name);
        return list;
	}
	
	/*增加一个resource表项*/
	@RequestMapping("/resource/{resource_id}/{sight_name}/{resource_type}")
	public Ret addResource(
			@PathVariable("resource_id")String resource_id,
			@PathVariable("sight_name")String sight_name,
			@PathVariable("resource_type")int resource_type,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.resourceMapper.addResource";
        int num = session.insert(statement, new Resource(resource_id, sight_name, resource_type));
        session.commit();
        return new Ret(num>0?1:0, num);
	}
}
