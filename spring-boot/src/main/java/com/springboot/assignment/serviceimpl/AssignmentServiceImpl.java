package com.springboot.assignment.serviceimpl;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import com.springboot.assignment.model.OneArrayRequest;
import com.springboot.assignment.model.OneArrayResponse;
import com.springboot.assignment.service.AssignmentService;
@Service
public class AssignmentServiceImpl implements AssignmentService {

	public String  getFibonacciNumber(String nThNum) {

		int n=Integer.parseInt(nThNum);
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
		return formatString(senetenceReverse.toString().trim());


	}
	public String getTriangleType(String s1,String s2, String s3) {

		int side1=Integer.parseInt(s1);
		int side2=Integer.parseInt(s2);
		int side3=Integer.parseInt(s3);

		//A triangle is valid if sum of its two sides is greater than the third side.
		if(!(side1+side2>side3 && side1+side3>side2 && side2+side3>side1)) {
			return formatString("Oops! Invalid triangle -These three sides cant form triangle");
		}else if(side1==side2 && side2 ==side3) {

			return formatString("Equilateral");
		}
		else if(side1==side2 || side1==side3 ||side2==side3) {

			return formatString("Isosceles");
		}else {
			return formatString("Scalene");
		}


	}
	public OneArrayResponse oneArrayresponse(OneArrayRequest request) {

		SortedSet<Integer> array = new TreeSet<>();
		List<List<Integer>> list =new ArrayList<>(request.getValues().values());
		if(list.isEmpty()) {
			throw new HttpMessageNotReadableException("Empty Body");
		}
		Iterator<List<Integer>> iterator =list.iterator();

		while(iterator.hasNext()) {
			array.addAll( iterator.next());
		}    
		OneArrayResponse resp = new OneArrayResponse();
		resp.setArray1(array.toArray());
		return  resp;

	}
	public String formatString(String str) {

		StringBuilder formattedStr =new StringBuilder();
		formattedStr.append("\"");
		formattedStr.append(str).append("\"");
		return formattedStr.toString();

	}

}
