package com.bw.entity;

/**
 * @author wangafei
 *
 * 2019年11月2日
 */
public class Goodskind {
	private Integer did;
	private String dname;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Goodskind(Integer did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}
	public Goodskind() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goodskind [did=" + did + ", dname=" + dname + "]";
	}
	
	
}
