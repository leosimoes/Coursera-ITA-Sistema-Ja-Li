package org.coursera.jali.controllers;

import java.util.ArrayList;
import java.util.List;
import org.coursera.jali.entities.Leitor;
import org.coursera.jali.services.LeitorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import static  org.springframework.test.web.ModelAndViewAssert.*;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
import org.springframework.web.servlet.ModelAndView;

@SpringBootTest
public class TestLeitorController{

    private LeitorController leitorController;

    private LeitorService leitorServiceMock;

    @Before
    public void setup() {
        leitorServiceMock = Mockito.mock(LeitorService.class);
        leitorController = new LeitorController(leitorServiceMock);
    }

    @Test
    public void testListarLeitores() throws Exception {
        List<Leitor> leitorList = new ArrayList<>();
        when(leitorServiceMock.getLeitores()).thenReturn(leitorList);

        ModelAndView mv = leitorController.ranking();

        assertViewName(mv, "ranking");
        assertModelAttributeAvailable(mv, "leitores");
        assertModelAttributeValue(mv, "leitores", leitorList);
    }


    @Test
    public void testLeitor() throws Exception {
        Leitor leitor = new Leitor();

        when(leitorServiceMock.nameUserLogged()).thenReturn("Nome");
        when(leitorServiceMock.getLeitorByLogin(any(String.class))).thenReturn(leitor);

        ModelAndView mv = leitorController.leitor();

        assertViewName(mv, "leitor");
        assertModelAttributeAvailable(mv, "leitor");
        assertModelAttributeValue(mv, "leitor", leitor);

        assertModelAttributeAvailable(mv, "trofeus");
        assertModelAttributeValue(mv, "trofeus", "Nenhum troféu");
    }


}




