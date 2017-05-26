package com.myclinic.ggp.myclinic.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.myclinic.ggp.myclinic.Models.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giulliano on 24/05/2017.
 */

public class ClienteDb implements ClienteContract {

    private DataBaseHelper bdOpenHelper;

    public ClienteDb(Context contexto) {
        bdOpenHelper = new DataBaseHelper(contexto);
    }


    @Override
    public void Inserir(Cliente contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("Nome", contato.getNome());
        valores.put("Telefone", contato.getTelefone());
        valores.put("Email", contato.getEmail());
        valores.put("Cep", contato.getCep());
        valores.put("Cidade", contato.getCidade());
        valores.put("Logradouro", contato.getLogradouro());
        valores.put("Numero", contato.getNumero());
        valores.put("Email", contato.getEmail());

        banco.insert("Cliente", null, valores);

        banco.close();
    }

    @Override
    public void Excluir(Cliente contato) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();
        banco.delete("Cliente", "id=?",
                new String[]{String.valueOf(contato.getId())});
        banco.close();
    }

    @Override
    public void Atualizar(Cliente cliente) {
        SQLiteDatabase banco = bdOpenHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("Nome", cliente.getNome());
        valores.put("Telefone", cliente.getTelefone());
        valores.put("Email", cliente.getEmail());
        valores.put("Cep", cliente.getCep());
        valores.put("Cidade", cliente.getCidade());
        valores.put("Logradouro", cliente.getLogradouro());
        valores.put("Numero", cliente.getNumero());
        valores.put("Email", cliente.getEmail());

        banco.update("Cliente", valores, "id=?",
                new String[]{String.valueOf(cliente.getId())});
        banco.close();
    }

    @Override
    public List<Cliente> Listar() {
        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();

        Cursor cursor = banco.query("Cliente",
                new String[]{"id", "Nome", "Telefone", "Email", "Cidade", "Cep", "Logradouro", "Numero", "Complemento"},
                null, null, null, null, "nome");

        List<Cliente> listaContatos = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String cidade = cursor.getString(cursor.getColumnIndex("cidade"));
            String logradouro = cursor.getString(cursor.getColumnIndex("logradouro"));
            String numero = cursor.getString(cursor.getColumnIndex("numero"));
            String complemento = cursor.getString(cursor.getColumnIndex("complemento"));
            String cep = cursor.getString(cursor.getColumnIndex("cep"));

            Cliente contato = new Cliente(id, nome, telefone, email, logradouro, cidade, cep, numero, complemento);
            listaContatos.add(contato);
        }
        return listaContatos;
    }

    @Override
    public Cliente procurarPorId(int id) {
        SQLiteDatabase banco = bdOpenHelper.getReadableDatabase();

        Cursor cursor = banco.query("Cliente",
                new String[]{"id", "nome", "telefone", "Email", "Cidade", "Cep", "Logradouro", "Numero", "Complemento"},
                "id = ?", new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor.moveToNext()) {
            int idX = cursor.getInt(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String cidade = cursor.getString(cursor.getColumnIndex("cidade"));
            String logradouro = cursor.getString(cursor.getColumnIndex("logradouro"));
            String numero = cursor.getString(cursor.getColumnIndex("numero"));
            String complemento = cursor.getString(cursor.getColumnIndex("complemento"));
            String cep = cursor.getString(cursor.getColumnIndex("cep"));
            Cliente contato = new Cliente(idX, nome, telefone, email, logradouro, cidade, cep, numero, complemento);
            return contato;
        }
        return null;
    }
}
