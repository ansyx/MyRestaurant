package main.src.action;

import com.opensymphony.xwork2.ActionSupport;
//可以么，还行吧
public class HelloWorldAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	String msm="happyEnding";
	
	
	public String getMsm() {
		return msm;
	}


	public void setMsm(String msm) {
		this.msm = msm;
	}


	public String execute(){
		
		msm="sorrow !!!";
		
		return "success";
	}
	public String login(){
		
		msm="happyEnding !!!";
		
		return "success";
	}
	

}
