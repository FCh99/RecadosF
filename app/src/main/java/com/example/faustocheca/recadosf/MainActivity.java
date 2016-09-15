package com.example.faustocheca.recadosf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.faustocheca.recadosf.getservice.MyIntentService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void inicio (View view) {
        //lanzar servicice onClick
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);





    }
}
