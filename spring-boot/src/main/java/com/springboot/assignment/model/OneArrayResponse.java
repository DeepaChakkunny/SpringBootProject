package com.springboot.assignment.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OneArrayResponse implements Serializable {

	private static final long serialVersionUID = 10952677717573403L;
	public OneArrayResponse() {

	}
	public  OneArrayResponse(Object[]  array1) {

		this.array1=array1;

	}
	@JsonProperty("Array")
	private transient Object[] array1;

	public Object[] getArray1() {
		return array1;
	}

	public void setArray1(Object[] array1) {
		this.array1 = array1;
	}






}
