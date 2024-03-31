package com.db.pojo;

public class Customer {
		
		private Integer custId;		//primary key
		private String custName;
		private String email;		//unique key
		private String permanentAddress;
		private Long contact;
		private String password;	//unique key
		
		public Customer() {
			
			super();
		}
		
		
		public Customer(Integer custId, String custName, String email,
				String permanentAddress, Long contact) {
			
			super();
			this.custId = custId;
			this.custName = custName;
			this.email = email;
			this.permanentAddress = permanentAddress;
			this.contact = contact;
		}

		
		public Customer(String custName, String email, String permanentAddress, 
				Long contact, String password) {
			
			super();
			this.custName = custName;
			this.email = email;
			this.permanentAddress = permanentAddress;
			this.contact = contact;
			this.password = password;
		}


		public Customer(Integer custId, String custName, String email, String permanentAddress, Long contact,
				String password) {
			
			super();
			this.custId = custId;
			this.custName = custName;
			this.email = email;
			this.permanentAddress = permanentAddress;
			this.contact = contact;
			this.password = password;
		}

		@Override
		public String toString() {
			return "Customer\nCustomer Id=" + custId + "\nCustomer Name=" + custName 
					+ "\nEmail=" + email + "\nPermanent Address=" + permanentAddress 
					+ "\nContact=" + contact + "\nPassword=" + password + 
					"\n___________________________________________________________________________________________________\n";
		}

		public Integer getCustId() {
			
			return custId;
		}

		public void setCustId(Integer custId) {
			
			this.custId = custId;
		}

		public String getCustName() {
			
			return custName;
		}

		public void setCustName(String custName) {
			
			this.custName = custName;
		}

		public String getEmail() {
			
			return email;
		}

		public void setEmail(String email) {
			
			this.email = email;
		}

		public String getPermanentAddress() {
			return permanentAddress;
		}

		public void setPermanentAddress(String permanentAddress) {
			
			this.permanentAddress = permanentAddress;
		}

		public Long getContact() {
			
			return contact;
		}

		public void setContact(Long contact) {
			
			this.contact = contact;
		}

		public String getPassword() {
			
			return password;
		}

		public void setPassword(String password) {
			
			this.password = password;
		}
		

}
