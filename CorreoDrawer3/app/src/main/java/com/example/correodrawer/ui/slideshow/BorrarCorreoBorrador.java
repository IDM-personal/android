package com.example.correodrawer.ui.slideshow;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.correodrawer.R;

import java.util.List;

import app.BorradorDB;
import app.CorreoSalida;
import io.realm.Realm;

public class BorrarCorreoBorrador extends DialogFragment {
    private List<CorreosBorradorAdapter> averiaList;
    private ListView lista;
    private int pos;
    onborrarCorreoBorrador mlistener;

    public BorrarCorreoBorrador(int pos)
    {
        this.pos = pos;
    }
    Realm realm;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new Dialog(getActivity());
    }

    public void onAttach(Context context) throws RuntimeException {
        super.onAttach(context);
        mlistener = (onborrarCorreoBorrador) context;
        realm = Realm.getDefaultInstance();
        Log.i("Logical","HERE");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        Log.i("Logical", "work");

        AlertDialog.Builder builder = new
            AlertDialog.Builder(context).setTitle("borrar Correo?")
            .setPositiveButton("Borrar", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int
                            which) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                BorradorDB cb = realm.where(BorradorDB.class).equalTo("id", pos).findFirst();
                                if(cb != null) {
                                    Log.i("Borrando", cb.getAsunto());
                                    cb.deleteFromRealm();
                                    mlistener.borraBorrador();
                                }
                            }
                        });
                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        builder.setView(inflater.inflate(R.layout.simple_layout,null));
        builder.create().show();
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
