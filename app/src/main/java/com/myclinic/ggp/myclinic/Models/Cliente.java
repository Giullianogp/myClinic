package com.myclinic.ggp.myclinic.Models;

import java.io.Serializable;

/**
 * Created by Giulliano on 22/05/2017.
 */

public class Cliente implements Serializable {

    private String nome;
    private String telefone;
    private String email;
    private String logradouro;
    private String cidade;
    private String cep;
    private String numero;
    private String complemento;

    public Cliente(String nome) {
        this.nome = nome;
    }


    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getLogradouro() {return logradouro;}
    public void setLogradouro(String logradouro) {this.logradouro = logradouro;}
    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}
    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}
    public String getComplemento() {return complemento;}
    public void setComplemento(String complemento) {this.complemento = complemento;}
}