package com.example.correodrawer.ui.borrador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.correodrawer.R;

import app.BorradorDB;
import app.CorreoSalida;
import io.realm.Realm;

public class nuevo_correo extends Fragment {
    Realm realm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.nuevo_correo, container, false);
        realm = Realm.getDefaultInstance();

        Button enviar = root.findViewById(R.id.enviar);
        Button guardar = root.findViewById(R.id.savedetail);
        EditText Asunto = root.findViewById(R.id.aboutNew);
        EditText Para = root.findViewById(R.id.paranew);
        EditText Body = root.findViewById(R.id.bodydetailNew);
        Bundle bdl = getArguments();
        NavController navController = Navigation.findNavController( getActivity(), R.id.nav_host_fragment);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.nav_gallery);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        CorreoSalida c = new CorreoSalida();
                        c.setFrom("tu");
                        c.setAsunto(Asunto.getText().toString());
                        c.setPara(Para.getText().toString());
                        c.setMensaje(Body.getText().toString());
                        realm.copyToRealm(c);
                    }
                });

            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.nav_slideshow);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        BorradorDB c = new BorradorDB();
                        c.setAsunto(Asunto.getText().toString());
                        c.setPara(Para.getText().toString());
                        c.setMensaje(Body.getText().toString());
                        realm.copyToRealm(c);
                    }
                });
            }
        });
        return root;
    }
}
