package com.example.appclinica1;

import java.util.ArrayList;

public class AuxAdapterProximasConsultasMed {

    public AuxAdapterProximasConsultasMed() {
    }

    public ArrayList<ConsultaPaciente> trocaLista (ArrayList<ConsultaMedico> listMed) {
        ArrayList<ConsultaPaciente> list = new ArrayList<>();


        for (int i = 0; i < listMed.size(); i++) {
            if (listMed.get(i).getHora8() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("08:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora9() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("09:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora10() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("10:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora11() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("11:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora13() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("13:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora14() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("14:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora15() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("15:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora16() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("16:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora17() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("17:00");
                list.add(cp);
            }
            if (listMed.get(i).getHora18() == 3) {
                ConsultaPaciente cp = new ConsultaPaciente();
                cp.setEspecialidade(listMed.get(i).getEspecialidade());
                cp.setData(listMed.get(i).getData());
                cp.setHorario("18:00");
                list.add(cp);
            }
        }
        return list;
    }
}