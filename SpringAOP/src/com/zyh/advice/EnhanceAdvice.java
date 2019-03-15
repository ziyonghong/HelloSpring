package com.zyh.advice;

public class EnhanceAdvice {
	public void preDo(){
		System.out.println("预处理，开启事务");
	}
	
	public void postDo(){
		System.out.println("后处理，提交事务");
	}

}
