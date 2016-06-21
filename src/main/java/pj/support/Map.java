package pj.support;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Map {

	//http://api.map.baidu.com/staticimage?width=400&height=300&center=121.510414,31.302398&zoom=18
	private static final String staticMapUrl="http://api.map.baidu.com/staticimage";
	private static final String ak="7EZoSoWRPRCTaK36Q7vgSGVN506t6WM9";
	private static final String width="400";
	private static final String height="300";
	
	private String lati;
	private String longi;
	private String zoom;
	private byte[] img;
	
	public Map(){}
	public Map(String lati,String longi,String zoom){
		this.lati=lati;
		this.longi=longi;
		this.zoom=zoom;
		img=null;
		
 		try {
 			//向WebAPI发送请求
			URL url = new URL(staticMapUrl
					+"?ak="+ak
					+"&width="+width
					+"&height="+height
					+"&zoom="+zoom
					+"&center="+longi+","+lati);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5*1000);
			
			//得到WebAPI返回的图片
			InputStream inStream = conn.getInputStream();
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
			while( (len=inStream.read(buffer)) != -1 ){
			    outStream.write(buffer,0,len);
			}
	        inStream.close();
	        img=outStream.toByteArray();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getLati() {
		return lati;
	}
	public void setLati(String lati) {
		this.lati = lati;
	}
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
	public String getZoom() {
		return zoom;
	}
	public void setZoom(String zoom) {
		this.zoom = zoom;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
}
