package com.example.correodrawer.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.correodrawer.MainActivity;
import com.example.correodrawer.R;
import com.example.correodrawer.ui.Correo;
import com.example.correodrawer.ui.CorreosAdapter;
import com.example.correodrawer.ui.OnBorrarCorreoListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    private ListView lista;
    private List<Correo> correoList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.correo_list, container, false);
        correoList = new ArrayList<Correo>();
        correoList.add((new Correo(0,"Paco","Examen","Esto es el cuerpo del mensaje",false)));
        correoList.add((new Correo(1,"Zero","Examen","Esto es el cuerpo del mensaje",false)));
        correoList.add((new Correo(2,"Setas","Examen","Esto es el cuerpo del mensaje",false)));
        correoList.add((new Correo(3,"Cuarto","Examen","Esto es el cuerpo del mensaje",false)));
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