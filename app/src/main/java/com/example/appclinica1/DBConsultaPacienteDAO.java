package com.example.appclinica1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBConsultaPacienteDAO {

    private SQLiteDatabase bd;
    private SQLiteDatabase bdr;

    public DBConsultaPacienteDAO(Context context) {
        DBConsultaPaciente auxBd = new DBConsultaPaciente(context);
        bd = auxBd.getWritableDatabase();
        bdr = auxBd.getReadableDatabase();
    }

    public void insert(ConsultaPaciente obj) {
        ContentValues valores = new ContentValues();
        valores.put("id_medico", obj.getId_medico());
        valores.put("id_paciente", obj.getPaciente().getId());
        valores.put("id_consultaMed", obj.getId_consultaMedico());
        valores.put("horario", obj.getHorario());
        valores.put("especialidade", obj.getEspecialidade());
        valores.put("data", obj.getData());

        bd.insert("consultaPac", null, valores);

    }

    public ArrayList<ConsultaPaciente> consultasAgendadas(Integer id) {
        ArrayList<ConsultaPaciente> list = new ArrayList<>();

        String consultas = "SELECT * FROM  consultaPac WHERE id_paciente = " + "'" + id + "'";
        Cursor cursor = bdr.rawQuery(consultas, null);
        cursor.moveToFirst();
        do {
            ConsultaPaciente cp = new ConsultaPaciente();
            cp.setId_medico(cursor.getInt(cursor.getColumnIndexOrThrow("id_medico")));
            cp.setId_consultaMedico(cursor.getInt(cursor.getColumnIndexOrThrow("id_consultaMed")));
            cp.setId_consulta(cursor.getInt(cursor.getColumnIndexOrThrow("id_consulta")));
            cp.setHorario(cursor.getString(cursor.getColumnIndexOrThrow("horario")));
            cp.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            cp.setEspecialidade(cursor.getString(cursor.getColumnIndexOrThrow("especialidade")));



            list.add(cp);

        } while (cursor.moveToNext());

        return list;
    }

    public void excluirConsulta(Integer id){
        String deletar = "DELETE FROM consultaPac WHERE id_consulta = " + "'" + id + "'";
        bd.execSQL(deletar);
    }



}
