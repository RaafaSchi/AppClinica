package com.example.appclinica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listViewHorariosDisponiveis extends AppCompatActivity {

    Integer id;
    String emailPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_horarios_disponiveis);
        ListView listView = (ListView) findViewById(R.id.ListViewHorariosDisponiveis);

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                id = bundle.getInt("id");
            }
        }

        Intent recebedora2 = getIntent();
        if (recebedora2 != null) {
            Bundle bundle = recebedora2.getExtras();
            if (bundle != null) {
                emailPaciente = bundle.getString("emailPac");
            }
        }

        ArrayList<Horarios> list = new ArrayList<>();
        DBCadastroAgendaDAO dbCadastroAgendaDAO = new DBCadastroAgendaDAO(this);
        ConsultaMedico consultaMedico = dbCadastroAgendaDAO.horariosDisponiveis(id);
        if (consultaMedico.getHora8() == 1){
            Horarios h = new Horarios(emailPaciente, id,"08:00");
            list.add(h);
        } if (consultaMedico.getHora9() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"09:00");
            list.add(h);
        } if (consultaMedico.getHora10() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"10:00");
            list.add(h);
        } if (consultaMedico.getHora11() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"11:00");
            list.add(h);
        } if (consultaMedico.getHora13() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"13:00");
            list.add(h);
        } if (consultaMedico.getHora14() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"14:00");
            list.add(h);
        } if (consultaMedico.getHora15() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"15:00");
            list.add(h);
        } if (consultaMedico.getHora16() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"16:00");
            list.add(h);
        } if (consultaMedico.getHora17() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"17:00");
            list.add(h);
        } if (consultaMedico.getHora18() == 1) {
            Horarios h = new Horarios(emailPaciente, id,"18:00");
            list.add(h);
        }

        ArrayAdapter adapter = new AdapterHorariosDisponiveis(this, list);
        listView.setAdapter(adapter);

    }
}