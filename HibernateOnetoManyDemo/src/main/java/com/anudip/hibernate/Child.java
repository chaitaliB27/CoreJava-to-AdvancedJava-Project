package com.anudip.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	
	@Id
	private int cid;
	
	@Column(name="Child_Name")
	private String cName;
	
	//@Column(name="Parent_Name")
	@ManyToOne
	private Parent parent;

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Child(int cid, String cName, Parent parent) {
		super();
		this.cid = cid;
		this.cName = cName;
		this.parent = parent;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}
