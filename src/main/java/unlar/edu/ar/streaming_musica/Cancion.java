package unlar.edu.ar.streaming_musica;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Cancion {
    private String id;
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int duracionSegundos;
    private AtomicInteger reproducciones;
    private double rating;
    private LocalDate fechaLanzamiento;


public Cancion(String titulo, String artista, String album, String genero, int duracionSegundos, double rating, LocalDate fechaLanzamiento) {
    this.id = java.util.UUID.randomUUID().toString();
    this.titulo = titulo;
    this.artista = artista;
    this.album = album;
    this.genero = genero;
    this.duracionSegundos = duracionSegundos;
    this.reproducciones = new AtomicInteger(0);
    this.rating = rating;
    this.fechaLanzamiento = fechaLanzamiento;
}
    
    public String getId(){ return id;}
    public String getTitulo (){return titulo;}
    public String getArtista(){ return artista;}
    public String getAlbum(){ return album;}
    public String getGenero(){ return genero;}
    public int getDuracionSegundos (){return duracionSegundos;}
    public AtomicInteger getReproducciones() { return reproducciones; }    public double getRating(){ return rating;}
    public LocalDate getFechaLanzamiento(){ return fechaLanzamiento;}

    public void reproducir() {
        reproducciones.incrementAndGet();
    }

}
