package unlar.edu.ar.streaming_musica;

import java.util.ArrayList;
import java.util.Comparator;
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
public Cancion busquedaBinariaPorTitulo(String titulo) {
    List<Cancion> ordenadas = canciones.stream()
        .sorted((a, b) -> a.getTitulo().compareToIgnoreCase(b.getTitulo()))
        .collect(Collectors.toList());

    int izq = 0, der = ordenadas.size() - 1;
    while (izq <= der) {
        int mid = (izq + der) / 2;
        int cmp = ordenadas.get(mid).getTitulo().compareToIgnoreCase(titulo);
        if (cmp == 0) return ordenadas.get(mid);
        else if (cmp < 0) izq = mid + 1;
        else der = mid - 1;
    }
    return null;

}

public List<Cancion> ordenarPorArtistaYFecha() {
    return canciones.stream()
        .sorted(Comparator.comparing(Cancion::getArtista)
            .thenComparing(Cancion::getFechaLanzamiento)
            .reversed())
        .collect(Collectors.toList());
}

public java.util.Map<String, Long> distribucionPorDecadas() {
    return canciones.stream()
        .collect(Collectors.groupingBy(
            c -> (c.getFechaLanzamiento().getYear() / 10 * 10) + "s",
            Collectors.counting()
        ));
}


}
