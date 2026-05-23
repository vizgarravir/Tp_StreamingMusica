package unlar.edu.ar.streaming_musica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoMusica {
    private List<Cancion> canciones = new ArrayList<>();

    public void agregarCancion(Cancion cancion){
        canciones.add(cancion);
    }
    public List<Cancion> getCanciones(){return canciones;}

    public List<Cancion> filtrarPorGenero(String genero){
        return canciones.stream()
        .filter(c -> c.getGenero().equals(genero))
        .collect(Collectors.toList());
    }

    public List<Cancion> top10MasReproducidas(){
        return canciones.stream()
        .sorted((a,b) -> Integer.compare(b.getReproducciones().get(), a.getReproducciones().get()))
        .limit(10)
        .collect(Collectors.toList());
    }

    public List<Cancion> filtrarPorRating (double ratinMinimo){
        return canciones.stream()
        .filter( c -> c.getRating()>= ratinMinimo)
        .collect(Collectors.toList());
    }

    public List<Cancion> filtrarPorArtista(String artista){
        return canciones.stream()
        .filter(c->c.getArtista().equals(artista))
        .collect(Collectors.toList());
    }

    public double promedioDuracionPorGenero(String genero){
        return canciones.stream()
        .filter(c->c.getGenero().equals(genero))
        .collect(Collectors.averagingInt(Cancion::getDuracionSegundos));
    }







}
