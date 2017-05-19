package com.example.logonrm.fipe;

/**
 * Created by logonrm on 11/05/2017.
 */

public class Modelo {

    private int id;
    private String nome;

    @Override
    public String toString() {
        return nome;
    }

    public Modelo() {

    }

    public Modelo(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
