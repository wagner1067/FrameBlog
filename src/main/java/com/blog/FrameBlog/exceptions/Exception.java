package com.blog.FrameBlog.exceptions;

import java.time.Instant;

public class Exception {
	private Instant timesstamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public Exception() {
	
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public Instant getTimesstamp() {
		return timesstamp;
	}
	
	public void setTimesstamp(Instant timesstamp) {
		this.timesstamp = timesstamp;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
