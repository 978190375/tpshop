package shiti;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Good {
	private int id;
	private String name; //名字
	private String image_path;
	private int edition;  //版本
	private double good_price;  //商品价格
	private double price;  //现在价格
	private int count;  //剩余数量
	private int ucount;  //剩余数量
	private String discription;  //描述
	private String tips;  //类型
	private int platform;  //平台
	private int region;  //地区
	private String language;  //语言
	private Date product_time;  //上市时间
	private Date used_time; //上架时间
	private Set cdkeys=new HashSet(0); //激活码 多对一
	public Good() {
		// TODO 自动生成的构造函数存根
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*游戏名字*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	/*游戏版本
	 * 1-标准版
	 * 2-普通版
	 * 3-首发版
	 * 4-特典版
	 * 5-豪华版
	 * 6-典藏版
	 * 7-黄金版
	 * 8-季票
	 * 9-DLC 1
	 * 10-DLC 2
	 * 11-DLC 3
	 * 12-DLC 4
	 * */
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition){
		this.edition=edition;
	}
	/*游戏原价*/
	public double getGood_price() {
		return good_price;
	}
	public void setGood_price(double good_price) {
		this.good_price=good_price;
	}
	/*商品价格*/
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	/*商品数量*/
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count=count;
	}
	/*销量*/

	public int getUcount() {
		return ucount;
	}
	public void setUcount(int ucount) {
		this.ucount = ucount;
	}
	/*商品描述*/
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription=discription;
	}
	/*游戏版本
	 * 1-休闲
	 * 2-体育
	 * 3-冒险
	 * 4-动作
	 * 5-大型多人在线
	 * 6-模拟
	 * 7-独立
	 * 8-竞速
	 * 9-策略
	 * 10-角色扮演
	 * return "1,2,3,...."
	 * */
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips=tips;
	}
	/*游戏平台*/
	public int getPlatform() {
		return platform;
	}
	public void setPlatform(int platform) {
		this.platform=platform;
	}
	/*游戏适宜地区
	 * 1-全球
	 * 2-亚洲
	 * 3-亚太
	 * 4-欧洲
	 * 5-美国
	 * */
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region=region;
	}
	/*游戏语言
	 * 1-中文
	 * 2-英语
	 * 3-日语
	 * return "1,2,..."
	 * 
	 * */
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language=language;
	}
	/*游戏上市时间*/
	public Date getProduct_time() {
		return product_time;
	}
	public void setProduct_time(Date product_time) {
		this.product_time=product_time;
	}
	/*商品上架时间 可为空，有默认值*/
	public Date getUsed_time() {
		return used_time;
	}
	public void setUsed_time(Date used_time) {
		this.used_time = used_time;
	}
	public Set getCdkeys() {
		return cdkeys;
	}
	public void setCdkeys(Set cdkeys) {
		this.cdkeys = cdkeys;
	}
	
	
	
}
