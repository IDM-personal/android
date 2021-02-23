package com.example.correodrawer.ui.gallery;

import com.example.correodrawer.ui.Correo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.CorreoDB;
import app.CorreoSalida;
import io.realm.Realm;

public class SalidaList {
    Realm realm;

    public List<Correo> getcorreoList()
    {
        realm = Realm.getDefaultInstance();
        List<CorreoSalida> miscorreossalida = realm.where(CorreoSalida.class).findAll();
        Iterator<CorreoSalida> it = miscorreossalida.iterator();
        List<Correo> correoList;
        correoList = new ArrayList<Correo>();
        while(it.hasNext())
        {
            correoList.add(it.next().toCorreo());
        }
        return correoList;
    }
}
