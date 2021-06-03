package org.coursera.jali.controllers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

    public class TestHomeLoginController {

        private HomeLoginController homeLoginController;

        @Before
        public void setup() {
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


    }


