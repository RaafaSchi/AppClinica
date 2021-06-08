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

public class AdapterProximasConsultasMed extends ArrayAdapter<ConsultaPaciente> {

    private final Context context;
    private final ArrayList<ConsultaPaciente> elementos;


    public AdapterProximasConsultasMed(Context context, ArrayList<ConsultaPaciente> elementos) {
        super(context, R.layout.list_view_proximas_consultas_med, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_proximas_consultas_med, parent, false);


        TextView espcialidade = (TextView) rowView.findViewById(R.id.textViewEspcialidade);
        TextView data = (TextView) rowView.findViewById(R.id.textViewData);
        TextView hora = (TextView) rowView.findViewById(R.id.textViewHora);

        espcialidade.setText(elementos.get(position).getEspecialidade());
        data.setText(elementos.get(position).getData());
        hora.setText(elementos.get(position).getHorario());


        return rowView;
    }
}
