package org.coursera.jali.services;

import org.coursera.jali.entities.Livro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface LivroService {

    Optional<Livro> getLivro(Long id);

    List<Livro> listarLivros();

}
