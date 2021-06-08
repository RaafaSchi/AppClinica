package com.example.appclinica1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterHorariosDisponiveis  extends ArrayAdapter<Horarios> {

    private final Context context;
    private final ArrayList<Horarios> elementos;

    public AdapterHorariosDisponiveis(Context context, ArrayList<Horarios> elementos) {
        super(context, R.layout.list_view_horarios, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_horarios, parent, false);

        TextView horario = (TextView) rowView.findViewById(R.id.textViewHorarioDisponivel);

        horario.setText(elementos.get(position).getHorario());


        Button btEscolha = (Button) rowView.findViewById(R.id.buttonEscolher2);
        btEscolha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String hora = elementos.get(position).getHorario();
                Bundle parametros = new Bundle();
                parametros.putString("emailPac", elementos.get(position).getEmail_paciente());
                parametros.putString("hora", hora);
                parametros.putInt("id", elementos.get(position).getId_consulta());
                Intent intent = new Intent(getContext(), NovaConsultaPaciente.class);
                intent.putExtras(parametros);
                context.startActivity(intent);
            }

        });


        return rowView;

    }
}
