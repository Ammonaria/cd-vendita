package com.github.Ammonaria.cdvendita;

import com.github.Ammonaria.cdvendita.exception.FieldValidationException;
import com.github.Ammonaria.cdvendita.model.Cantante;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by amalia on 30/10/2014.
 */
public class CantanteResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Cantante thecantante = Cantante.validate(Cantante.class, request.getParameter("idCantante"));
            if (thecantante == null)
                throw new FieldValidationException();


            PrintWriter writer = response.getWriter();
            writer.println(thecantante.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            String json = this.readBody(request.getReader());
            Cantante newcantante = Cantante.fromJson(Cantante.class, json);
            System.out.println(newcantante.toJson());
            newcantante.save();

            PrintWriter writer = response.getWriter();
            writer.println(newcantante.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            String json = this.readBody(request.getReader());
            Cantante newcantante = Cantante.fromJson(Cantante.class, json);

            newcantante.update();

            PrintWriter writer = response.getWriter();
            writer.println(newcantante.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        try{
            Cantante thecantante = Cantante.validate(Cantante.class, request.getParameter("idCantante"));
            thecantante.delete();

        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }


}




