package com.myclinic.ggp.myclinic.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myclinic.ggp.myclinic.Enums.SituacaoAgenda;
import com.myclinic.ggp.myclinic.Models.Agenda;
import com.myclinic.ggp.myclinic.R;

import java.util.List;

/**
 * Created by giull on 22/05/2017.
 */

public class AgendaItemAdapter extends BaseAdapter {

    private List<Agenda> agendas;
    private Context context;

    public AgendaItemAdapter(List<Agenda> lista, Context contexto) {
        this.agendas = lista;
        this.context = contexto;
    }


    @Override
    public int getCount() {
        return agendas.size();
    }

    @Override
    public Object getItem(int position) {
        return agendas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Agenda agenda = agendas.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_agenda_item_template, null);
        ((TextView) view.findViewById(R.id.textPaciente)).setText(agenda.getCliente().getNome());
        ((TextView) view.findViewById(R.id.textProc)).setText(agenda.getProcedimento().getNome());
        view.findViewById(R.id.linear_agenda).setBackgroundColor(agenda.getColor());

        return view;

    }
}
