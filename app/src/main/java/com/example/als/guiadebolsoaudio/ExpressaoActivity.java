package com.example.als.guiadebolsoaudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExpressaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expressao);
        ArrayList<Classuda> myClass = new ArrayList<>();
        myClass.add(new Classuda(getString(R.string.gato), getString(R.string.desc_gato), getString(R.string.trad_gato), R.drawable.gato));
        myClass.add(new Classuda(getString(R.string.butia), getString(R.string.desc_butia), getString(R.string.trad_butia), R.drawable.butia));
        myClass.add(new Classuda(getString(R.string.dois_de_paus), getString(R.string.desc_dois_de_paus), getString(R.string.trad_dois_de_paus), R.drawable.dois_de_paus));

        final ClassudaAdapter adapter = new ClassudaAdapter(this,myClass);

        ListView list = findViewById(R.id.listViewExpressao);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Classuda cl = (Classuda)adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), cl.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
