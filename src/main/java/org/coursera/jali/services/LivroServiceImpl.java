package org.coursera.jali.services;

import org.coursera.jali.dao.LivroRepository;
import org.coursera.jali.entities.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    private LivroRepository livroRepository;

    @Autowired
    public LivroServiceImpl(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @Override
    public Optional<Livro> getLivro(Long id){
        return livroRepository.findById(id);
    }

    @Override
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

}
