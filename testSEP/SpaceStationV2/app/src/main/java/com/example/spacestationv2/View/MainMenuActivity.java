package com.example.spacestationv2.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.spacestationv2.Autenthication.Login;
import com.example.spacestationv2.R;

public class MainMenuActivity extends AppCompatActivity {


    public static final String EXTRA_TEXT = "message";
    private Button openLivingRoom;
    private Button openToilet;
    private Button openKitchen;
    private Button openLogOut;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        Toolbar toolbar = findViewById(R.id.toolbar);
        openLivingRoom = findViewById(R.id.living_room);
        openToilet = findViewById(R.id.toilet);
        openKitchen = findViewById((R.id.kitchen));
        openLogOut = findViewById(R.id.log_out);


        openLivingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openLivingRoom();
            }
        });

        openToilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openToilet();
            }
        });

        openKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKitchen();
            }
        });

        openLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }

    private void openLivingRoom() {

        Intent intent = new Intent(this, MainActivity.class);
        String message = "Livingroom";

        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);

    }

    private void openToilet() {

        Intent intent = new Intent(this, MainActivity.class);
        String message = "Toilet";

        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);

    }
    private void openKitchen() {

        Intent intent = new Intent(this, MainActivity.class);
        String message = "Kitchen";

        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

    }
}
