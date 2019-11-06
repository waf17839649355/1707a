package com.bw.entity;

/**
 * @author wangafei
 *
 * 2019年11月2日
 */
public class Goods {
	private Integer gid;
	private String gname;
	private Double price;
	private String imgurl;
	private Integer bid;
	private String jieshao;
	private Integer did;
	private Integer sum;
	
	
	private String bname;
	private String dname;
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getJieshao() {
		return jieshao;
	}
	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Goods(Integer gid, String gname, Double price, String imgurl, Integer bid, String jieshao, Integer did,
			String bname, String dname) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.price = price;
		this.imgurl = imgurl;
		this.bid = bid;
		this.jieshao = jieshao;
		this.did = did;
		this.bname = bname;
		this.dname = dname;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", price=" + price + ", imgurl=" + imgurl + ", bid=" + bid
				+ ", jieshao=" + jieshao + ", did=" + did + ", bname=" + bname + ", dname=" + dname + "]";
	}
	
	
}
