package com.example.logonrm.votacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spPrefeitos;
    private Spinner spVereadores;


    private List<Candidato> prefeitos;
    private List<Candidato> vereadores;
    private ArrayAdapter<Candidato> adpPrefeito;
    private ArrayAdapter<Candidato> adpVereadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void criarPrefeitos() {
        prefeitos = new ArrayList<Candidato>();

        prefeitos.add(new Candidato("Ze da feira", "XTC"));
        prefeitos.add(new Candidato("Maria Melhor", "LLL"));
        prefeitos.add(new Candidato("Brandao Filho", "ZTO"));
    }

    private void criarVereadores() {
        vereadores = new ArrayList<Candidato>();

        vereadores.add(new Candidato("Joana Nascimento", "XTC"));
        vereadores.add(new Candidato("Lucio Dalla Pimenta", "LLL"));
        vereadores.add(new Candidato("Mariano Maria", "ZTO"));
    }

    private void popularSpinnerPrefeitos() {
        adpPrefeito = new ArrayAdapter<Candidato>(this, android.R.layout.simple_spinner_item, this.prefeitos);

        spPrefeitos.setAdapter(adpPrefeito);
    }

    private void popularSpinnerVereadores() {
        adpVereadores = new ArrayAdapter<Candidato>(this,android.R.layout.simple_spinner_item, this.vereadores);

        spPrefeitos.setAdapter(adpVereadores);
    }
}
