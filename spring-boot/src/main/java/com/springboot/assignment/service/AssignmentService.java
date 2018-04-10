package com.springboot.assignment.service;


import com.springboot.assignment.model.OneArrayRequest;
import com.springboot.assignment.model.OneArrayResponse;

public interface AssignmentService {
	
	String  getFibonacciNumber(String n);
	String reverseWordsInSentence(String sentence);
	String getTriangleType(String side1,String side2, String side3);
	OneArrayResponse oneArrayresponse(OneArrayRequest request);

}
