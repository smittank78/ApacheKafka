package api.kafka.dto;

public class Student 
{
	private String name;
	private int phone;
	private String dept;
	public String getName() {
		return name;
	}
	public int getPhone() {
		return phone;
	}
	public String getDept() {
		return dept;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", phone=" + phone + ", dept=" + dept + "]";
	}
}