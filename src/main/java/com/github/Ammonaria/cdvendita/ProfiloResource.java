package com.github.Ammonaria.cdvendita;

import com.github.Ammonaria.cdvendita.exception.FieldValidationException;
import com.github.Ammonaria.cdvendita.model.Profilo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by amalia on 04/11/2014.
 */
public class ProfiloResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Profilo theprofilo = Profilo.validate(Profilo.class, request.getParameter("idProfilo"));
            if (theprofilo == null)
                throw new FieldValidationException();


            PrintWriter writer = response.getWriter();
            writer.println(theprofilo.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            String json = this.readBody(request.getReader());
            Profilo newprofilo = Profilo.fromJson(Profilo.class, json);
            System.out.println(newprofilo.toJson());
            newprofilo.save();

            PrintWriter writer = response.getWriter();
            writer.println(newprofilo.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            String json = this.readBody(request.getReader());
            Profilo newprofilo = Profilo.fromJson(Profilo.class, json);

            newprofilo.update();

            PrintWriter writer = response.getWriter();
            writer.println(newprofilo.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        try{
            Profilo theprofilo = Profilo.validate(Profilo.class, request.getParameter("idProfilo"));
            theprofilo.delete();

        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }


}


