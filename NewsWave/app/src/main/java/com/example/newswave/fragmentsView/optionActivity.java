package com.example.newswave.fragmentsView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.newswave.MainActivity;
import com.example.newswave.R;
import com.example.newswave.databinding.ActivityOptionBinding;

public class optionActivity extends AppCompatActivity {
    ActivityOptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new profileFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                Intent intent = new Intent(optionActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the back stack
                startActivity(intent);
                finish();
            } else if (item.getItemId() == R.id.profile) {
                String name = getIntent().getStringExtra("name");
                String username = getIntent().getStringExtra("username");
                String email = getIntent().getStringExtra("email");

                Bundle data = new Bundle();
                data.putString("name",name);
                data.putString("username",username);
                data.putString("email",email);

                profileFragment fragment = new profileFragment();

                fragment.setArguments(data);

                replaceFragment(fragment);
            } else if (item.getItemId() == R.id.settings) {
                replaceFragment(new settingsFragment());
            } else if (item.getItemId() == R.id.info) {
                replaceFragment(new aboutFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}