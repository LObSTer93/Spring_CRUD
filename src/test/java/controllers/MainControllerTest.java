package controllers;

import dao.Info;
import dao.Repo;
import Exceptions.InfoNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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

        ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver = new ExceptionHandlerExceptionResolver();
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerBeanDefinition("advice", new RootBeanDefinition(ControllerExceptionHandler.class, null, null));
        exceptionHandlerExceptionResolver.setApplicationContext(applicationContext);
        exceptionHandlerExceptionResolver.afterPropertiesSet();

        mockMvc = standaloneSetup(new MainController(repo))
                .setHandlerExceptionResolvers(exceptionHandlerExceptionResolver)
                .setViewResolvers(internalResourceViewResolver)
                .build();
    }

    @Test
    public void viewTest() throws Exception {
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        mockMvc.perform(get("/showAll")).andExpect(view().name("showAll"));
        mockMvc.perform(get("/add")).andExpect(view().name("add_edit"));
        mockMvc.perform(get("/delete/2")).andExpect(view().name("redirect:/showAll"));
    }

    @Test
    public void showAllTest() throws Exception {
        List<Info> expectedList = new ArrayList<>();
        IntStream.of(1, 5).forEach(i -> expectedList.add(new Info(1, "name"+i, "email"+i)));
        when(repo.findAll()).thenReturn(expectedList);

        mockMvc.perform(get("/showAll"))
                .andExpect(model().attributeExists("infoList"))
                .andExpect(model().attribute("infoList", hasItems(expectedList.toArray())));
    }

    @Test
    public void getAddTest() throws Exception {
        mockMvc.perform(get("/add"))
                .andExpect(model().attributeExists("isEdit"))
                .andExpect(model().attribute("isEdit", false));
    }

    @Test
    public void deleteTest() throws Exception {
        mockMvc.perform(get("/delete/1"));
        verify(repo, times(1)).delete(1L);
    }

    @Test
    public void showEditTest() throws Exception {
        long infoId = 1;
        Info expectedInfo = new Info(infoId, "name", "email");
        when(repo.getById(infoId)).thenReturn(expectedInfo);

        mockMvc.perform(get("/edit/"+infoId))
                .andExpect(view().name("add_edit"))
                .andExpect(model().attributeExists("info"))
                .andExpect(model().attribute("info", expectedInfo))
                .andExpect(model().attribute("isEdit", true));
    }

    @Test
    public void exceptionTest() throws Exception{
        long infoId = 1;
        Throwable infoNotFoundException = new InfoNotFoundException(infoId);
        when(repo.getById(infoId)).thenThrow(infoNotFoundException);

        mockMvc.perform(get("/edit/"+infoId))
                .andExpect(model().attributeExists("id"))
                .andExpect(model().attribute("id", infoId));
    }
}