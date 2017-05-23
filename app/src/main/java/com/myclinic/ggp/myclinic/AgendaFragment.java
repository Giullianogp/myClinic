package com.myclinic.ggp.myclinic;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    public AgendaFragment() {
        // Required empty public constructor
    }

    private AgendaItemAdapter agendaItemAdapter;
    private List<Agenda> listaAgenda = new ArrayList<>();
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgendaFragment.
     */
    // TODO: Rename and change types and number of parameters
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

        listaAgenda.add(new Agenda(new Cliente("Pedro"),new Procedimento("", 20), new Date() ,"Agendamento", SituacaoAgenda.Finalizada));
        listaAgenda.add(new Agenda(new Cliente("João"),new Procedimento("asd", 20), new Date() ,"Agendamento",SituacaoAgenda.Aberta));
        listaAgenda.add(new Agenda(new Cliente("Maria"),new Procedimento("asdas", 20), new Date() ,"Agendamento",SituacaoAgenda.Cancelada));
        listaAgenda.add(new Agenda(new Cliente("José"),new Procedimento("asdasd", 20), new Date() ,"Agendamento",SituacaoAgenda.Aberta));

        agendaItemAdapter = new AgendaItemAdapter(listaAgenda, ac);
        ListView listView = (ListView)  v.findViewById(R.id.list_item);
        listView.setAdapter(agendaItemAdapter);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
