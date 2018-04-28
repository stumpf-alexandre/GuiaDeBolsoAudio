package com.example.als.guiadebolsoaudio;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

public class ListActivity extends ArrayAdapter<String>{
    private String [] nome;
    private String [] descricao;
    private Integer[] img;
    private Activity context;
    public ListActivity(Activity context, String[] nome, String[] descricao, Integer[] img){
        super(context, R.layout.activity_list,nome);

        this.context = context;
        this.nome = nome;
        this.descricao = descricao;
        this.img = img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null){
            LayoutInflater layout = context.getLayoutInflater();
            r = layout.inflate(R.layout.activity_list, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.imv.setImageResource(img[position]);
        viewHolder.txt1.setText(nome[position]);
        viewHolder.txt2.setText(descricao[position]);

        return r;
    }

    class ViewHolder
    {
        TextView txt1;
        TextView txt2;
        ImageView imv;
        ViewHolder(View v){
            txt1 = v.findViewById(R.id.txtNome);
            txt2 = v.findViewById(R.id.txtDescricao);
            imv = v.findViewById(R.id.imageView);
        }
    }
}
