package com.echolima.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irACastillo (View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("destino", "castillo");
        startActivity(i);
    }
    public void irAPlaya (View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("destino", "playa");
        startActivity(i);
    }
    public void irACine (View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("destino", "cine");
        startActivity(i);
    }
    public void irAMontaña (View v){
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("destino", "montaña");
        startActivity(i);
    }
}
