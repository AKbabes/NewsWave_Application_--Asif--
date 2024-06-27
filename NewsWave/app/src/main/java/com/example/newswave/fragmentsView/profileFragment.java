package com.example.newswave.fragmentsView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.renderscript.Script;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newswave.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profileFragment extends Fragment {
    TextView nameobj,usernameobj,emailobj;
    String name,username,email;
    DatabaseReference reference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        nameobj = view.findViewById(R.id.showName);
        usernameobj = view.findViewById(R.id.showuserName);
        emailobj = view.findViewById(R.id.showEmail);

        nameobj.setText("Asif Akram");
        usernameobj.setText("asifak");
        emailobj.setText("asifaks0007@gmail.com");

        return view;
    }
}