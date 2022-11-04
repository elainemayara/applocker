package com.example.myapplication;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_main);

         Button btnEntrar = (Button) findViewById(R.id.btn_Entrar);
         btnEntrar.setOnClickListener(view -> {
              Intent intent = new Intent (MainActivity.this, FormularioFuncionarios.class);
              startActivity(intent);
       });




}
        }
