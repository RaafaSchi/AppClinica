package com.example.appclinica1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;

public class CadastrarAgenda extends AppCompatActivity {

    Spinner especialidades;
    Button btEscolheData;
    String data;
    Button btHorarios;
    String[] listHorarios;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    int hora8 = 0, hora9 = 0, hora10 = 0, hora11 = 0, hora13 = 0, hora14 = 0, hora15 = 0, hora16 = 0, hora17 = 0, hora18 = 0;
    String email_medico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_agenda);
        especialidades = (Spinner) findViewById(R.id.spinnerAgenda);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.especialidadesLayout, android.R.layout.simple_spinner_dropdown_item);
        especialidades.setAdapter(adapter);

        Intent recebedora = getIntent();
        if (recebedora != null) {
            Bundle bundle = recebedora.getExtras();
            if (bundle != null) {
                email_medico = bundle.getString("emailMedico2");
            }
        }

        btHorarios = (Button) findViewById(R.id.buttonHorarios);
        listHorarios = getResources().getStringArray(R.array.horasDisponiveis);
        checkedItems = new boolean[listHorarios.length];
        btHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CadastrarAgenda.this);
                mBuilder.setTitle("Escolha os horários para atendimento:");
                mBuilder.setMultiChoiceItems(listHorarios, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if (isChecked) {
                            if (!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            } else {
                                mUserItems.remove(position);
                            }
                        }
                    }
                });


                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < mUserItems.size(); i++) {
                            int aux = mUserItems.get(i);
                            switch (aux) {
                                case 0:
                                    hora8 = 1;
                                    break;
                                case 1:
                                    hora9 = 1;
                                    break;
                                case 2:
                                    hora10 = 1;
                                    break;
                                case 3:
                                    hora11 = 1;
                                    break;
                                case 4:
                                    hora13 = 1;
                                    break;
                                case 5:
                                    hora14 = 1;
                                    break;
                                case 6:
                                    hora15 = 1;
                                    break;
                                case 7:
                                    hora16 = 1;
                                    break;
                                case 8:
                                    hora17 = 1;
                                    break;
                                case 9:
                                    hora18 = 1;
                                    break;
                            }
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });


        btEscolheData = findViewById(R.id.buttonEscolheData);
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("SELECIONE UMA DATA");
        MaterialDatePicker materialDatePicker = builder.build();
        btEscolheData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                data = materialDatePicker.getHeaderText();
            }
        });
    }

    public void btCadastrarAgendaOnClick(View view) {


        DBMedicoDao medicoDao = new DBMedicoDao(this);
        int id_medico = medicoDao.SetMedico(email_medico);
        DBCadastroAgendaDAO dbCadastro = new DBCadastroAgendaDAO(this);
        ConsultaMedico cm = new ConsultaMedico();
        cm.setId_medico(id_medico);
        cm.setEspecialidade(especialidades.getSelectedItem().toString());
        EditText end = (EditText) findViewById(R.id.editTextEnderecoConsulta);
        cm.setEndereco(end.getText().toString());
        cm.setData(data);
        cm.setHora8(hora8);
        cm.setHora9(hora9);
        cm.setHora10(hora10);
        cm.setHora11(hora11);
        cm.setHora13(hora13);
        cm.setHora14(hora14);
        cm.setHora15(hora15);
        cm.setHora16(hora16);
        cm.setHora17(hora17);
        cm.setHora18(hora18);
        dbCadastro.insert(cm);

        Toast.makeText(this, "Agenda Cadastrada!", Toast.LENGTH_SHORT).show();
        Bundle parametros = new Bundle();
        parametros.putString("emailMedico", email_medico);
        Intent intent = new Intent(this, InicialMedicos.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }
}