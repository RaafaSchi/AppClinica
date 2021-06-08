package com.example.appclinica1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;

public class NovaConsultaPaciente extends AppCompatActivity {

    Spinner especialidades;
    Button btEscolheData;
    String data;
    Button btHorarios;
    String emailPaciente;
    Integer id_consulta;
    String hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_consulta_paciente);
        especialidades = (Spinner) findViewById(R.id.spinnerPaciente);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.especialidadesLayout, android.R.layout.simple_spinner_dropdown_item);
        especialidades.setAdapter(adapter);

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                emailPaciente = bundle.getString("emailPac");
            }
        }


        btEscolheData = findViewById(R.id.buttonEscolheDataP);
        btEscolheData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String esp = especialidades.getSelectedItem().toString();
                Bundle parametros = new Bundle();
                parametros.putString("emailPac", emailPaciente);
                parametros.putString("especialidade", esp);
                Intent intent = new Intent(NovaConsultaPaciente.this, listViewDatasDisponiveis.class);
                intent.putExtras(parametros);
                startActivity(intent);

            }
        });

        Intent recebedoraId = getIntent();
        if (recebedoraId != null) {
            Bundle bundle = recebedoraId.getExtras();
            if (bundle != null) {
                id_consulta = bundle.getInt("id_consulta");
            }
        }

        Intent recebedora2 = getIntent();
        if (recebedora2 != null) {
            Bundle bundle = recebedora2.getExtras();
            if (bundle != null) {
                emailPaciente = bundle.getString("emailPac");
            }
        }


        btHorarios = findViewById(R.id.buttonHorariosP);
        btHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle parametros = new Bundle();
                parametros.putString("emailPac", emailPaciente);
                parametros.putInt("id", id_consulta);
                Intent intent = new Intent(NovaConsultaPaciente.this, listViewHorariosDisponiveis.class);
                intent.putExtras(parametros);
                startActivity(intent);

            }
        });

        Intent recebedorahora = getIntent();
        if (recebedorahora != null) {
            Bundle bundle = recebedorahora.getExtras();
            if (bundle != null) {
                hora = bundle.getString("hora");
            }
        }


    }

    public void btAgendarConsultaOnClick(View view) {

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                emailPaciente = bundle.getString("emailPac");
            }
        }

        Intent recebedora2 = getIntent();
        if (recebedora2 != null) {
            Bundle bundle = recebedora2.getExtras();
            if (bundle != null) {
                id_consulta = bundle.getInt("id");
            }
        }

        DBCadastroAgendaDAO dbCadastroAgendaDAO = new DBCadastroAgendaDAO(this);
        Integer h = null;
        if (hora.equals("08:00")) {
            h = 8;
        }
        if (hora.equals("09:00")) {
            h = 9;
        }
        if (hora.equals("10:00")) {
            h = 10;
        }
        if (hora.equals("11:00")) {
            h = 11;
        }
        if (hora.equals("13:00")) {
            h = 13;
        }
        if (hora.equals("14:00")) {
            h = 14;
        }
        if (hora.equals("15:00")) {
            h = 15;
        }
        if (hora.equals("16:00")) {
            h = 16;
        }
        if (hora.equals("17:00")) {
            h = 17;
        }
        if (hora.equals("18:00")) {
            h = 18;
        }
        dbCadastroAgendaDAO.marcarConsulta(id_consulta, h);
        DBConsultaPacienteDAO dbConsultaPacienteDAO = new DBConsultaPacienteDAO(this);
        DBPacienteDao dbPacienteDao = new DBPacienteDao(this);
        Paciente p = new Paciente();
        ConsultaMedico cm = new ConsultaMedico();
        cm = dbCadastroAgendaDAO.horariosDisponiveis(id_consulta);
        p = dbPacienteDao.setPaciente(emailPaciente);
        ConsultaPaciente cp = new ConsultaPaciente();
        cp.setPaciente(p);
        cp.setData(cm.getData());
        cp.setEndereco(cm.getEndereco());
        cp.setEspecialidade(cm.getEspecialidade());
        cp.setHorario(String.valueOf(h) + ":00");
        cp.setId_consultaMedico(id_consulta);
        cp.setId_medico(cm.getId_medico());
        dbConsultaPacienteDAO.insert(cp);

        Bundle parametros = new Bundle();
        parametros.putString("emailPaciente", emailPaciente);
        Intent intent = new Intent(this, TelaPagamento.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }
}