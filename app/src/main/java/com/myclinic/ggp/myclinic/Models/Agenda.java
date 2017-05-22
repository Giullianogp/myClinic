package com.myclinic.ggp.myclinic.Models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Giulliano on 22/05/2017.
 */

public class Agenda implements Serializable {


    private Cliente cliente;
    private Procedimento procedimento;
    private Date data;
    private String comentario;

    public Agenda(Cliente cliente, Procedimento procedimento, Date data, String comentario) {
        this.cliente = cliente;
        this.procedimento = procedimento;
        this.data = data;
        this.comentario = comentario;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
