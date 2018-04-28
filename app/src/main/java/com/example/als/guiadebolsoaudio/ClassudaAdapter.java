package com.example.als.guiadebolsoaudio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by als on 26/04/2018.
 */

public class ClassudaAdapter extends ArrayAdapter<Classuda>{
    public ClassudaAdapter(@NonNull Context context, @NonNull List<Classuda> objects){
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View conterView, @NonNull ViewGroup parent){
        View listItemView = conterView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list, parent, false);
        }

        Classuda current = getItem(position);
        TextView  txt1, txt2;
        ImageView img;

        txt1 = listItemView.findViewById(R.id.txtNome);
        txt2 = listItemView.findViewById(R.id.txtDescricao);
        img = listItemView.findViewById(R.id.imageView);

        txt1.setText(current.getNome().toString());
        txt2.setText(current.getDescricao().toString());
        img.setImageResource(current.getImg());
        return listItemView;
    }
}
