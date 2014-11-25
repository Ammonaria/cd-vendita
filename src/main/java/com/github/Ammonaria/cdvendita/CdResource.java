package com.github.Ammonaria.cdvendita;

import com.github.Ammonaria.cdvendita.exception.FieldValidationException;
import com.github.Ammonaria.cdvendita.model.CD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by amalia on 30/10/2014.
 */
public class CdResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            CD theCd = CD.validate(CD.class, request.getParameter("idCd"));
            if (theCd == null)
                throw new FieldValidationException();


            PrintWriter writer = response.getWriter();
            writer.println(theCd.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        }



@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
        String json = this.readBody(request.getReader());
        CD newCd = CD.fromJson(CD.class, json);
        System.out.println(newCd.toJson());
        newCd.save();

        PrintWriter writer = response.getWriter();
        writer.println(newCd.toJson());
    } catch (FieldValidationException e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

@Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            String json = this.readBody(request.getReader());
            CD newCd = CD.fromJson(CD.class, json);

            newCd.update();

            PrintWriter writer = response.getWriter();
            writer.println(newCd.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        try{
            CD theCd = CD.validate(CD.class, request.getParameter("idCd"));
            theCd.delete();

           } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }


}
