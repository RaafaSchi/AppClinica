package com.example.appclinica1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExcluirAgendaMedico extends AppCompatActivity {

    String email_medico = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_agenda_medico);
        ListView listView = (ListView) findViewById(R.id.ListViewAgendas);

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_medico = bundle.getString("emailMedico2");
            }
        }

        ArrayList<ConsultaMedico> list = new ArrayList<>();
        DBMedicoDao dbMedicoDao = new DBMedicoDao(this);
        Integer id = dbMedicoDao.SetMedico(email_medico);
        DBCadastroAgendaDAO dbCadastroAgendaDAO = new DBCadastroAgendaDAO(this);
        list = dbCadastroAgendaDAO.agendasCadastradas(id);
        ArrayAdapter adapter =new ConsultaAdapter(this, list);
        listView.setAdapter(adapter);

        }
}