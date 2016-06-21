package pj.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pj.bean.MapPath;
import pj.support.Map;

@RestController
public class MapController {

	//http://localhost:8080/map/31.302398/121.510414/18
    @RequestMapping("/map/{lati}/{longi}/{zoom}")
    public MapPath map(@PathVariable("lati")String lati,
    		@PathVariable("longi")String longi,
    		@PathVariable("zoom")String zoom,
    		HttpServletRequest request,HttpServletResponse response) {
    	Map map=new Map(lati,longi,zoom);

    	response.setHeader("Access-Control-Allow-Origin", "*");
        ServletContext servletContext = request.getServletContext();
        String realPath=servletContext.getRealPath("/");
        String fileName="map_"+lati+"_"+longi+"_"+zoom+".png";
		String filePath=realPath+fileName;
		
		File imageFile = new File(filePath);
	    FileOutputStream outStream;
		try {
			outStream = new FileOutputStream(imageFile);
	        outStream.write(map.getImg());
	        outStream.flush();
	        outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return new MapPath(fileName,filePath);
    }
}
