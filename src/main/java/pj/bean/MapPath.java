package pj.bean;

public class MapPath {
	
	private String fileName;
	private String filePath;

	public MapPath(){}
	public MapPath(String fileName,String filePath){
		this.fileName=fileName;
		this.filePath=filePath;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
