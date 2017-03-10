package com.example.logonrm.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private List<Pizza> pizzas;
    private ArrayAdapter<Pizza> adpPizza;
    private Spinner spSabor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spSabor = (Spinner) findViewById(R.id.spSabor);
        obterPizzas();
        popularSpinnerSabor();
        spSabor.setOnItemSelectedListener(this);
    }

    private void popularSpinnerSabor() {
        adpPizza = new ArrayAdapter<Pizza>(this, android.R.layout.simple_spinner_item, pizzas);
        spSabor.setAdapter(adpPizza);
    }

    private void obterPizzas() {
        pizzas = new ArrayList<Pizza>();
        pizzas.add(new Pizza(40, R.drawable.pizzabacon, "Bacon"));
        pizzas.add(new Pizza(32, R.drawable.pizzacarbonara, "Carbonara"));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Pizza pizza = (Pizza) parent.getItemAtPosition(position);

        Toast.makeText(this, pizza.getSabor(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
