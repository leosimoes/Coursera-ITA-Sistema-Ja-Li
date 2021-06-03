package org.coursera.jali.models;

import org.coursera.jali.entities.Leitor;
import org.coursera.jali.entities.Livro;

import java.util.Set;

public class TrofeuPontosObserver implements TrofeuObserver{

    public void adicionaTrofeu(Leitor leitor, Set<Livro> livrosLidosSet){
        if(!livrosLidosSet.isEmpty()) {
            Integer pontos = livrosLidosSet.size();
            for (Livro livro : livrosLidosSet){
                pontos += livro.getNumeroPaginas() / 100;
            }
            leitor.setPontos(pontos);
        }else{
            leitor.setPontos(Integer.valueOf(0));
        }

    }
}
