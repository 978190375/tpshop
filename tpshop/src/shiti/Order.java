package shiti;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private int id;
	private String orderNumber; //订单号
	private User user;  //用户 多对一
	private String time;
	private Set order_goods=new HashSet(0);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set getOrder_goods() {
		return order_goods;
	}
	public void setOrder_goods(Set order_goods) {
		this.order_goods = order_goods;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
