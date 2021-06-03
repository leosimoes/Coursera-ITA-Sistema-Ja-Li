package org.coursera.jali.dao;

import org.coursera.jali.entities.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {

    Optional<Leitor> findById(Long id);

    List<Leitor> findTop10ByOrderByPontosDesc();

    Leitor findByLogin(String login);
}
