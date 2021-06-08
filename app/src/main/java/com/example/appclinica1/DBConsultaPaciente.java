package com.example.appclinica1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConsultaPaciente extends SQLiteOpenHelper {


    private static final String NOME_BD = "consultaPac";
    private static final int VERSAO_BD = 1;

    public DBConsultaPaciente(Context ctx) {
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table consultaPac(id_consulta integer PRIMARY KEY autoincrement, id_medico integer NOT NULL, id_paciente integer NOT NULL, id_consultaMed integer NOT NULL, horario text not null, especialidade text not null, data text not null, FOREIGN KEY (id_medico) REFERENCES medicos (id_medico),FOREIGN KEY (id_paciente) REFERENCES pacientes (id_paciente), FOREIGN KEY (id_consultaMed) REFERENCES agendasMed (id_consulta));");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table consultaPac;");
        onCreate(db);

    }


}
