package com.example.als.guiadebolsoaudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ParenteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parente);

        ArrayList<Classuda> myClass = new ArrayList<>();
        myClass.add(new Classuda(getString(R.string.tio), getString(R.string.desc_tio), getString(R.string.trad_tio), R.drawable.tio));
        myClass.add(new Classuda(getString(R.string.mae), getString(R.string.desc_mae), getString(R.string.trad_mae), R.drawable.mae));
        myClass.add(new Classuda(getString(R.string.avo), getString(R.string.desc_avo), getString(R.string.trad_avo), R.drawable.avo));

        final ClassudaAdapter adapter = new ClassudaAdapter(this,myClass);

        ListView list = findViewById(R.id.listViewParentes);
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
