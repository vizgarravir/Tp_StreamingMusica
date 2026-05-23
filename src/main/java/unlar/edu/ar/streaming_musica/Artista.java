package unlar.edu.ar.streaming_musica;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private String id;
    private String nombre;
    private String nacionalidad;
    private List<Album> albumes = new ArrayList<>();

    public Artista(String nombre, String nacionalidad){
            this.id = java.util.UUID.randomUUID().toString();
            this.nombre=nombre;
            this.nacionalidad=nacionalidad;
    }
    public void agregarAlbum (Album album){
        albumes.add(album);
    }
    public String getId(){return id;}
    public String getNombre(){return nombre;}
    public String getNacionalidad (){return nacionalidad;}
    public List<Album> getAlbumes (){return albumes;}
    


    





}
