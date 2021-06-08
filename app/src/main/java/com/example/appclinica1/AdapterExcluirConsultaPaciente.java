package com.example.appclinica1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterExcluirConsultaPaciente extends ArrayAdapter<ConsultaPaciente> {

    private final Context context;
    private final ArrayList<ConsultaPaciente> elementos;

    public AdapterExcluirConsultaPaciente(Context context, ArrayList<ConsultaPaciente> elementos) {
        super(context, R.layout.list_view_agendas, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DBConsultaPacienteDAO dbConsultaPacienteDAO = new DBConsultaPacienteDAO(getContext());
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_agendas, parent, false);

        TextView especialidade = (TextView) rowView.findViewById(R.id.textViewEspecialidadeView);
        TextView data = (TextView) rowView.findViewById(R.id.textViewDataView);

        especialidade.setText(elementos.get(position).getEspecialidade());
        data.setText(elementos.get(position).getData());

        Button btExcluir = (Button) rowView.findViewById(R.id.buttonExcluirView);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbConsultaPacienteDAO.excluirConsulta(elementos.get(position).getId_consulta());
                Toast.makeText(getContext(), "Consulta Desmarcada!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), InicialPaciente.class);
                context.startActivity(intent);
            }

        });


        return rowView;

    }


}
