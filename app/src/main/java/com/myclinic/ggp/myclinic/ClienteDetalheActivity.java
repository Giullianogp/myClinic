package com.myclinic.ggp.myclinic;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ClienteDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_detalhe);
    }

    public void OnCall(View v) {

        String phone = ((TextView)findViewById(R.id.textTelefone)).getText().toString();

        if (phone == ""){
            Toasty.warning(this,"Não foi informado o telefone.", Toast.LENGTH_SHORT, true).show();

        } else{

            Intent it = new Intent(Intent.ACTION_DIAL);
            it.setData(Uri.parse("tel:" + phone));
            if (it.resolveActivity(getPackageManager()) != null) {
                startActivity(it);
            }
        }

    }

    public void OnSave(View v) {

    }
}
