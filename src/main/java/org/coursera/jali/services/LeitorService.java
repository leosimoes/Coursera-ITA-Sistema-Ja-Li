package org.coursera.jali.services;

import org.coursera.jali.entities.Leitor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public interface LeitorService {

    Optional<Leitor> getLeitor(Long id);

    Leitor getLeitorByLogin(String login);

    List<Leitor> getLeitores();

    void salvarLeitor(Leitor leitor);

    String nameUserLogged();

}
