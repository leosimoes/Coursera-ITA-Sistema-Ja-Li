package org.coursera.jali.models;

import org.junit.Before;
import org.junit.Test;
import org.coursera.jali.entities.Leitor;
import org.coursera.jali.entities.Livro;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestTrofeuEstiloObserver {

    private TrofeuObserver trofeuPontosObserver;

    private Leitor leitor;

    private Livro livro;

    private Livro livroExtra;

    @Before
    public void setup() {
        trofeuPontosObserver = new TrofeuEstiloObserver();
        leitor = new Leitor();
        livro = new Livro();
        livroExtra = new Livro();
    }

    @Test
    public void testeSemLivros(){
        trofeuPontosObserver.adicionaTrofeu(leitor, new HashSet<>());

        assertTrue(leitor.getTrofeus().isEmpty());
    }

    @Test
    public void teste4Livros1Estilo(){
        Set<Livro> livros = auxGeraLivrosEstilo(4, "A");

        trofeuPontosObserver.adicionaTrofeu(leitor, livros);

        assertTrue(leitor.getTrofeus().isEmpty());
    }

    @Test
    public void teste5Livros1Estilo(){
        Set<Livro> livros = auxGeraLivrosEstilo(5, "A");

        trofeuPontosObserver.adicionaTrofeu(leitor, livros);

        assertTrue(!leitor.getTrofeus().isEmpty());
        assertEquals(leitor.getTrofeus().size(),1);
        assertTrue(leitor.getTrofeus().contains("Leitor de A"));
    }

    private Set<Livro> auxGeraLivrosEstilo(int quantidade, String estilo){
        Set<Livro> livroSet = new HashSet<>();
        for(int i=0; i<quantidade; ++i){
            Livro livro = new Livro();
            livro.setEstilo(estilo);
            livroSet.add(livro);
        }
        return livroSet;
    }

}
