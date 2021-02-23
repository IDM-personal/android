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

import com.example.correodrawer.R;

public class monew extends DialogFragment {
    public View v;
    public monew(View v){
        this.v = v;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        NavHostFragment nv = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = nv.getNavController();
        navController.navigate(R.id.nuevo_correo);
        return new Dialog(getActivity());
    }
}
