package com.github.Ammonaria.cdvendita.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by amalia on 30/10/2014.
 */

@Entity

public class CD extends JsonObject {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idCd;
    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private String genere;
    @Column(nullable = false)
    private String ntraccia;
    @Column(nullable = false)
    private String ncopie;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Cantante cantante; public Cantante getCantante() {
        return cantante;
    }


    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> user;

    public Long getId() {
        return idCd;
    }

    public void setId(Long idCd) {
        this.idCd = idCd;
    }
    //definire i metodi get e set

    public String getTitolo(){
        return titolo;
    }

    public String getGenere(){
        return genere; }

    public String getNtraccia(){

        return ntraccia;
    }

    public String getNcopie(){
        return ncopie; }


    public void setTitolo(String titolo){

        this.titolo=titolo;
    }

    public void setGenere(String genere)
    {
        this.genere=genere;
    }

    public void setNtraccia(String ntraccia){
        this.ntraccia=ntraccia;}

    public void setNcopie(String ncopie) {
        this.ncopie = ncopie;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }


}

