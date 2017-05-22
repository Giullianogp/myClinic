package com.myclinic.ggp.myclinic.Models;

import java.io.Serializable;

/**
 * Created by Giulliano on 22/05/2017.
 */

public class Procedimento implements Serializable {

    private String nome;
    private float valor;

    public Procedimento(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
