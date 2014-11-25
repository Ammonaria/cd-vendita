package com.github.Ammonaria.cdvendita;

import com.github.Ammonaria.cdvendita.exception.FieldValidationException;
import com.github.Ammonaria.cdvendita.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by amalia on 31/10/2014.
 */
public class UserResource extends Controller{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            User theuser = User.validate(User.class, request.getParameter("idUser"));
            if (theuser == null)
                throw new FieldValidationException();


            PrintWriter writer = response.getWriter();
            writer.println(theuser.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            String json = this.readBody(request.getReader());
            User newuser = User.fromJson(User.class, json);
            System.out.println(newuser.toJson());
            newuser.save();

            PrintWriter writer = response.getWriter();
            writer.println(newuser.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            String json = this.readBody(request.getReader());
            User newuser = User.fromJson(User.class, json);

            newuser.update();

            PrintWriter writer = response.getWriter();
            writer.println(newuser.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        try{
            User theuser = User.validate(User.class, request.getParameter("idUser"));
            theuser.delete();

        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }


}

