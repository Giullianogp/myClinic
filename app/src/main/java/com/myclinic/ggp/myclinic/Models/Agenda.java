package com.myclinic.ggp.myclinic.Models;

import android.graphics.Color;

import com.myclinic.ggp.myclinic.Enums.SituacaoAgenda;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Giulliano on 22/05/2017.
 */

public class Agenda implements Serializable {

    private int id;
    private Cliente cliente;
    private Procedimento procedimento;
    private SituacaoAgenda situacao;
    private Date data;
    private String comentario;

    public Agenda(int id, Cliente cliente, Procedimento procedimento, Date data, String comentario, SituacaoAgenda situacaoAgenda) {
        this.id = id;
        this.cliente = cliente;
        this.procedimento = procedimento;
        this.data = data;
        this.comentario = comentario;
        this.situacao = situacaoAgenda;
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

    public SituacaoAgenda getSituacao() {return situacao;}

    public void setSituacao(SituacaoAgenda situacao) {
        this.situacao = situacao;
    }

    public int getColor(){

        if (this.situacao == SituacaoAgenda.Aberta){
            return Color.parseColor("#80CBC4");
        } else if (this.situacao == SituacaoAgenda.Finalizada) {
            return Color.parseColor("#90CAF9");
        }else{
            return Color.parseColor("#EF9A9A");
        }

    }
}
