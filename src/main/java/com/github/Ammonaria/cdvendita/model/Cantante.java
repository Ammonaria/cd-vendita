package com.github.Ammonaria.cdvendita.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by amalia on 30/10/2014.
 */
@Entity
public class Cantante extends JsonObject {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idCantante;

    @Column(nullable=false)
    private String nome;
    @Column(nullable=false)
    private String cognome;
    @Column(nullable = false)
    private String nomearte;



    @OneToMany(mappedBy="cantante", fetch = FetchType.EAGER)

    private Set<CD> cd;
    public Set<CD> getCd() {
        return cd;
    }

    public void setCd(Set<CD> cd) {
        this.cd = cd;
    }
    public Long getId() {
        return idCantante;
    }

    public void setId(Long idCantante) {
        this.idCantante = idCantante;
    }

    //definire i metodi get e set

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome; }

    public String getNomearte(){
        return nomearte; }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public void setNomearte(String nomearte){this.nomearte=nomearte;}









}
