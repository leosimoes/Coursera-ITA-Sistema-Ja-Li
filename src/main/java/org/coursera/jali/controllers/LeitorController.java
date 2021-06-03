package org.coursera.jali.controllers;

import org.coursera.jali.entities.Leitor;
import org.coursera.jali.services.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/leitores")
public class LeitorController {

    private LeitorService leitorService;

    @Autowired
    public LeitorController(LeitorService leitorService){
        this.leitorService = leitorService;
    }

    @GetMapping
    public ModelAndView ranking(){
        ModelAndView mv = new ModelAndView("ranking");
        List<Leitor> leitores = leitorService.getLeitores();
        mv.addObject("leitores", leitores);
        return mv;
    }

    @GetMapping("/perfil")
    public ModelAndView leitor(){
        ModelAndView mv = new ModelAndView("leitor");
        Optional<Leitor> leitor = Optional.of(leitorService.getLeitorByLogin(leitorService.nameUserLogged()));
        mv.addObject("leitor", leitor.get());
        if(leitor.isPresent() && leitor.get().getTrofeus() != null && !leitor.get().getTrofeus().isEmpty()) {
            String trofeus = String.join(", ", leitor.get().getTrofeus());
            mv.addObject("trofeus", trofeus);
        }else{
            String trofeus = "Nenhum troféu";
            mv.addObject("trofeus", trofeus);
        }
        return mv;
    }
}
