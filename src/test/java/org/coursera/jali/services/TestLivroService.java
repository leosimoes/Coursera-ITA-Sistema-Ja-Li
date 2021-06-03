package org.coursera.jali.services;

import org.coursera.jali.dao.LivroRepository;
import org.coursera.jali.entities.Livro;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TestLivroService {

    private LivroService livroService;

    private LivroRepository livroRepositoryMock;

    @Before
    public void setup() {
        livroRepositoryMock = Mockito.mock(LivroRepository.class);
        livroService = new LivroServiceImpl(livroRepositoryMock);
    }

    @Test
    public void testLivro() throws Exception {
        when(livroRepositoryMock.findById(any(Long.class))).thenReturn(Optional.of(new Livro()));

        livroService.getLivro(5L);

        verify(livroRepositoryMock, times(1)).findById(any(Long.class));
    }

    @Test
    public void testLivros() throws Exception {
        when(livroRepositoryMock.findAll()).thenReturn(new ArrayList<>());

        livroService.listarLivros();

        verify(livroRepositoryMock, times(1)).findAll();
    }

}
