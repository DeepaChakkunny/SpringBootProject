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
	String mockOneArrayInvalidRequest ="{\"Array1\":[1,\"fg\",3,45],\"Array2\":[7,9,0,6,8,23],\"Array3\":[90,23,1,2,3]}";

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
	@Test
	public void testMakeonearray_InvalidRequestMethod() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/makeonearray"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	@Test
	public void testReverseWords_InvalidRequestMethod() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/ReverseWords")
				.param("sentence","how are you"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}
	@Test
	public void testFibonocci_InvalidRequestMethod()throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/Fibonacci")
				.param("n","10"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}
	@Test
	public void testTriangleType_InvalidRequestMethod() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/TriangleType")
				.param("a","2")
				.param("b","3")
				.param("c","4"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	public void testFibonocci_missingRequestParam() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/Fibonacci")
				.param("p","10"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	public void testReverseWords_missingRequestParam() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/ReverseWords")
				.param("sentence1","how are you"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());


	}

	@Test
	public void testTriangleType_missingRequestParam() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/api/TriangleType"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	public void testFibonocci_invalidMediaType() throws Exception {
		Mockito.when(
				service.getFibonacciNumber(Mockito.anyString())).thenReturn("55");

		mockMvc.perform(MockMvcRequestBuilders.get("/api/Fibonacci")
				.param("n","10")
				.accept(MediaType.TEXT_HTML))
		.andExpect(MockMvcResultMatchers.status().isNotAcceptable());
	}

	@Test
	public void testReverseWords_invalidMediaType() throws Exception {
		Mockito.when(
				service.reverseWordsInSentence(Mockito.anyString())).thenReturn("\""+"woh era uoy"+"\"");

		mockMvc.perform(MockMvcRequestBuilders.get("/api/ReverseWords")
				.param("sentence","how are you")
				.accept(MediaType.TEXT_HTML))
		.andExpect(MockMvcResultMatchers.status().isNotAcceptable());
	}

	@Test
	public void testTriangleType_invalidMediaType() throws Exception {
		Mockito.when(
				service.getTriangleType(Mockito.anyString(),
						Mockito.anyString(),Mockito.anyString())).thenReturn("\""+"Scalene"+"\"");

		mockMvc.perform(MockMvcRequestBuilders.get("/api/TriangleType")
				.accept(MediaType.TEXT_HTML)
				.param("a","2")
				.param("b","3")
				.param("c","4"))
		.andExpect(MockMvcResultMatchers.status().isNotAcceptable());
	}

	@Test
	public void testMakeonearray_invalidMediaType() throws Exception {

		Mockito.when(
				service.oneArrayresponse(Mockito.any(OneArrayRequest.class)))
		.thenReturn(mockOneArrayResponse);					
		mockMvc.perform(MockMvcRequestBuilders.post("/api/makeonearray")
				.accept(MediaType.TEXT_HTML)
				.content(mockOneArrayRequest)
				.contentType(MediaType.TEXT_HTML)
				)
		.andExpect(MockMvcResultMatchers.status().isNotAcceptable());

	}
	
	@Test
	public void testMakeonearray_invalidRequestBody() throws Exception {

		Mockito.when(
				service.oneArrayresponse(Mockito.any(OneArrayRequest.class)))
		.thenReturn(mockOneArrayResponse);					
		mockMvc.perform(MockMvcRequestBuilders.post("/api/makeonearray")
				.accept(MediaType.APPLICATION_JSON)
				.content(mockOneArrayInvalidRequest)
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
		

	}




}
