package com.example.faustocheca.recadosf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);



        // Recibir el Intent del Adapter con getExtras objeto "recado"

        Intent intent = getIntent();
        Recado recado = intent.getParcelableExtra("recado");




        // Configurar los TextViews del Layout con un título y varios campos
        TextView fechaRec = (TextView) findViewById(R.id.tv_fecha_horaB);
        TextView nombreCliente = (TextView) findViewById(R.id.tv_nombre_clienteB);
        TextView telefono = (TextView) findViewById(R.id.tv_telefonoB);
        TextView direccionRecogida = (TextView) findViewById(R.id.tv_direcc_recogidaB);
        TextView direccionEntrega = (TextView) findViewById(R.id.tv_direcc_entregaB);
        TextView descripcion = (TextView) findViewById(R.id.tv_descripcionB);
        TextView fechaHoraMaxima = (TextView) findViewById(R.id.tv_fecha_hora_maximaB);





        // setText para imprimir el detalle del recado

        fechaRec.setText(recado.getFecha_hora_Rec());
        nombreCliente.setText(recado.getNombre_cliente_Rec());
        telefono.setText(recado.getTelefono_Rec());
        direccionRecogida.setText(recado.getDireccion_recogida_Rec());
        direccionEntrega.setText(recado.getDireccion_entrega_Rec());
        descripcion.setText(recado.getDescripcion_Rec());
        fechaHoraMaxima.setText(recado.getFecha_hora_max_Rec());


    }
}
