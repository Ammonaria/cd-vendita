package com.github.Ammonaria.cdvendita.model;

import javax.persistence.*;

/**
 * Created by amalia on 30/10/2014.
 */
@Entity
public class Profilo extends JsonObject {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idProfilo;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false)
    private String email;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    //definire i metodi get e set
    public Long getIdProfilo() {
        return idProfilo;
    }

    public void setIdProfilo(Long idProfilo) {
        this.idProfilo = idProfilo;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){return cognome; }

    public String getEmail(){return email; }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCognome(String cognome){
        this.cognome=cognome;
    }

    public void setEmail(String email){this.email=email;}









}
