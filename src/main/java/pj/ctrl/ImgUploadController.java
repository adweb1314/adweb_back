package pj.ctrl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImgUploadController {

    @RequestMapping("/userImgUpload")
    @ResponseBody
    public String userImgUpload(@RequestParam("picture")MultipartFile file,
    		HttpServletRequest request,HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	if (!file.isEmpty()){
    		try {
    			String extName = file.getOriginalFilename();
    			extName = extName.substring(extName.lastIndexOf("."));//扩展名
    			String fileName="user_"+System.currentTimeMillis();//文件名
    			String path=request.getServletContext().getRealPath("/");//路径
    			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path+fileName+extName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
    			return(fileName+extName);
    		}catch (Exception e){
    			e.printStackTrace();
    		}
    	}
		return("");
    }

    @RequestMapping("/publicUpload")
    @ResponseBody
    public String publicUpload(@RequestParam("file")MultipartFile file,
    		HttpServletRequest request,HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	if (!file.isEmpty()){
    		try {
    			String extName = file.getOriginalFilename();
    			extName = extName.substring(extName.lastIndexOf("."));//扩展名
    			String fileName="file_"+System.currentTimeMillis();//文件名
    			String path=request.getServletContext().getRealPath("/");//路径
    			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path+fileName+extName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
    			return(fileName+extName);
    		}catch (Exception e){
    			e.printStackTrace();
    		}
    	}
		return("");
    }
    
}
