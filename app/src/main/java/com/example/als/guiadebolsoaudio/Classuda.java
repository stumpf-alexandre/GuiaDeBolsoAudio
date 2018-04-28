package com.example.als.guiadebolsoaudio;

/**
 * Created by als on 26/04/2018.
 */

public class Classuda {

    private String nome;
    private String descricao;
    private String traducao;
    private Integer img;

    public Classuda(String nome, String descricao, String traducao, Integer img){
        this.nome = nome.toString();
        this.descricao = descricao.toString();
        this.traducao = traducao.toString();
        this.img = img;
    }
    public String getNome() { return nome; }

    public String getDescricao() {
        return descricao;
    }

    public String getTraducao() {
        return traducao;
    }

    public Integer getImg() {
        return img;
    }

    @Override
    public String toString(){
        return "Tradução = " + traducao;

    }
}
