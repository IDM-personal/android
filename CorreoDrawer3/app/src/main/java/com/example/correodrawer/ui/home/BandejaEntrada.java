package com.example.correodrawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.correodrawer.R;
import com.example.correodrawer.ui.Correo;
import com.example.correodrawer.ui.gallery.CorreosSalidaAdapter;
import com.example.correodrawer.ui.gallery.SalidaList;

import java.util.List;

public class BandejaEntrada extends Fragment{

    private ListView lista;
    private List<Correo> correoList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.correo_list, container, false);
        correoList = new HomeList().getcorreoList();
        lista = (ListView) root.findViewById(R.id.ListView);
        CorreosAdapter adaptadorCorreos = new CorreosAdapter(
                getContext(),
                R.layout.correo_layout,
                correoList
        );
        lista.setAdapter(adaptadorCorreos);
        return root;
    }
}