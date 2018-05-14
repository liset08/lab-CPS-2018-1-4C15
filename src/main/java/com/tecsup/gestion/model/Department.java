package com.tecsup.gestion.model;

public class Department {
	String name;
	String description;
	int departmentId;
	String city;
	
	
	public Department(String name, String description,  String city) {
		super();
		this.name = name;
		this.description = description;
		this.city = city;
	}
	
	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", description=" + description + ", departmentId=" + departmentId
				+ ", city=" + city + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
