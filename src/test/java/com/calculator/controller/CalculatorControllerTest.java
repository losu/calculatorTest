package com.calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import com.calculator.model.Result;
import com.calculator.service.CalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

	private static final String BASE_URL= "http://localhost:8080";
	private static final String ADD_URL = BASE_URL + "/add";
	private static final String DIVIDE_URL = BASE_URL + "/divide";
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private CalculatorService calculatorService;

	@Test
	public void divideEndpoint_shouldReturnHttpStatusBadRequest() throws Exception {
		mockMvc.perform(get("/divide")).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void divideEndpoint_shouldReturnHttpStatusIsOk() throws Exception {
		mockMvc.perform(get("/divide?val1=4&val2=5")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void divideEndpoint_shouldReturnResult() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(DIVIDE_URL)
		        .queryParam("val1", 10)
		        .queryParam("val2", 2);

		HttpEntity<Result> response = restTemplate.exchange(
		        builder.build().encode().toUri(), 
		        HttpMethod.GET, 
		        null, 
		        Result.class);
		
		assertThat(response).isNotNull();
		assertThat(response.getBody().getResult()).isEqualTo(5.0);
	}
	
	@Test
	public void addEndpoint_shouldReturnHttpStatusBadRequesst() throws Exception {
		mockMvc.perform(post("/add")).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void addEndpoint_shouldReturnHttpStatusIsOk() throws Exception {
		mockMvc.perform(post("/add?val1=4&val2=5")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void addEndpoint_shouldReturnResult() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ADD_URL)
		        .queryParam("val1", 10)
		        .queryParam("val2", 2);

		HttpEntity<Result> response = restTemplate.exchange(
		        builder.build().encode().toUri(), 
		        HttpMethod.POST, 
		        null, 
		        Result.class);
		
		assertThat(response).isNotNull();
		assertThat(response.getBody().getResult()).isEqualTo(12.0);
	}
}
