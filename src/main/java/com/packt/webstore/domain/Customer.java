package com.packt.webstore.domain;

public class Customer {

	private String customerId;
	private String name;
	private String adress;
	private Long noOfOrdersMade;
	public Customer() {
		super();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(Long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

}
