package pj.bean;

public class Ret {

	private int flag;
	private int num;
	
	public Ret(){}
	
	public Ret(int flag){
		this.flag=flag;
	}
	
	public Ret(int flag, int num) {
		super();
		this.flag = flag;
		this.num = num;
	}

	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
