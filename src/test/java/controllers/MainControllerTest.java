package controllers;

import Data.Repo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Тест для MainController
 */
public class MainControllerTest {

    private Repo repo = Mockito.mock(Repo.class);
    private MockMvc mockMvc;

    @Before
    public void setup() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);

        mockMvc = standaloneSetup(new MainController(repo))
                .setViewResolvers(internalResourceViewResolver)
                .build();
    }

    @Test
    public void viewTest() throws Exception {
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        mockMvc.perform(get("/showAll")).andExpect(view().name("showAll"));
        mockMvc.perform(get("/add")).andExpect(view().name("add_edit"));
        mockMvc.perform(get("/delete/2")).andExpect(view().name("redirect:/showAll"));
        mockMvc.perform(get("/edit/2")).andExpect(view().name("add_edit"));
    }

}