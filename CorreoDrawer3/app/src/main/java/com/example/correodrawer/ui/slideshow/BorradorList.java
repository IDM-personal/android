package com.example.correodrawer.ui.slideshow;

import com.example.correodrawer.ui.Correo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.BorradorDB;
import app.CorreoSalida;
import io.realm.Realm;
import io.realm.RealmResults;

public class BorradorList {
    Realm realm;

    public List<Correo> getcorreoList()
    {
        realm = Realm.getDefaultInstance();
        RealmResults<BorradorDB> miscorreossalida = realm.where(BorradorDB.class).findAll();
        Iterator<BorradorDB> it = miscorreossalida.iterator();
        List<Correo> correoList;
        correoList = new ArrayList<Correo>();
        while(it.hasNext())
        {
            correoList.add(it.next().toCorreo());
        }
        return correoList;
    }
}
