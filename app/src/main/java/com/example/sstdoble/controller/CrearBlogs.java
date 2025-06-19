package com.example.sstdoble.controller;

public class CrearBlogs {

private int id;
    private String titulo;

    private String urlImg;

    private String desc;

    public CrearBlogs() {

    }

    public CrearBlogs (int id,String titulo, String desc ,String urlImg){
        this.id = id;
        this.desc = desc;
        this.titulo = titulo;
        this.urlImg = urlImg;
    }

    public String getTitulo(){return titulo;}

    public void setTitulo(String titulo){this.titulo = titulo;}
    public String getUrlImg(){return urlImg;}

    public void setUrlImg(String urlImg){this.urlImg = urlImg;}
    public String getDesc(){return desc;}
    public void setDesc(String desc){this.desc = desc;}


    @Override
    public String toString(){
        return "CrearBlog{" +
                "titulo=" + titulo +
                ", desc=" + desc +
                ", urlImg" + urlImg + '\'' +
                '}';
    }
}
