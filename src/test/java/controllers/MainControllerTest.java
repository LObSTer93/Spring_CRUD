package controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Тест для MainController
 */
public class MainControllerTest {

    @Test
    public void homeTest() throws Exception {
        MainController mainController = new MainController();
        MockMvc mockMvc = standaloneSetup(mainController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

}