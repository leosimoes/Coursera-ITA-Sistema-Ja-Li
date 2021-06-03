package org.coursera.jali.controllers;

import org.coursera.jali.entities.Leitor;
import org.coursera.jali.entities.Livro;
import org.coursera.jali.services.LeitorService;
import org.coursera.jali.services.LivroService;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import static  org.springframework.test.web.ModelAndViewAssert.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@SpringBootTest
public class TestLivrosController{

    private LivrosController livrosController;

    private LivroService livroServiceMock;

    private LeitorService leitorServiceMock;

    private Leitor leitorMock;

    @Before
    public void setup() {
        livroServiceMock = Mockito.mock(LivroService.class);
        leitorServiceMock = Mockito.mock(LeitorService.class);
        leitorMock = Mockito.mock(Leitor.class);
        livrosController = new LivrosController(livroServiceMock, leitorServiceMock);
    }


    @Test
    public void testListarLivros() throws Exception {
        List<Livro> livrosList = new ArrayList<>();
        Leitor leitor = new Leitor();

        when(livroServiceMock.listarLivros()).thenReturn(livrosList);
        when(leitorServiceMock.nameUserLogged()).thenReturn("Nome");
        when(leitorServiceMock.getLeitorByLogin(any(String.class))).thenReturn(leitor);

        ModelAndView mv = livrosController.listarLivros();

        assertViewName(mv, "livros2");
        assertModelAttributeAvailable(mv, "livros");
        assertModelAttributeAvailable(mv, "leitor");
        assertModelAttributeValue(mv, "livros", livrosList);
        assertModelAttributeValue(mv, "leitor", leitor);

    }

    @Test
    public void testGetLivro() throws Exception {
        Livro livro = new Livro();

        when(livroServiceMock.getLivro(anyLong())).thenReturn(Optional.of(livro));

        ModelAndView mv = livrosController.getLivro(1L);

        assertViewName(mv, "livro");
        assertModelAttributeAvailable(mv, "livro");
        assertModelAttributeValue(mv, "livro", livro);

    }

    @Test
    public void testListarLivrosLidos() throws Exception {
        Set<Livro> livrosSet = new HashSet<>();

        when(leitorMock.getLivrosLidosSet()).thenReturn(livrosSet);
        when(leitorServiceMock.nameUserLogged()).thenReturn("Nome");
        when(leitorServiceMock.getLeitorByLogin(any(String.class))).thenReturn(leitorMock);
        doNothing().when(leitorServiceMock).salvarLeitor(leitorMock);

        String leitores = livrosController.listarLivrosLidos(leitorMock);
        assertEquals("redirect:leitores", leitores);

    }

}




