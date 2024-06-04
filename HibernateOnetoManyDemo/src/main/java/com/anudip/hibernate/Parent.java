package com.anudip.hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {
	
	@Id
	private int pid;
	
	@Column(name="Parent_Name")
	private String pName;
	
	@Column(name="Child_Name")
	@OneToMany
	private Set<Child> child;

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parent(int pid, String pName, Set<Child> child) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.child = child;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Set<Child> getChild() {
		return child;
	}

	public void setChild(Set<Child> child) {
		this.child = child;
	}

}
