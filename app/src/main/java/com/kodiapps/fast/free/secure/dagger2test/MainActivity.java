package com.kodiapps.fast.free.secure.dagger2test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    EditText inUsername, inNumber;
    Button btnSave, btnGet;
    public static MyComponent myComponent;

    @Inject
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        myComponent =  DaggerMyComponent.builder().sha_Modeule(new Sha_Modeule(this)).build();
        myComponent.inject(this);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inUsername.setText(sharedPreferences.getString("username", "default"));
                inNumber.setText(sharedPreferences.getString("number", "12345"));

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", inUsername.getText().toString().trim());
                editor.putString("number", inNumber.getText().toString().trim());
                editor.apply();
            }
        });
    }

    private void init() {
        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
    }
}