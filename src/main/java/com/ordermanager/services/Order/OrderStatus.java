package com.ordermanager.services.Order;

public enum OrderStatus {

		REALIZED("realized"),
		DELIVERED("delivered"),
		IN_PROGRESS("in_progress"),
		CANCELED("canceled");
	
	
		private String status;
		
		
		private OrderStatus(String status) {
			this.setStatus(status);
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}
		
	
}
