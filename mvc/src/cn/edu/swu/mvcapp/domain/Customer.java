package cn.edu.swu.mvcapp.domain;

public class Customer {
	private Integer Id;
	private String name;
	private String address;
	private String phone;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", address=" + address +", phone=" + phone + "]";
	}
	
}