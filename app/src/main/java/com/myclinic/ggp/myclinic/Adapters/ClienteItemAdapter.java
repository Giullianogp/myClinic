package com.myclinic.ggp.myclinic.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myclinic.ggp.myclinic.Models.Cliente;
import com.myclinic.ggp.myclinic.R;

import java.util.List;

public class ClienteItemAdapter extends BaseAdapter {
    private List<Cliente> clientes;
    private Context context;

    public ClienteItemAdapter(List<Cliente> lista, Context contexto) {
        this.clientes = lista;
        this.context = contexto;
    }

    public void setListaClientes(List<Cliente> listaCliente) {
        this.clientes = listaCliente;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cliente cliente = clientes.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_cliente_item_template, null);
        ((TextView) view.findViewById(R.id.textPaciente)).setText(cliente.getNome());
        ((TextView) view.findViewById(R.id.textTelefone)).setText(cliente.getTelefone());
        return view;

    }
}
