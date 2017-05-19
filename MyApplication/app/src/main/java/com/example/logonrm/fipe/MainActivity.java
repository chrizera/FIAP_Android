package com.example.logonrm.fipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spMarca;
    private List<Marca> marcas;
    private ArrayAdapter<Marca> adpMarca;

    private Spinner spVeiculo;
    private List<Veiculo> veiculos;
    private ArrayAdapter<Veiculo> adpVeiculo;

    private  Spinner spModelo;
    private List<Modelo> modelos;
    private  ArrayAdapter<Modelo> adpModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spMarca = (Spinner) findViewById(R.id.spMarca);
        spMarca.setOnItemSelectedListener(this);
        marcas = new ArrayList<Marca>();
        adpMarca = new ArrayAdapter<Marca>(this, android.R.layout.simple_spinner_item, marcas);
        spMarca.setAdapter(adpMarca);

        adpMarca.add(new Marca("Escolha a marca", -1));

        spVeiculo = (Spinner) findViewById(R.id.spVeiculo);
        spVeiculo.setOnItemSelectedListener(this);
        veiculos = new ArrayList<Veiculo>();
        adpVeiculo = new ArrayAdapter<Veiculo>(this, android.R.layout.simple_spinner_item, veiculos);
        spVeiculo.setAdapter(adpVeiculo);

        adpVeiculo.add(new Veiculo("Escolha o veiculo", -1));

        spModelo = (Spinner) findViewById(R.id.spModelo);
        spModelo.setOnItemSelectedListener(this);
        modelos = new ArrayList<Modelo>();
        adpModelo = new ArrayAdapter<Modelo>(this, android.R.layout.simple_spinner_item, modelos);
        spModelo.setAdapter(adpModelo);

        adpModelo.add(new Modelo("Escolha o modelo", -1));

        carregarMarcas();
    }

    private void carregarMarcas() {

        String url = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
        JsonArrayRequest request = new JsonArrayRequest(url, new RequestMarca(adpMarca), new RequestError());
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    private void carregarVeiculos(int idMarca) {
        String url = "http://fipeapi.appspot.com/api/1/carros/veiculos/" + idMarca + ".json";
        JsonArrayRequest request = new JsonArrayRequest(url, new RequestVeiculo(adpVeiculo), new RequestError());
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    private void carregarModelos(int idMarca, int idVeiculo) {
        String url = "http://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + idVeiculo + "/.json";
        JsonArrayRequest request = new JsonArrayRequest(url, new RequestModelo(adpModelo), new RequestError());
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Object sel = parent.getItemAtPosition(position);

        if (sel instanceof  Marca) {
            adpVeiculo.clear();
            Marca marca = (Marca) sel;
            carregarVeiculos(marca.getId());
        }
        else if (sel instanceof  Veiculo) {
            adpModelo.clear();
            Veiculo veiculo = (Veiculo) sel;
            carregarModelos(2, veiculo.getId());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
