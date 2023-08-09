package com.ordermanager.services.Item;

public enum ItemStatus {

	DISABLE("disable"),
	TEMPORARY("temporary"),
	ACTIVE("active");
	
	private String status;
	
	ItemStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	
}
