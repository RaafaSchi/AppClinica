package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listViewDatasDisponiveis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_datas_disponiveis);
        ListView listView = (ListView) findViewById(R.id.ListViewDatasDisponiveis);

        String especialidade = null;
        String email = null;


        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                especialidade = bundle.getString("especialidade");
                email = bundle.getString("emailPac");
            }
        }

        ArrayList<ConsultaMedico> list = new ArrayList<>();
        DBCadastroAgendaDAO dbCadastroAgendaDAO = new DBCadastroAgendaDAO(this);
        list = dbCadastroAgendaDAO.datasDisponiveis(especialidade);
        ArrayAdapter adapter =new AdapterNovaConsultaPaciente(this, list, email);
        listView.setAdapter(adapter);





    }
}