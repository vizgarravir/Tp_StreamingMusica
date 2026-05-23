package unlar.edu.ar.streaming_musica;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Productora {
    private String id;
    private String nombre;
    private String pais;
    private List <Artista> artistas = new ArrayList<>();
    private List<Album> albumes = new ArrayList<>();

    public Productora(String nombre, String pais){
        this.id = java.util.UUID.randomUUID().toString();
        this.nombre=nombre;
        this.pais=pais;
    }
    public void agregarArtista( Artista artista){
        artistas.add(artista);
    }
    public void agregarAlbum(Album album){
        albumes.add(album);
    }
    public String getId(){return id;}
    public String getNombre(){return nombre;}
    public String getPais(){return pais;}
    public List<Artista> getArtistas(){ return artistas;}
    public List<Album> getAlbumes(){ return albumes;}    

}
