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

public class AdapterNovaConsultaPaciente extends ArrayAdapter<ConsultaMedico> {

    private final Context context;
    private final ArrayList<ConsultaMedico> elementos;
    private final String email;

    public AdapterNovaConsultaPaciente(Context context, ArrayList<ConsultaMedico> elementos, String email) {
        super(context, R.layout.list_view_consulta, elementos);
        this.context = context;
        this.elementos = elementos;
        this.email = email;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_consulta, parent, false);

        TextView nomeMed = (TextView) rowView.findViewById(R.id.textViewMedicoDisponivel);
        TextView data = (TextView) rowView.findViewById(R.id.textViewDataDisponivel);

        DBMedicoDao dbMedicoDao = new DBMedicoDao(getContext());
        nomeMed.setText(dbMedicoDao.nomeMed(elementos.get(position).getId_medico()));
        data.setText(elementos.get(position).getData());

        Button btEscolha = (Button) rowView.findViewById(R.id.buttonEscolher);
        btEscolha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = elementos.get(position).getId_consulta();
                Bundle parametros = new Bundle();
                parametros.putInt("id_consulta", id);
                parametros.putString("emailPac", email);
                Intent intent = new Intent(getContext(), NovaConsultaPaciente.class);
                intent.putExtras(parametros);
                context.startActivity(intent);
            }

        });


        return rowView;

    }
}
