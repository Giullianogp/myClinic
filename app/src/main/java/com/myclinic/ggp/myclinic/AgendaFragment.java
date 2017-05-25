package com.myclinic.ggp.myclinic;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.myclinic.ggp.myclinic.Adapters.AgendaItemAdapter;
import com.myclinic.ggp.myclinic.Enums.SituacaoAgenda;
import com.myclinic.ggp.myclinic.Models.Agenda;
import com.myclinic.ggp.myclinic.Models.Cliente;
import com.myclinic.ggp.myclinic.Models.Procedimento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AgendaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final int REQ_DETALHE=1;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    public AgendaFragment() {
        // Required empty public constructor
    }

    private AgendaItemAdapter agendaItemAdapter;
    private List<Agenda> listaAgenda = new ArrayList<>();
    int posicaoAlterar=-1;


    public static AgendaFragment newInstance(String param1, String param2) {
        AgendaFragment fragment = new AgendaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_agenda, container, false);

        Activity ac = getActivity();

        listaAgenda.add(new Agenda(1,new Cliente(1,"Pedro"),new Procedimento("", 20), new Date() ,"Agendamento", SituacaoAgenda.Finalizada));
        listaAgenda.add(new Agenda(2,new Cliente(2,"João"),new Procedimento( "asd", 20), new Date() ,"Agendamento",SituacaoAgenda.Aberta));
        listaAgenda.add(new Agenda(3,new Cliente(3,"Maria"),new Procedimento("asdas", 20), new Date() ,"Agendamento",SituacaoAgenda.Cancelada));
        listaAgenda.add(new Agenda(4,new Cliente(4,"José"),new Procedimento("asdasd", 20), new Date() ,"Agendamento",SituacaoAgenda.Aberta));

        agendaItemAdapter = new AgendaItemAdapter(listaAgenda, ac);
        ListView listView = (ListView)  v.findViewById(R.id.list_item);
        listView.setAdapter(agendaItemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Agenda agenda = listaAgenda.get(position);
                        posicaoAlterar = position;

                        Intent it = new Intent( getActivity() , AgendaDetalheActivity.class);
                        it.putExtra("agenda",agenda);
                        startActivityForResult(it,REQ_DETALHE);



                    }
                });

        return v;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
            void onFragmentInteraction(Uri uri);
    }
}
