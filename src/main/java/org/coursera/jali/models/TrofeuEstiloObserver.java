package org.coursera.jali.models;

import org.coursera.jali.entities.Leitor;
import org.coursera.jali.entities.Livro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrofeuEstiloObserver implements TrofeuObserver{

    public void adicionaTrofeu(Leitor leitor, Set<Livro> livrosLidosSet){
        if(livrosLidosSet == null || livrosLidosSet.isEmpty()){
            leitor.setTrofeus(new HashSet<>());
        }else if(!livrosLidosSet.isEmpty()) {
            Map<String, Integer> estilosPaginasMap = getEstilosPaginas(livrosLidosSet);
            Set<String> trofeusEstilos = getTrofeusEstilo(estilosPaginasMap);
            leitor.setTrofeus(trofeusEstilos);
        }
    }

    private Map<String, Integer> getEstilosPaginas(Set<Livro> livrosLidosSet){
        Map<String, Integer> estilosPaginasMap = new HashMap<>();
        for (Livro livro : livrosLidosSet) {
            String estilo = livro.getEstilo();
            if(estilosPaginasMap.containsKey(estilo)){
                Integer livrosEstilo = estilosPaginasMap.get(estilo);
                estilosPaginasMap.put(estilo, livrosEstilo + 1);
            }else{
                estilosPaginasMap.put(estilo, 1);
            }
        }
        return estilosPaginasMap;
    }

    private Set<String> getTrofeusEstilo(Map<String, Integer> estilosPaginasMap){
        Set<String> trofeus = new HashSet<>();
        for (Map.Entry<String, Integer> entry : estilosPaginasMap.entrySet()) {
            if(entry.getValue() >= 5){
                trofeus.add("Leitor de " + entry.getKey());
            }
        }
        return trofeus;
    }
}
