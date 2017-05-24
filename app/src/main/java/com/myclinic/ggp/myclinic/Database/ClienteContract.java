package com.myclinic.ggp.myclinic.Database;

import com.myclinic.ggp.myclinic.Models.Cliente;

import java.util.List;

/**
 * Created by Giulliano on 24/05/2017.
 */

public interface ClienteContract {
    void Inserir(Cliente contato);
    void Excluir(Cliente contato);
    void Atualizar(Cliente contato);
    List<Cliente> Listar();
    Cliente procurarPorId(int id);
}
