package com.example.als.guiadebolsoaudio;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class FrutasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);

        ArrayList<Classuda> myClass = new ArrayList<>();
        myClass.add(new Classuda(getString(R.string.pera), getString(R.string.desc_pera), getString(R.string.trad_pera), R.drawable.pera));
        myClass.add(new Classuda(getString(R.string.uva), getString(R.string.desc_uva), getString(R.string.trad_uva), R.drawable.uva));
        myClass.add(new Classuda(getString(R.string.maca), getString(R.string.desc_maca), getString(R.string.trad_maca), R.drawable.maca));

        final ClassudaAdapter adapter = new ClassudaAdapter(this,myClass);

        ListView list = findViewById(R.id.listViewFruta);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Classuda cl = (Classuda)adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), cl.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}