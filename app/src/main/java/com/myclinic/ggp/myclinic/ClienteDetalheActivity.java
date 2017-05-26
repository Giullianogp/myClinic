package com.myclinic.ggp.myclinic;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myclinic.ggp.myclinic.Database.ClienteDb;
import com.myclinic.ggp.myclinic.Models.Cliente;

import es.dmoral.toasty.Toasty;

public class ClienteDetalheActivity extends AppCompatActivity {

    private Cliente _cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_detalhe);

        Intent it = getIntent();
        if (it != null) {
            this._cliente = (Cliente) it.getSerializableExtra("cliente");
            if (_cliente != null) {
                ((TextView) findViewById(R.id.textNome)).setText(_cliente.getNome());
                ((TextView) findViewById(R.id.textEmail)).setText(_cliente.getEmail());
                ((TextView) findViewById(R.id.textTelefone)).setText(_cliente.getTelefone());
                ((TextView) findViewById(R.id.textCidade)).setText(_cliente.getCidade());
                ((TextView) findViewById(R.id.textLogradouro)).setText(_cliente.getLogradouro());
                ((TextView) findViewById(R.id.textCep)).setText(_cliente.getCep());
                ((TextView) findViewById(R.id.textNumero)).setText(_cliente.getNumero());
                ((TextView) findViewById(R.id.textComplemento)).setText(_cliente.getComplemento());
            }
        }
    }

    public void OnCall(View v) {

        String phone = ((TextView) findViewById(R.id.textTelefone)).getText().toString();

        if (phone.length() == 0) {
            Toasty.warning(this, "Não foi informado o telefone.", Toast.LENGTH_SHORT, true).show();

        } else {

            Intent it = new Intent(Intent.ACTION_DIAL);
            it.setData(Uri.parse("tel:" + phone));
            if (it.resolveActivity(getPackageManager()) != null) {
                startActivity(it);
            }
        }

    }

    public void OnSave(View v) {

        String nome = ((TextView) findViewById(R.id.textNome)).getText().toString();
        String email = ((TextView) findViewById(R.id.textEmail)).getText().toString();
        String telefone = ((TextView) findViewById(R.id.textTelefone)).getText().toString();
        String cidade = ((TextView) findViewById(R.id.textCidade)).getText().toString();
        String logradouro = ((TextView) findViewById(R.id.textLogradouro)).getText().toString();
        String cep = ((TextView) findViewById(R.id.textCep)).getText().toString();
        String numero = ((TextView) findViewById(R.id.textNumero)).getText().toString();
        String complemento = ((TextView) findViewById(R.id.textComplemento)).getText().toString();

        ClienteDb cli = new ClienteDb(this);

        if (_cliente == null) {
            _cliente = new Cliente(nome, telefone, email, logradouro, cidade, cep, numero, complemento);
            cli.Inserir(_cliente);
        } else {
            _cliente.setNome(nome);
            _cliente.setTelefone(telefone);
            _cliente.setEmail(email);
            _cliente.setLogradouro(logradouro);
            _cliente.setCidade(cidade);
            _cliente.setCep(cep);
            _cliente.setNumero(numero);
            _cliente.setComplemento(complemento);
            cli.Atualizar(_cliente);
        }

        Toasty.success(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT, true).show();
        finish();
    }

    public void onCancel(View v) {
        this.finish();
    }
}
