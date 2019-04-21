package cn.edu.swu.mvcapp.domain;

public class CriteriaCustomer {
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
		if(name != null) {
			return "%"+name+"%";
		}else {
			return "%%";
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		if(address != null) {
			return "%"+address+"%";
		}else {
			return "%%";
		}
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		if(phone != null) {
			return "%"+phone+"%";
		}else {
			return "%%";
		}
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}

}
