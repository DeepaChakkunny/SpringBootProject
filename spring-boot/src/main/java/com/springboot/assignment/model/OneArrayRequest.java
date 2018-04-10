package com.springboot.assignment.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class OneArrayRequest  implements Serializable{
	
	private static final long serialVersionUID = 397426151501817589L;
	
	private Map<String, List<Integer>> values =new HashMap<>();
	
	@JsonAnyGetter
	public Map<String,List<Integer>> getValues() {
		return values;
	}
	@JsonAnySetter
	public void setValues(String name,List<Integer> value ) {
		this.values.put(name, value);
	}

	

}
