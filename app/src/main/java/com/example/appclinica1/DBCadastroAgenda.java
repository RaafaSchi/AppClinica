package com.example.appclinica1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCadastroAgenda extends SQLiteOpenHelper {

    private static final String NOME_BD = "agendasMed";
    private static final int VERSAO_BD = 3;

    public DBCadastroAgenda(Context ctx) {
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table agendasMed(id_consulta integer PRIMARY KEY autoincrement, id_medico integer NOT NULL, especialidade text not null, endereco text not null, data text not null, hora8 integer not null, hora9 integer not null, hora10 integer not null, hora11 integer not null,hora13 integer not null, hora14 integer not null, hora15 integer not null, hora16 integer not null, hora17 integer not null, hora18 integer not null, FOREIGN KEY (id_medico) REFERENCES medicos (id_medico));");
        db.execSQL("create table consultaPac(id_consulta integer PRIMARY KEY autoincrement, id_medico integer NOT NULL, id_paciente integer NOT NULL, id_consultaMed integer NOT NULL, horario text not null, FOREIGN KEY (id_medico) REFERENCES medicos (id_medico),FOREIGN KEY (id_paciente) REFERENCES pacientes (id_paciente), FOREIGN KEY (id_consultaMed) REFERENCES agendasMed (id_consulta));");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table agendasMed;");
        db.execSQL("drop table consultaPac;");
        onCreate(db);

    }

}
