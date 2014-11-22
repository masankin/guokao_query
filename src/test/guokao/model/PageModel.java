package test.guokao.model;

import java.util.List;

public class PageModel {

	//jobInfo
	private List<JobInfo> listJobInfo;
	
	//count
	private int count ;
	
	//msg
	private String msg;
	
	//flag
	private boolean flag;

	public List<JobInfo> getListJobInfo() {
		return listJobInfo;
	}

	public void setListJobInfo(List<JobInfo> listJobInfo) {
		this.listJobInfo = listJobInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
	
	
}
