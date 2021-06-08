package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProximasConsultasMedico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximas_consultas_medico);
        ListView listView = (ListView) findViewById(R.id.ListViewProximasConsultasM);

        String email_medico = null;
        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_medico = bundle.getString("emailMedico2");
            }
        }

        ArrayList<ConsultaMedico> list = new ArrayList<>();
        ArrayList<ConsultaPaciente> listFinal = new ArrayList<>();
        DBCadastroAgendaDAO dbCadastroAgendaDAO = new DBCadastroAgendaDAO(this);
        DBMedicoDao dbMedicoDao = new DBMedicoDao(this);
        Integer id = dbMedicoDao.SetMedico(email_medico);
        list = dbCadastroAgendaDAO.proximasConsultas(id);
        AuxAdapterProximasConsultasMed aux = new AuxAdapterProximasConsultasMed();
        listFinal = aux.trocaLista(list);

        ArrayAdapter adapter =new AdapterProximasConsultasMed(this, listFinal);
        listView.setAdapter(adapter);
    }
}