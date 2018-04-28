package com.example.als.guiadebolsoaudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumeroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero);

        ArrayList<Classuda> myClass = new ArrayList<>();
        myClass.add(new Classuda(getString(R.string.um), getString(R.string.desc_um), getString(R.string.trad_um), R.drawable.um));
        myClass.add(new Classuda(getString(R.string.cinco), getString(R.string.desc_cinco), getString(R.string.trad_cinco), R.drawable.cinco));
        myClass.add(new Classuda(getString(R.string.dez), getString(R.string.desc_dez), getString(R.string.trad_dez), R.drawable.dez));

        final ClassudaAdapter adapter = new ClassudaAdapter(this,myClass);

        ListView list = findViewById(R.id.listViewNumeros);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Classuda cl = (Classuda) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), cl.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
