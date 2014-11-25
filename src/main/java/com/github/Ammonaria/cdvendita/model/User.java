package com.github.Ammonaria.cdvendita.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by amalia on 30/10/2014.
 */
@Entity
public class User extends JsonObject {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false)
    private Long idUser;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;


    @OneToOne(fetch = FetchType.EAGER)
        private Profilo profilo;
    public Profilo getProfilo() {
        return profilo;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

    @ManyToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<CD> cd;
    public Set<CD> getCd() {
        return cd;
    }

    public void setCd(Set<CD> cd) {
        this.cd = cd;
    }
    public Long getId() {
        return idUser;
    }

    public void setId(Long id) {
        this.idUser = idUser;
    }

    //definire i metodi get e set

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }
}
