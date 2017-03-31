package com.example.logonrm.votacao;

/**
 * Created by logonrm on 30/03/2017.
 */

public class Candidato {

    private String nome;
    private String siglaPartido;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public Candidato() {
    }

    public Candidato(String nome, String siglaPartido) {

        this.nome = nome;
        this.siglaPartido = siglaPartido;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " - Partido: " + getSiglaPartido();
    }
}
