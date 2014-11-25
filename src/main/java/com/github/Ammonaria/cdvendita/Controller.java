package com.github.Ammonaria.cdvendita;

import com.github.Ammonaria.cdvendita.exception.FieldValidationException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class Controller extends HttpServlet {

    protected String readBody(BufferedReader reader) throws IOException {  // Una stringa che contiene tutto il messaggio
        StringBuilder builder = new StringBuilder();
        String aux;

        while ((aux = reader.readLine()) != null)
            builder.append(aux);
        return builder.toString();
    }

    protected Object getValue(Class modelClass, String key, HttpServletRequest request) throws FieldValidationException {
        Object value;

        try {
            Field modelField = modelClass.getDeclaredField(key);
            Class fieldClass = modelField.getType();
            if (fieldClass.getName().equals("java.lang.String"))
                value = request.getParameter(key);
            else {
                Method castingMethod = fieldClass.getDeclaredMethod("valueOf", String.class);
                value = castingMethod.invoke(null, request.getParameter(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new FieldValidationException(FieldValidationException.ID_FIELD_NOT_FOUND + key, e);
        }

        return value;
    }
}