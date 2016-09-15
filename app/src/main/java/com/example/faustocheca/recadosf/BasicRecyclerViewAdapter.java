package com.example.faustocheca.recadosf;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class BasicRecyclerViewAdapter extends RecyclerView.Adapter<BasicRecyclerViewAdapter.BasicViewHolder> {
    ArrayList <Recado>recados;

    public BasicRecyclerViewAdapter(ArrayList<Recado> recados) {
        this.recados = recados;
    }

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_basic,parent,false);

        return new BasicViewHolder(row);
    }

    @Override
    public void onBindViewHolder(BasicViewHolder holder, int position) {

        holder.texFechaHora.setText(String.valueOf(recados.get(position).getFecha_hora_Rec()));
        holder.texNombreCliente.setText(recados.get(position).getNombre_cliente_Rec());

    }



    @Override
    public int getItemCount() {
        return recados.size();
    }


    public class BasicViewHolder extends RecyclerView.ViewHolder{

        public TextView texFechaHora, texNombreCliente;
        public View view;


        public BasicViewHolder(final View itemView) {
            super(itemView);


            view = itemView;
            texFechaHora= (TextView) itemView.findViewById(R.id.tv_fecha_hora);
            texNombreCliente= (TextView) itemView.findViewById(R.id.tv_nombre_cliente);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    Recado recado = recados.get(position);
                    intent.putExtra("recado", recado);
                    v.getContext().startActivity(intent);


                }
            });


        }






    }





}
