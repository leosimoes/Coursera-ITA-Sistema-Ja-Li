package org.coursera.jali.models;

import org.junit.Before;
import org.junit.Test;
import org.coursera.jali.entities.Leitor;
import org.coursera.jali.entities.Livro;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class TestTrofeuPontosObserver {

    private TrofeuObserver trofeuPontosObserver;

    private Leitor leitor;

    private Livro livro;

    private Livro livroExtra;

    @Before
    public void setup() {
        trofeuPontosObserver = new TrofeuPontosObserver();
        leitor = new Leitor();
        livro = new Livro();
        livroExtra = new Livro();
    }

    @Test
    public void testeSemLivros(){
        trofeuPontosObserver.adicionaTrofeu(leitor, new HashSet<>());
        assertEquals(leitor.getPontos(), Integer.valueOf(0));
    }

    @Test
    public void testeLivro99Paginas(){
        livro.setNumeroPaginas(99);
        trofeuPontosObserver.adicionaTrofeu(leitor, Collections.singleton(livro));
        assertEquals(leitor.getPontos(), Integer.valueOf(1));
    }

    @Test
    public void testeLivro100Paginas(){
        livro.setNumeroPaginas(100);
        trofeuPontosObserver.adicionaTrofeu(leitor, Collections.singleton(livro));
        assertEquals(leitor.getPontos(), Integer.valueOf(2));
    }

    @Test
    public void testeLivro101Paginas(){
        livro.setNumeroPaginas(101);
        trofeuPontosObserver.adicionaTrofeu(leitor, Collections.singleton(livro));
        assertEquals(leitor.getPontos(), Integer.valueOf(2));
    }

    @Test
    public void testeLivro200Paginas(){
        livro.setNumeroPaginas(200);
        trofeuPontosObserver.adicionaTrofeu(leitor, Collections.singleton(livro));
        assertEquals(leitor.getPontos(), Integer.valueOf(3));
    }

    @Test
    public void teste2Livros100Paginas(){
        livro.setNumeroPaginas(100);
        livroExtra.setNumeroPaginas(100);
        trofeuPontosObserver.adicionaTrofeu(leitor, new HashSet<>(Arrays.asList(livro, livroExtra)));
        assertEquals(leitor.getPontos(), Integer.valueOf(4));
    }

}
