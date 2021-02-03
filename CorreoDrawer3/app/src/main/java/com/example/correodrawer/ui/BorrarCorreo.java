package com.example.correodrawer.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.correodrawer.R;

import com.example.correodrawer.MainActivity;

import java.util.List;

public class BorrarCorreo extends DialogFragment {
    private List<CorreosAdapter> averiaList;
    private ListView lista;
    private int pos;
    public BorrarCorreo(int pos)
    {
        this.pos = pos;
    }
    OnBorrarCorreoListener mListener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new Dialog(getActivity());
    }
    public void onAttach(Context context) throws RuntimeException {
        super.onAttach(context);
        if (context instanceof OnBorrarCorreoListener) {
            mListener = (OnBorrarCorreoListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnControlesFragmentListener");
        }
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
                        mListener.BorrarCorreoListener(pos);
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
