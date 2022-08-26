package it.angelomassaro.demospringboot;

import org.junit.Before;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoSpringBootApplicationTests {

	private MockMvc mvc;
	
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testHello() throws Exception{
		mvc.perform( MockMvcRequestBuilders.get("/demo/menu").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		//Aggiungere altri controlli
		;
	}
	
}
