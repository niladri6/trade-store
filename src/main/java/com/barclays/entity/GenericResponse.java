package com.barclays.entity;

import java.util.List;

public class GenericResponse {
	private Boolean success = false;
	private List<?> data;
	private Integer totalItem = 0;

	public GenericResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericResponse(Boolean success, List<?> data, Integer totalItem) {
		super();
		this.success = success;
		this.data = data;
		this.totalItem = totalItem;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}

}
