package com.myclinic.ggp.myclinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.myclinic.ggp.myclinic.Enums.SituacaoAgenda;
import com.myclinic.ggp.myclinic.Models.Agenda;
import com.myclinic.ggp.myclinic.Models.Cliente;

import es.dmoral.toasty.Toasty;

public class AgendaDetalheActivity extends AppCompatActivity {

    private Agenda _agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_detalhe);

        Intent it = getIntent();
        this._agenda = (Agenda) it.getSerializableExtra("agenda");

        ((TextView)findViewById(R.id.textCliente)).setText("Cliente: " +_agenda.getCliente().getNome());
        ((TextView)findViewById(R.id.textTelefone)).setText("Telefone: "+ _agenda.getCliente().getTelefone());
        ((TextView)findViewById(R.id.textTelefone)).setText("Horário: 25/05/2017 10:00");
        ((TextView)findViewById(R.id.textTelefone)).setText("Procedimento: Teste");
        ((LinearLayout)findViewById(R.id.linear)).setBackgroundColor(_agenda.getColor());

        if (_agenda.getSituacao() == SituacaoAgenda.Finalizada){

            ((Button)findViewById(R.id.btCancelar)).setVisibility(View.INVISIBLE);
            ((Button)findViewById(R.id.btConfirmar)).setVisibility(View.INVISIBLE);
        } else if (_agenda.getSituacao() == SituacaoAgenda.Cancelada){
            ((Button)findViewById(R.id.btCancelar)).setVisibility(View.INVISIBLE);
        }
    }

    public void onCancelar(View v){
        _agenda.setSituacao(SituacaoAgenda.Cancelada);
        Intent data = new Intent();
        data.putExtra("agenda", _agenda);
        setResult(RESULT_OK, data);
        Toasty.success(this, "Agenda cancelada", Toast.LENGTH_SHORT, true).show();
        finish();
    }

    public void onConfirmar(View v){

        _agenda.setSituacao(SituacaoAgenda.Finalizada);
        Intent data = new Intent();
        data.putExtra("agenda", _agenda );
        setResult(RESULT_OK, data);
        Toasty.success(this, "Agenda confirmada", Toast.LENGTH_SHORT, true).show();
        finish();

    }
}
