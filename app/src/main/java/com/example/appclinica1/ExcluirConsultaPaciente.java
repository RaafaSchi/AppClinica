package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExcluirConsultaPaciente extends AppCompatActivity {

    String email_paciente = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_consulta_paciente);
        ListView listView = (ListView) findViewById(R.id.ListViewConsultas);

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_paciente = bundle.getString("emailPac");
            }
        }

        DBPacienteDao dbPacienteDao = new DBPacienteDao(this);
        Paciente pac = dbPacienteDao.setPaciente(email_paciente);
        DBConsultaPacienteDAO dbConsultaPacienteDAO = new DBConsultaPacienteDAO(this);
        ArrayList<ConsultaPaciente> list = new ArrayList<>();
        list = dbConsultaPacienteDAO.consultasAgendadas(pac.getId());
        ArrayAdapter adapter =new AdapterExcluirConsultaPaciente(this, list);
        listView.setAdapter(adapter);

    }
}