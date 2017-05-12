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

        carregarMarcas();
    }

    private void carregarMarcas() {

        String url = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
        JsonArrayRequest request = new JsonArrayRequest(url, new RequestMarca(adpMarca), new RequestError());
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Marca marca = (Marca) parent.getItemAtPosition(position);
        Toast.makeText(this, "Cod: " + marca.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
