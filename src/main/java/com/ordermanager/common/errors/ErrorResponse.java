package com.ordermanager.common.errors;

import java.util.Date;

public class ErrorResponse {
    private int status;
    private String message;
    private Date date;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        setDate(new Date());
        
    }

	public int getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    }