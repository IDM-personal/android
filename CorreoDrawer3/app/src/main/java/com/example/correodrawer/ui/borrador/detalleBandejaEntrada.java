package com.example.correodrawer.ui.borrador;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.correodrawer.R;

public class detalleBandejaEntrada extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.recibido_detail, container, false);
        TextView sender = root.findViewById(R.id.aboutNew);
        TextView about = root.findViewById(R.id.aboutdetail);
        TextView receiver = root.findViewById(R.id.paranew);
        TextView body = root.findViewById(R.id.bodydetailNew);
        Bundle bdl = getArguments();
        NavController navController = Navigation.findNavController( getActivity(), R.id.nav_host_fragment);
        Log.i("detail", String.valueOf(bdl.getInt("id")));
        sender.setText(bdl.getString("sender"));
        about.setText(bdl.getString("about"));
        receiver.setText(bdl.getString("receiver"));
        body.setText(bdl.getString("body"));
        return root;
    }
}
