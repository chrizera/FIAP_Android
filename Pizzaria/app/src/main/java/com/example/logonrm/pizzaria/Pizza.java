package com.example.logonrm.pizzaria;

/**
 * Created by logonrm on 09/03/2017.
 */

public class Pizza {
    private String sabor;
    private double preco;
    private int idImagem;

    public Pizza(double preco, int idImagem, String sabor) {
        this.preco = preco;
        this.idImagem = idImagem;
        this.sabor = sabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    @Override
    public String toString() {
        return sabor + ": " + "R$" + preco;
    }
}
