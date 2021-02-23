package com.example.correodrawer;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class mo extends DialogFragment {
    public View v;
    public mo(View v){
        this.v = v;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        NavHostFragment nv = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = nv.getNavController();
        Bundle data = new Bundle();
        data.putInt("id",v.getId());
        data.putString("receiver", (String) ((TextView)v.findViewById(R.id.Sender)).getText());
        data.putString("about", (String) ((TextView)v.findViewById(R.id.Asunto)).getText());
        data.putString("body", (String) ((TextView)v.findViewById(R.id.Cuerpo)).getText());
        data.putString("sender", "tu");
        navController.navigate(R.id.detalleBandejaEntrada, data);
        return new Dialog(getActivity());
    }
}
