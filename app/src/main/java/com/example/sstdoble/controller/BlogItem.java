package com.example.sstdoble.controller;

public class BlogItem {

    public String titulo;
    public String imgUri;
    public String desc;

    public BlogItem (String titulo, String imgUri, String desc){
        this.titulo = titulo;
        this.imgUri = imgUri;
        this.desc = desc;
    }

    public String getTitulo(){return titulo;}
    public String getImgUri(){return imgUri;}
    public String getDesc(){return desc;}
}
