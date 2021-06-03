package org.coursera.jali.models;

import org.coursera.jali.entities.Leitor;
import org.coursera.jali.entities.Livro;

import java.util.Set;

public interface TrofeuObserver {

    void adicionaTrofeu(Leitor leitor, Set<Livro> livrosLidosSet);

}
