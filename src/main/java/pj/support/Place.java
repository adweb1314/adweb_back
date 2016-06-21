package pj.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Place {

	//http://api.map.baidu.com/place/v2/suggestion?query=复旦大学&region=全国&output=json&ak=7EZoSoWRPRCTaK36Q7vgSGVN506t6WM9
	private static final String placeSuggestionUrl="http://api.map.baidu.com/place/v2/suggestion";
	private static final String ak="7EZoSoWRPRCTaK36Q7vgSGVN506t6WM9";
	private static final String region="全国";
	private static final String output="json";
	
	private String name;
	private String json;
	
	public Place() {};
	public Place(String name) {
		this.name=name;
		json="";
 		try {
 			//向WebAPI发送请求
			URL url = new URL(placeSuggestionUrl
					+"?ak="+ak
					+"&region="+region
					+"&output="+output
					+"&query="+name);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			
			//获取返回的json数据
			InputStream inStream = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream)); 
			String jsonReturn="",line=null;
			while ((line = reader.readLine()) != null)
                jsonReturn+=line.replace(" ","");
			json=jsonReturn;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	};
}
