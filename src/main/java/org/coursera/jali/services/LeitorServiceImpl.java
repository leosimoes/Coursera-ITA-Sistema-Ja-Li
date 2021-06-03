package org.coursera.jali.services;

import org.coursera.jali.dao.LeitorRepository;
import org.coursera.jali.entities.Leitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeitorServiceImpl implements LeitorService{

    private LeitorRepository leitorRepository;

    @Autowired
    public LeitorServiceImpl(LeitorRepository leitorRepository){
        this.leitorRepository = leitorRepository;
    }

    @Override
    public Optional<Leitor> getLeitor(Long id){
        return leitorRepository.findById(id);
    }

    @Override
    public List<Leitor> getLeitores() {
        return leitorRepository.findTop10ByOrderByPontosDesc();
    }

    @Override
    public void salvarLeitor(Leitor leitor){
        leitorRepository.save(leitor);
    }

    @Override
    public String nameUserLogged(){
        String username = "None";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    @Override
    public Leitor getLeitorByLogin(String login){
        return leitorRepository.findByLogin(login);
    }

}
