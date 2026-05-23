package unlar.edu.ar.streaming_musica;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String id;
    private String titulo;
    private int anio;
    private List<Cancion> canciones = new ArrayList<>();

    public Album(String titulo, int anio){
        this.id= java.util.UUID.randomUUID().toString();
        this.titulo = titulo;
        this.anio = anio;
    }

    public void agregarCancion (Cancion cancion){
        canciones.add(cancion);
    }
    public String getId(){return id;}
    public String getTitulo(){return titulo;}
    public int getAnio(){return anio;}
    public List<Cancion> getCanciones (){return canciones;}

}
