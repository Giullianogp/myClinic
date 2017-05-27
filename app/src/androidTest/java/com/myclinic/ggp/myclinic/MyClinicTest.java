package com.myclinic.ggp.myclinic;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.myclinic.ggp.myclinic.Database.ClienteDb;
import com.myclinic.ggp.myclinic.Models.Cliente;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by giull on 26/05/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MyClinicTest {

    public void ClientInsertTest() throws Exception{

        Context appContext = InstrumentationRegistry.getTargetContext();
        ClienteDb db = new ClienteDb(appContext);
        int quantidadeOld = db.Listar().size();
        db.Inserir(new Cliente("Joao","545321534","","","","","",""));
        int quantidadeNew  = db.Listar().size();
        assertEquals(quantidadeOld + 1,quantidadeNew);
    }
}
