package com.ssm.test.domain;

import java.util.List;

/**
 * 分页实体类
 * @author xu
 * @param pc : 当前页码
 * @param tp : 总页码
 * @param <T>
 */
public class PageBean<T> {
	/*
	 * 分页查询
	 * 		当前页码,默认页码为1
	 * 		总页码
	 * 		总记录数
	 * 		每页记录数
	 * 		当前页的记录
	 * 		请求页url
	 */
	private int pc ;		//当前页码
	//private int tp;		//总页码
	private Integer tr;			//总记录数
	private int ps;			//每页记录数
	private List<T> beanList;	//每页的内容
	private String url;		//请求页url
	public int getPc() {
		return pc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	/*
	 * 计算总页数
	 */
	public int getTp() {
		int tp = tr / ps;
		return tr % ps == 0 ? tp : tp+1;
	}
//	public void setTp(int tp) {
//		this.tp = tp;
//	}
	public Integer getTr() {
		return tr;
	}
	public void setTr(Integer tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
}
