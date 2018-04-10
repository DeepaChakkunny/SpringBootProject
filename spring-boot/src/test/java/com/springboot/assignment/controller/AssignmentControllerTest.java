package com.springboot.assignment.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.springboot.assignment.model.OneArrayRequest;
import com.springboot.assignment.model.OneArrayResponse;
import com.springboot.assignment.service.AssignmentService;



@RunWith(SpringRunner.class)
@WebMvcTest(value = AssignmentController.class, secure = false)
public class AssignmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

		
	@MockBean	
	private AssignmentService service;
	
	OneArrayResponse mockOneArrayResponse = new OneArrayResponse(new Object[]{0,1,2,3,6,7,8,9,23,45,90});
	String mockOneArrayRequest ="{\"Array1\":[1,2,3,45],\"Array2\":[7,9,0,6,8,23],\"Array3\":[90,23,1,2,3]}";
	
	@Test
	public void testFibonocci() throws Exception {
		Mockito.when(
				service.getFibonacciNumber(Mockito.anyString())).thenReturn("55");
					
		mockMvc.perform(MockMvcRequestBuilders.get("/api/Fibonacci")
				.param("n","10"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("55"));
	}
	
	@Test
	public void testReverseWords() throws Exception {
		Mockito.when(
				service.reverseWordsInSentence(Mockito.anyString())).thenReturn("\""+"woh era uoy"+"\"");
					
		mockMvc.perform(MockMvcRequestBuilders.get("/api/ReverseWords")
				.param("sentence","how are you"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("\""+"woh era uoy"+"\""));
	}
	
	@Test
	public void testTriangleType() throws Exception {
		Mockito.when(
				service.getTriangleType(Mockito.anyString(),
						Mockito.anyString(),Mockito.anyString())).thenReturn("\""+"Scalene"+"\"");
					
		mockMvc.perform(MockMvcRequestBuilders.get("/api/TriangleType")
				.param("a","2")
				.param("b","3")
				.param("c","4"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("\""+"Scalene"+"\""));
	}
	
	@Test
	public void testMakeonearray() throws Exception {
				
		Mockito.when(
				service.oneArrayresponse(Mockito.any(OneArrayRequest.class)))
				.thenReturn(mockOneArrayResponse);					
		mockMvc.perform(MockMvcRequestBuilders.post("/api/makeonearray")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockOneArrayRequest)
				.contentType(MediaType.APPLICATION_JSON)
					)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content()
		.string("{\"Array\":[0,1,2,3,6,7,8,9,23,45,90]}"));
		
	}
	
	
	
}
