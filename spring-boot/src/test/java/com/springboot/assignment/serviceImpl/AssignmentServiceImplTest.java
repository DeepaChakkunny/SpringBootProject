package com.springboot.assignment.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.assignment.service.AssignmentService;
import com.springboot.assignment.serviceimpl.AssignmentServiceImpl;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = AssignmentServiceImpl.class, secure = false)
public class AssignmentServiceImplTest {
	

	 @InjectMocks
	 private static AssignmentService service = new AssignmentServiceImpl();

	
	
	@Test
	public void testFibonocciImpl_firstValue() throws Exception {
		String fibNo=service.getFibonacciNumber("1");
		assertThat(fibNo).isEqualTo("1");
			
		
	}
	@Test
	public void testFibonocciImpl_bigNum() throws Exception {
		String fibNo=service.getFibonacciNumber("100");
		assertThat(fibNo).isEqualTo("354224848179261915075");
			
		
	}
	@Test
	public void testFibonocciImpl_invalidNo() throws Exception {
		String fibNo=service.getFibonacciNumber("2o");
		assertThat(fibNo).contains("Error");
		
	}
	@Test
	public void reverseWords_propersentence() throws Exception {
		String sentence=service.reverseWordsInSentence("hi how are you");
		assertThat(sentence).isEqualTo("\""+"ih woh era uoy"+"\"");
			
		
	}
	
	@Test
	public void reverseWords_singleLetterWord() throws Exception {
		String sentence=service.reverseWordsInSentence("i c  u");
		assertThat(sentence).isEqualTo("\""+"i c u"+"\"");
			
		
	}
	@Test
	public void getTriangleType_equilateral() throws Exception {
		String triType=service.getTriangleType("2","2","2");
		assertThat(triType).isEqualTo("\""+"Equilateral"+"\"");
			
		
	}
	@Test
	public void getTriangleType_scalene() throws Exception {
		String triType=service.getTriangleType("2","3","4");
		assertThat(triType).isEqualTo("\""+"Scalene"+"\"");
			
		
	}
	@Test
	public void getTriangleType_isocleles() throws Exception {
		String triType=service.getTriangleType("2","3","2");
		assertThat(triType).isEqualTo("\""+"Isosceles"+"\"");
			
		
	}
	@Test
	public void getTriangleType_invalid() throws Exception {
		String triType=service.getTriangleType("1","2","3");
		assertThat(triType).contains("Invalid");
			
		
	}
	@Test
	public void getTriangleType_invalid_side1() throws Exception {
		String triType=service.getTriangleType("io","2","3");
		assertThat(triType).contains("Error");
			
		
	}
	@Test
	public void getTriangleType_invalid_side2() throws Exception {
		String triType=service.getTriangleType("1","u8","3");
		assertThat(triType).contains("Error");
			
		
	}
	@Test
	public void getTriangleType_invalid_side3() throws Exception {
		String triType=service.getTriangleType("1","2","9i");
		assertThat(triType).contains("Error");
			
		
	}

}
