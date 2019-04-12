package shiti;

import java.util.HashSet;

import java.util.Set;
public class Order_good {
	private int id;
	private Order order; //订单 多对一
	private Good good;//商品 多对一
	private Set cdkeys=new HashSet(0); 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public Set getCdkeys() {
		return cdkeys;
	}
	public void setCdkeys(Set cdkeys) {
		this.cdkeys = cdkeys;
	}
	
	
}
