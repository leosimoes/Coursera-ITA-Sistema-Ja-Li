package org.coursera.jali.controllers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

    public class TestHomeLoginController {

        private MockMvc mockMvc;
        private HomeLoginController homeLoginController;

        @Before
        public void setup() {
            //this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeLoginController()).build();
            this.homeLoginController = new HomeLoginController();
        }

        @Test
        public void testHomePage(){
            String page = homeLoginController.home();
            assertEquals("index", page);
        }

        @Test
        public void testLoginPage(){
            String page = homeLoginController.login();
            assertEquals("login", page);
        }

        @Test
        public void testLogoutPage(){
            String page = homeLoginController.logout();
            assertEquals("redirect:home", page);
        }

        @Test
        public void testAcessoNegadoPage(){
            String page = homeLoginController.acessoNegado();
            assertEquals("acessoNegado", page);
        }


/*
        @Test
        public void testHomePage2() throws Exception {
            this.mockMvc.perform(get("/home"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("index"))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        }
*/
        /*
        @Test
        public void testMessagePage() throws Exception {
            this.mockMvc.perform(get("/message")).andExpect(status().isOk())
                    .andExpect(content().string("Hello there!"));
        }*/
    }


