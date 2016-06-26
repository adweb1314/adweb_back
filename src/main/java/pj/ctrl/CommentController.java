package pj.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Comment;
import pj.bean.Ret;
import pj.support.Utils;

@RestController
public class CommentController {
	
	/*增加某个用户对某景点的一条评论*/
	@RequestMapping("/comment/{user_id}/{sight_name}/{grade}/{comment}")
	public Ret addComment(@PathVariable("user_id")String user_id, @PathVariable("sight_name")String sight_name,
			@PathVariable("grade")int grade, @PathVariable("comment")String comment,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.commentMapper.addComment";
        int num = session.insert(statement, new Comment(-1, user_id, sight_name, grade, comment));
        session.commit();
        return new Ret(num);
	}
	
	/*获取某个景点的所有评论*/
	@RequestMapping("/comment/{sight_name}")
	public List<Comment> getCommentBySight(@PathVariable("sight_name")String sight_name,
    		HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.commentMapper.getCommentBySight";
        List<Comment> list = session.selectList(statement, sight_name);
        return list;
	}
	
	/*根据id删除某条评论*/
	@RequestMapping("/comment/delete/{comment_id}")
	public Ret deleteByCommentID(@PathVariable("comment_id")int comment_id,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
        SqlSession session = Utils.getSession();
        
        String statement = "mapping.commentMapper.deleteByCommentId";
        int num = session.delete(statement, comment_id);
        session.commit();
        return new Ret(num);
	}
}
