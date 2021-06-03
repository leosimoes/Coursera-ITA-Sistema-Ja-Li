package org.coursera.jali.services;

import org.coursera.jali.controllers.LivrosController;
import org.coursera.jali.dao.LeitorRepository;
import org.coursera.jali.entities.Leitor;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TestLeitorService {

    private LeitorService leitorService;

    private LeitorRepository leitorRepositoryMock;

    @Before
    public void setup() {
        leitorRepositoryMock = Mockito.mock(LeitorRepository.class);
        leitorService = new LeitorServiceImpl(leitorRepositoryMock);
    }


    @Test
    public void testLeitor() throws Exception {
        when(leitorRepositoryMock.findById(Long.valueOf(5))).thenReturn(Optional.of(new Leitor()));

        leitorService.getLeitor(5L);

        verify(leitorRepositoryMock, times(1)).findById(any(Long.class));

    }

    @Test
    public void testLeitores() throws Exception {
        when(leitorRepositoryMock.findTop10ByOrderByPontosDesc()).thenReturn(new ArrayList<>());

        leitorService.getLeitores();

        verify(leitorRepositoryMock, times(1)).findTop10ByOrderByPontosDesc();

    }

    }
