package de.tech26.robotfactory.robotfactory.controllertest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.tech26.robotfactory.robotfactory.RobotfactoryApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(classes = {RobotfactoryApplication.class}, webEnvironment = RANDOM_PORT)
public class OrderARobotAcceptanceTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldOrderARobot() throws Exception {
    String requestBody = "{\"components\":[\"I\",\"A\",\"D\",\"F\"]}";
    this.mockMvc
      .perform(getRequestBuilder(requestBody))
      .andExpect(status().isCreated())
      .andExpect(MockMvcResultMatchers.jsonPath("$.orderId").exists())
      .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(160.11));
  }

  @Test
  public void shouldNotAllowInvalidBody() throws Exception {
    String requestBody = "{\"components\":\"BENDER\"}";
    this.mockMvc
      .perform(getRequestBuilder(requestBody))
      .andExpect(status().isBadRequest());
  }

  @Test
  public void shouldNotAllowInvalidRobotConfiguration() throws Exception {
    String requestBody = "{\"components\":[\"A\",\"C\",\"I\",\"D\"]}";
    this.mockMvc
      .perform(getRequestBuilder(requestBody))
      .andExpect(status().isUnprocessableEntity());
  }

  private MockHttpServletRequestBuilder getRequestBuilder(String requestBody) {
    return MockMvcRequestBuilders
      .post("/orders")
      .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
      .content(requestBody);
  }

}
