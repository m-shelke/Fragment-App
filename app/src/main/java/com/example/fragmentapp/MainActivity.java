package com.example.fragmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        load_Fragment(new CFragment(),true);

        Button fragABtn = findViewById(R.id.fragABtn);
        Button fragBBtn =  findViewById(R.id.fragBBtn);
        Button fragCBtn = findViewById(R.id.fragCBtn);

        fragABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_Fragment(new AFragment(),false);
            }
        });

        fragBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_Fragment(new BFragment(),false);
            }
        });

        fragCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_Fragment(new CFragment(),false);
            }
        });
    }

    public void load_Fragment(Fragment fragment,boolean check){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (check == true){
            fragmentTransaction.add(R.id.frameLayout,fragment);
        }else {
            fragmentTransaction.replace(R.id.frameLayout,fragment);
        }
        fragmentTransaction.commit();
    }
}