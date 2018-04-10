package com.springboot.assignment.serviceimpl;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.springboot.assignment.model.OneArrayRequest;
import com.springboot.assignment.model.OneArrayResponse;
import com.springboot.assignment.service.AssignmentService;
@Service
public class AssignmentServiceImpl implements AssignmentService {

	public String  getFibonacciNumber(String nThNum) {

		int n;
		try {
			n=Integer.parseInt(nThNum);
		}
		catch (Exception e){

			return "Error:Invalid Argument";
		}
		BigInteger x = new BigInteger(String.valueOf(1));


		if (n==1)
			return String.valueOf(x);
		else if (n==2)
			return String.valueOf(x);
		else {
			BigInteger y = x;
			for (int i=3;i<=n; i++) {
				y=x.add(y);
				x=y.subtract(x);		
			}						
			return String.valueOf(y);

		}	
	}
	public String reverseWordsInSentence(String sentence) {

		StringTokenizer tokenizer =new StringTokenizer(sentence);
		StringBuilder senetenceReverse =new StringBuilder();

		while(tokenizer.hasMoreTokens()) {
			senetenceReverse.append(new StringBuilder(tokenizer.nextToken()).reverse());
			senetenceReverse.append(" ");

		}
		return "\""+senetenceReverse.toString().trim()+"\"";


	}
	public String getTriangleType(String s1,String s2, String s3) {
		int side1;
		int side2;
		int side3;
		try {
			side1=Integer.parseInt(s1);
			side2=Integer.parseInt(s2);
			side3=Integer.parseInt(s3);
		}
		catch (Exception e){

			return "\""+"Error:Invalid Argument"+"\"";
		}

		//A triangle is valid if sum of its two sides is greater than the third side.
		if(!(side1+side2>side3 && side1+side3>side2 && side2+side3>side1)) {
			return "\""+"Oops! Invalid triangle -These three sides cant form triangle"+"\"";
		}else if(side1==side2 && side2 ==side3) {

			return "\""+"Equilateral"+"\"";
		}
		else if(side1==side2 || side1==side3 ||side2==side3) {

			return "\""+"Isosceles"+"\"";
		}else {
			return "\""+"Scalene"+"\"";
		}


	}
	public OneArrayResponse oneArrayresponse(OneArrayRequest request) {

		SortedSet<Integer> array = new TreeSet<>();
		List<List<Integer>> list =new ArrayList<>(request.getValues().values());
		Iterator<List<Integer>> iterator =list.iterator();

		while(iterator.hasNext()) {
			array.addAll( iterator.next());
		}    
		OneArrayResponse resp = new OneArrayResponse();
		resp.setArray1(array.toArray());
		return  resp;

	}

}
