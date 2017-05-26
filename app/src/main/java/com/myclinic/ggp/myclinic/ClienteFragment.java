package com.myclinic.ggp.myclinic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.myclinic.ggp.myclinic.Adapters.AgendaItemAdapter;
import com.myclinic.ggp.myclinic.Adapters.ClienteItemAdapter;
import com.myclinic.ggp.myclinic.Database.ClienteDb;
import com.myclinic.ggp.myclinic.Enums.SituacaoAgenda;
import com.myclinic.ggp.myclinic.Models.Agenda;
import com.myclinic.ggp.myclinic.Models.Cliente;
import com.myclinic.ggp.myclinic.Models.Procedimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteFragment extends Fragment {

    private ClienteItemAdapter clienteItemAdapter;
    private List<Cliente> listaCliente = new ArrayList<>();
    int posicaoAlterar = -1;
    private static final int REQ_DETALHE = 1;

    private OnFragmentInteractionListener mListener;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ClienteFragment() {

    }

    public static ClienteFragment newInstance(String param1, String param2) {
        ClienteFragment fragment = new ClienteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cliente, container, false);

        Activity ac = getActivity();

        //CreateClientes();

        clienteItemAdapter = new ClienteItemAdapter(listaCliente, ac);
        ListView listView = (ListView) v.findViewById(R.id.list_item);
        listView.setAdapter(clienteItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cliente cliente = listaCliente.get(position);
                posicaoAlterar = position;

                Intent it = new Intent(getActivity(), ClienteDetalheActivity.class);
                it.putExtra("cliente", cliente);
                startActivityForResult(it, REQ_DETALHE);


            }
        });

        return v;
    }

    private void CreateClientes() {
        listaCliente.add(new Cliente(1, "Pedro"));
        listaCliente.add(new Cliente(2, "João"));
        listaCliente.add(new Cliente(3, "Maria"));
        listaCliente.add(new Cliente(4, "josé"));
        listaCliente.add(new Cliente(5, "Luiz"));
        listaCliente.add(new Cliente(6, "Claudio"));
        listaCliente.add(new Cliente(7, "Marcos"));
        listaCliente.add(new Cliente(8, "Bruna"));
    }

    public void onNew(View v){
        Intent it = new Intent(getActivity(), ClienteDetalheActivity.class);
        startActivityForResult(it, REQ_DETALHE);
    }

    @Override
    public void onResume() {
        super.onResume();
        ClienteDb db = new ClienteDb(getActivity());
        listaCliente = db.Listar();
        clienteItemAdapter.setListaClientes(listaCliente);
        clienteItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
