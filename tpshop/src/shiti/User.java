package shiti;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private int vip;
	private Set orders=new HashSet(0);
	private Set carts=new HashSet(0);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set getOrders() {
		return orders;
	}
	public void setOrders(Set orders) {
		this.orders = orders;
	}
	public Set getCarts() {
		return carts;
	}
	public void setCarts(Set carts) {
		this.carts = carts;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	
	
}
