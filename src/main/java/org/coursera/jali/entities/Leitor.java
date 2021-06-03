package org.coursera.jali.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.coursera.jali.models.TrofeuEstiloObserver;
import org.coursera.jali.models.TrofeuObserver;
import org.coursera.jali.models.TrofeuPontosObserver;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "LEITOR")
public class Leitor implements UserDetails {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LEITOR_ID")
    @Id
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "NOME")
    private String nome;

    @Transient
    private List<TrofeuObserver> trofeuObservers = List.of(new TrofeuPontosObserver(), new TrofeuEstiloObserver());

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="LEITOR_LIVROS",
            joinColumns=@JoinColumn(name="LEITOR_ID"),
            inverseJoinColumns=@JoinColumn(name="LIVRO_ID"))
    private Set<Livro> livrosLidosSet = new HashSet<>();

    @Column(name = "PONTOS")
    private Integer pontos;

    @Column(name="TROFEUS")
    @ElementCollection(targetClass=String.class)
    private Set<String> trofeus;

    @Column(name = "ROLE")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Livro> getLivrosLidosSet() {
        return livrosLidosSet;
    }

    public void setLivrosLidosSet(Set<Livro> livrosLidosSet) {
        this.livrosLidosSet = livrosLidosSet;
        trofeuObservers.forEach(observer -> observer.adicionaTrofeu(this, livrosLidosSet));
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Set<String> getTrofeus() {
        return trofeus;
    }

    public void setTrofeus(Set<String> trofeus) {
        this.trofeus = trofeus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //Métodos de UserDetails
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return this.senha;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return this.login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    //Ajustar o valor da Role para exibir na view
    public String perfilRole() {
        return this.role.replaceFirst("ROLE_", "").replaceFirst("_", " ");
    }

}
