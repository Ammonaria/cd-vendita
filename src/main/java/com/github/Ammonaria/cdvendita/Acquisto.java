package com.github.Ammonaria.cdvendita;

import com.github.Ammonaria.cdvendita.exception.FieldValidationException;
import com.github.Ammonaria.cdvendita.model.CD;
import com.github.Ammonaria.cdvendita.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by amalia on 04/11/2014.
 */
public class Acquisto extends Controller {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            CD cd= CD.validate(CD.class,request.getParameter("idCd"));
            User user= User.validate(User.class,request.getParameter("idUser"));
           /* if(curator == null)
                throw new FieldValidationException();*/
            cd.getUser().add(user);
            cd.update();
            PrintWriter writer = response.getWriter();
            writer.println(cd.toJson());
            response.setStatus(HttpServletResponse.SC_OK);
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
