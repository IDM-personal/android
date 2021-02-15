package com.example.correodrawer.ui.borrador;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.correodrawer.R;
import com.example.correodrawer.ui.slideshow.SlideshowViewModel;
import com.google.android.material.navigation.NavigationView;

public class detalleborradorFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.correo_detail, container, false);
        Button b = root.findViewById(R.id.close);
        Bundle bdl = getArguments();
        Log.i("Logical",bdl.toString());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavHostFragment nv = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                NavController navController = nv.getNavController();
                String b = bdl.getString("Caller");
                Log.i("Logical", b);
                navController.navigate(Integer.parseInt(bdl.getString("Last id")));
            }
        });
        return root;
    }
}
