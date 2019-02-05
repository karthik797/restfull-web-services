package com.restfullwebservices.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="all details about the user")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Name should have 2 charectors ")
	@ApiModelProperty(notes="Name should not have atleast 2 charectors")
	private String name;
	
	@Past
	@ApiModelProperty(notes="Name should bein the past")
	private Date dateofbirth;
	
	@OneToMany(mappedBy="user")
	private List<Post> poste;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateofbirth=" + dateofbirth + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, Date dateofbirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	
}
