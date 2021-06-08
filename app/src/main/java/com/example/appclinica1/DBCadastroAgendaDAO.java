package com.example.appclinica1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class DBCadastroAgendaDAO {

    private SQLiteDatabase bd;
    private SQLiteDatabase bdr;

    public DBCadastroAgendaDAO(Context context) {
        DBCadastroAgenda auxBd = new DBCadastroAgenda(context);
        bd = auxBd.getWritableDatabase();
        bdr = auxBd.getReadableDatabase();

    }


    public void insert(ConsultaMedico obj) {
        ContentValues valores = new ContentValues();
        valores.put("id_medico", obj.getId_medico());
        valores.put("especialidade", obj.getEspecialidade());
        valores.put("endereco", obj.getEndereco());
        valores.put("data", obj.getData());
        valores.put("hora8", obj.getHora8());
        valores.put("hora9", obj.getHora9());
        valores.put("hora10", obj.getHora10());
        valores.put("hora11", obj.getHora11());
        valores.put("hora13", obj.getHora13());
        valores.put("hora14", obj.getHora14());
        valores.put("hora15", obj.getHora15());
        valores.put("hora16", obj.getHora16());
        valores.put("hora17", obj.getHora17());
        valores.put("hora18", obj.getHora18());

        bd.insert("agendasMed", null, valores);

    }


    public List<ConsultaMedico> findAll() {
        List<ConsultaMedico> list = new ArrayList<ConsultaMedico>();
        String[] colunas = new String[]{"id_consulta", "id_medico", "especialidade", "endereco", "data", "hora8", "hora9", "hora10", "hora11", "hora13", "hora14", "hora15", "hora16", "hora17", "hora18"};

        Cursor cursor = bd.query("agendasMed", colunas, null, null, null, null,
                "id_medico");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                ConsultaMedico cm = new ConsultaMedico();
                cm.setId_consulta(cursor.getInt(0));
                cm.setId_medico(cursor.getInt(1));
                cm.setEspecialidade(cursor.getString(2));
                cm.setEndereco(cursor.getString(3));
                cm.setData(cursor.getString(4));
                cm.setHora8(cursor.getInt(5));
                cm.setHora9(cursor.getInt(6));
                cm.setHora10(cursor.getInt(7));
                cm.setHora11(cursor.getInt(8));
                cm.setHora13(cursor.getInt(9));
                cm.setHora14(cursor.getInt(10));
                cm.setHora15(cursor.getInt(11));
                cm.setHora16(cursor.getInt(12));
                cm.setHora17(cursor.getInt(13));
                cm.setHora18(cursor.getInt(14));


            } while (cursor.moveToNext());
        }
        return (list);
    }

    public ArrayList<ConsultaMedico> agendasCadastradas(Integer id) {
        ArrayList<ConsultaMedico> list = new ArrayList<>();


        String agendas = "SELECT * FROM agendasMed WHERE id_medico = " + "'" + id + "'";
        Cursor cursor = bdr.rawQuery(agendas, null);
        cursor.moveToFirst();
        do {
            ConsultaMedico cm = new ConsultaMedico();
            cm.setEspecialidade(cursor.getString(cursor.getColumnIndexOrThrow("especialidade")));
            cm.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            cm.setId_consulta(cursor.getInt(cursor.getColumnIndexOrThrow("id_consulta")));


            list.add(cm);

        } while (cursor.moveToNext());

        return list;
    }

    public void excluirAgenda(Integer id) {

        String excluirAgenda = "DELETE FROM agendasMed WHERE id_consulta = " + "'" + id + "'";

        bd.execSQL(excluirAgenda);

    }

    public ArrayList<ConsultaMedico> datasDisponiveis(String especialidade) {
        ArrayList<ConsultaMedico> listDatas = new ArrayList<>();

        String datas = "SELECT * FROM agendasMed WHERE especialidade = " + "'" + especialidade + "'";
        Cursor cursor = bdr.rawQuery(datas, null);
        cursor.moveToFirst();


        do {
            ConsultaMedico cm = new ConsultaMedico();
            cm.setId_consulta(cursor.getInt(cursor.getColumnIndexOrThrow("id_consulta")));
            cm.setEspecialidade(cursor.getString(cursor.getColumnIndexOrThrow("especialidade")));
            cm.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            cm.setId_medico(cursor.getInt(cursor.getColumnIndexOrThrow("id_medico")));
            cm.setHora8(cursor.getInt(cursor.getColumnIndexOrThrow("hora8")));
            cm.setHora9(cursor.getInt(cursor.getColumnIndexOrThrow("hora9")));
            cm.setHora10(cursor.getInt(cursor.getColumnIndexOrThrow("hora10")));
            cm.setHora11(cursor.getInt(cursor.getColumnIndexOrThrow("hora11")));
            cm.setHora13(cursor.getInt(cursor.getColumnIndexOrThrow("hora13")));
            cm.setHora14(cursor.getInt(cursor.getColumnIndexOrThrow("hora14")));
            cm.setHora15(cursor.getInt(cursor.getColumnIndexOrThrow("hora15")));
            cm.setHora16(cursor.getInt(cursor.getColumnIndexOrThrow("hora16")));
            cm.setHora17(cursor.getInt(cursor.getColumnIndexOrThrow("hora17")));
            cm.setHora18(cursor.getInt(cursor.getColumnIndexOrThrow("hora18")));

            listDatas.add(cm);

        } while (cursor.moveToNext());

        return listDatas;
    }

    public ConsultaMedico horariosDisponiveis(Integer id) {

        String datas = "SELECT * FROM agendasMed WHERE id_consulta = " + "'" + id + "'";
        Cursor cursor = bdr.rawQuery(datas, null);
        cursor.moveToFirst();
        ConsultaMedico cm = new ConsultaMedico();

        cm.setId_consulta(cursor.getInt(cursor.getColumnIndexOrThrow("id_consulta")));
        cm.setEspecialidade(cursor.getString(cursor.getColumnIndexOrThrow("especialidade")));
        cm.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
        cm.setId_medico(cursor.getInt(cursor.getColumnIndexOrThrow("id_medico")));
        cm.setHora8(cursor.getInt(cursor.getColumnIndexOrThrow("hora8")));
        cm.setHora9(cursor.getInt(cursor.getColumnIndexOrThrow("hora9")));
        cm.setHora10(cursor.getInt(cursor.getColumnIndexOrThrow("hora10")));
        cm.setHora11(cursor.getInt(cursor.getColumnIndexOrThrow("hora11")));
        cm.setHora13(cursor.getInt(cursor.getColumnIndexOrThrow("hora13")));
        cm.setHora14(cursor.getInt(cursor.getColumnIndexOrThrow("hora14")));
        cm.setHora15(cursor.getInt(cursor.getColumnIndexOrThrow("hora15")));
        cm.setHora16(cursor.getInt(cursor.getColumnIndexOrThrow("hora16")));
        cm.setHora17(cursor.getInt(cursor.getColumnIndexOrThrow("hora17")));
        cm.setHora18(cursor.getInt(cursor.getColumnIndexOrThrow("hora18")));

        return cm;
    }

    public void marcarConsulta(Integer id, Integer hora) {
        String coluna;
        switch (hora) {
            case 8:
                coluna = "hora8";
                break;
            case 9:
                coluna = "hora9";
                break;
            case 10:
                coluna = "hora10";
                break;
            case 11:
                coluna = "hora11";
                break;
            case 13:
                coluna = "hora13";
                break;
            case 14:
                coluna = "hora14";
                break;
            case 15:
                coluna = "hora15";
                break;
            case 16:
                coluna = "hora16";
                break;
            case 17:
                coluna = "hora17";
                break;
            case 18:
                coluna = "hora18";
                break;
            default:
                throw new IllegalArgumentException("Erro inesperado");
        }

        String marcarConsultaMed = "UPDATE agendasMed SET " + coluna + "= 3 WHERE id_consulta = " + "'" + id + "'";
        bd.execSQL(marcarConsultaMed);


    }


    public ArrayList<ConsultaMedico> proximasConsultas(Integer id) {
        ArrayList<ConsultaMedico> listConsultas = new ArrayList<>();

        String consultas = "SELECT * FROM agendasMed WHERE id_medico = " + "'" + id + "'";
        Cursor cursor = bdr.rawQuery(consultas, null);
        cursor.moveToFirst();


        do {
            ConsultaMedico cm = new ConsultaMedico();
            cm.setId_consulta(cursor.getInt(cursor.getColumnIndexOrThrow("id_consulta")));
            cm.setEspecialidade(cursor.getString(cursor.getColumnIndexOrThrow("especialidade")));
            cm.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            cm.setId_medico(cursor.getInt(cursor.getColumnIndexOrThrow("id_medico")));
            cm.setHora8(cursor.getInt(cursor.getColumnIndexOrThrow("hora8")));
            cm.setHora9(cursor.getInt(cursor.getColumnIndexOrThrow("hora9")));
            cm.setHora10(cursor.getInt(cursor.getColumnIndexOrThrow("hora10")));
            cm.setHora11(cursor.getInt(cursor.getColumnIndexOrThrow("hora11")));
            cm.setHora13(cursor.getInt(cursor.getColumnIndexOrThrow("hora13")));
            cm.setHora14(cursor.getInt(cursor.getColumnIndexOrThrow("hora14")));
            cm.setHora15(cursor.getInt(cursor.getColumnIndexOrThrow("hora15")));
            cm.setHora16(cursor.getInt(cursor.getColumnIndexOrThrow("hora16")));
            cm.setHora17(cursor.getInt(cursor.getColumnIndexOrThrow("hora17")));
            cm.setHora18(cursor.getInt(cursor.getColumnIndexOrThrow("hora18")));

            listConsultas.add(cm);

        } while (cursor.moveToNext());

        return listConsultas;
    }

}
