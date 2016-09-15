package com.example.faustocheca.recadosf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Recado> recados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Receive Intent in ArrayList
        Intent intent = getIntent();
        recados = new ArrayList<>();
        recados = intent.getParcelableArrayListExtra("array");
        Log.i(">>intent_Main2",String.valueOf(recados));




        //Load RecyclerView

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BasicRecyclerViewAdapter adapter = new BasicRecyclerViewAdapter(recados);
        recyclerView.setAdapter(adapter);


    }
    public void ordenar (View view) {}
}
