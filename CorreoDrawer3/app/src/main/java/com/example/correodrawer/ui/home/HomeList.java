package com.example.correodrawer.ui.home;

import com.example.correodrawer.ui.Correo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.CorreoDB;
import io.realm.Realm;

public class HomeList {
    Realm realm;

    public List<Correo> getcorreoList()
    {
        realm = Realm.getDefaultInstance();
        List<CorreoDB> miscorreosdb = realm.where(CorreoDB.class).findAll();
        Iterator<CorreoDB> it = miscorreosdb.iterator();
        List<Correo> correoList;
        correoList = new ArrayList<Correo>();
        while(it.hasNext())
        {
            correoList.add(it.next().toCorreo());
        }
        return correoList;
    }
}
