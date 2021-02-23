package com.example.correodrawer.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.correodrawer.MainActivity;
import com.example.correodrawer.R;
import com.example.correodrawer.mo;
import com.example.correodrawer.ui.Correo;

import java.util.List;

public class CorreosAdapter extends ArrayAdapter<Correo> {
    Context ctx;
    int layoutTemplate;
    List<Correo> correoList;

    public CorreosAdapter(@NonNull Context context, int resource,
                          @NonNull List<Correo> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.correoList = objects;
    }
    public View getView(final int position, @Nullable View convertView, @NonNull
            ViewGroup parent) {
        View v= LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);
        Correo elementoActual = correoList.get(position);
        Log.i("Logical",elementoActual.getSender());
    // Rescartar los elemnentos de IU del template
            TextView textViewSender=(TextView)v.findViewById(R.id.Sender);
            TextView textViewAsunto=(TextView)v.findViewById(R.id.Asunto);
            TextView textViewCuerpo=(TextView)v.findViewById(R.id.Cuerpo);
            Button borrar = (Button)v.findViewById(R.id.borrar);
            Button detailer = (Button)v.findViewById(R.id.detailcorreo);
    // Hacemos un set de la info del elemnto Actual en los elemento de IU
            textViewSender.setText(elementoActual.getSender());
            textViewAsunto.setText(elementoActual.getAsunto());
            textViewCuerpo.setText(elementoActual.getCuerpo());
            borrar.setId(position);
            borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("Logical", "work");
                    TextView text = view.findViewById(R.id.Sender);
                    Log.i("Logical", String.valueOf(view.getId()));
                    BorrarCorreoEntrada borrarCorreo = new BorrarCorreoEntrada(view.getId());
                    borrarCorreo.show(((MainActivity)ctx).getSupportFragmentManager(),"BorrarCorreo");
                    borrarCorreo.dismiss();
                }
            });
        v.setId(elementoActual.getCodigo());
        detailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewer) {
                Log.i("Logicale","mostrar");
                mo n = new mo(v);
                n.show(((MainActivity)ctx).getSupportFragmentManager(),"");
                n.dismiss();
            }
        });
        Log.i("Logical", "work");
        return v;
    }


}
