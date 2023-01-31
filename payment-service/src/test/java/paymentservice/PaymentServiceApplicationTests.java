package paymentservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class PaymentServiceApplicationTests {
    @Container
    static MySQLContainer<?> database = new MySQLContainer<>("mysql:8")
            .withDatabaseName("payments")
            .withPassword("payments")
            .withUsername("payments");
    @Autowired
    private MockMvc mockMvc;

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", database::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", database::getPassword);
    }

    @Test
    void shouldCreatePaymentAndReceiveStatus() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/payment")
                        .param("clientName", "Bob bob")
                        .param("price", "600.00"))
                .andExpect(status().isCreated())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertTrue(content.contains("NEW")
                || content.contains("DONE")
                || content.contains("FAILED"));
    }
}
