package com.example.correodrawer.ui.borrador;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.correodrawer.R;
import com.example.correodrawer.ui.slideshow.onborrarCorreoBorrador;

import org.w3c.dom.Text;

import app.BorradorDB;
import app.CorreoSalida;
import io.realm.Realm;

public class detalleborradorFragment extends Fragment {

    Realm realm;
    onborrarCorreoBorrador mlistener;
    onremoveBorrador rmlistener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.correo_detail, container, false);

        realm = Realm.getDefaultInstance();
        Button b = root.findViewById(R.id.enviar);
        Button save = root.findViewById(R.id.savedetail);
        TextView about = root.findViewById(R.id.aboutNew);
        TextView Para = root.findViewById(R.id.paranew);
        TextView Cuerpo = root.findViewById(R.id.bodydetailNew);
        Bundle bdl = getArguments();
        about.setText(bdl.getString("about"));
        Para.setText(bdl.getString("sender"));
        Cuerpo.setText(bdl.getString("body"));
        int id = bdl.getInt("id");
        NavController navController = Navigation.findNavController( getActivity(), R.id.nav_host_fragment);
        Log.i("detail", String.valueOf(bdl.getInt("id")));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        rmlistener = (onremoveBorrador) getContext();
                        BorradorDB borradorborrar = realm.where(BorradorDB.class).equalTo("id", id).findFirst();
                        borradorborrar.deleteFromRealm();
                        CorreoSalida nc = new CorreoSalida();
                        nc.setPara(Para.getText().toString());
                        nc.setAsunto(about.getText().toString());
                        nc.setMensaje(Cuerpo.getText().toString());
                        realm.copyToRealm(nc);
                        rmlistener.actionPerformed();
                    }
                });
            }
        });
        save.setId(bdl.getInt("id"));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        mlistener = (onborrarCorreoBorrador) getContext();
                        BorradorDB correoBorrador=new BorradorDB();
                        correoBorrador.setId(v.getId());
                        correoBorrador.setPara(Para.getText().toString());
                        correoBorrador.setAsunto(about.getText().toString());
                        correoBorrador.setMensaje(Cuerpo.getText().toString());
                        realm.copyToRealmOrUpdate(correoBorrador);
                        mlistener.borraBorrador();
                    }
                });
            }
        });
        return root;
    }
}
