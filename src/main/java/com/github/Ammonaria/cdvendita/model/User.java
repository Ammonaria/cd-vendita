package com.github.Ammonaria.cdvendita.model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by amalia on 30/10/2014.
 */
public class User extends Model {
    private String username;
    private String pw;


    //definire i metodi get e set

    public String getUsername(){
        return username;
    }

    public String getPw(){
        return pw;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPw(String pw){
        this.pw=pw;
    }
}
