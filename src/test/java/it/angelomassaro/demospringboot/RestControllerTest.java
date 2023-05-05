package it.angelomassaro.demospringboot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestControllerTest {

	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDue() throws Exception{		
		mvc.perform( MockMvcRequestBuilders.get("/2"))
	      .andExpect(status().isOk());
		
		//Aggiungere altri controlli
		;
	}

}
