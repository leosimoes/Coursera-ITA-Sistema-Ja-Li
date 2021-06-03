package org.coursera.jali.controllers;

import org.coursera.jali.entities.Leitor;
import org.coursera.jali.entities.Livro;
import org.coursera.jali.services.LeitorService;
import org.coursera.jali.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/livros")
public class LivrosController {

    private LivroService livroService;

    private LeitorService leitorService;

    @Autowired
    public LivrosController(LivroService livroService, LeitorService leitorService){
        this.livroService = livroService;
        this.leitorService = leitorService;
    }

    @GetMapping
    public ModelAndView listarLivros(){
        ModelAndView modelAndView = new ModelAndView("livros2");

        List<Livro> livros = livroService.listarLivros();
        Leitor leitor = leitorService.getLeitorByLogin(leitorService.nameUserLogged());

        modelAndView.addObject("livros", livros);
        modelAndView.addObject("leitor", leitor);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getLivro(@PathVariable(value = "id") Long id){
        ModelAndView mv = new ModelAndView("livro");
        Optional<Livro> livro = livroService.getLivro(id);
        mv.addObject("livro", livro.get());
        return mv;
    }

    @PostMapping
    public String listarLivrosLidos(
            @ModelAttribute("leitor")Leitor leitor)
            {
        Leitor leitorSession = leitorService.getLeitorByLogin(leitorService.nameUserLogged());
        leitorSession.setLivrosLidosSet(leitor.getLivrosLidosSet());
        leitorService.salvarLeitor(leitorSession);
        return "redirect:leitores";
    }


}
