package shiti;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cdkey {
	private int id;
	private String cdkey; //cdkey
	private int state;  //是否使用
	private Date add_time;
	private Date used_time;
	private Good good;  //商品 一对多
	private Order_good order_good;  //订单商品 多对一
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCdkey() {
		return cdkey;
	}
	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public Date getUsed_time() {
		return used_time;
	}
	public void setUsed_time(Date used_time) {
		this.used_time = used_time;
	}
	
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Order_good getOrder_good() {
		return order_good;
	}
	public void setOrder_good(Order_good order_good) {
		this.order_good = order_good;
	}
	
}
