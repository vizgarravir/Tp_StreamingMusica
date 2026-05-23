package unlar.edu.ar.streaming_musica;

import java.util.List;
import java.util.stream.Collectors;

public class RecomendacionPorGenero implements EstrategiaRecomendacion{
    @Override
    public List<Cancion> recomendar (List<Cancion> catalogo, Cancion base){
        return catalogo.stream()
        .filter(c -> c.getGenero ().equals (base.getGenero()))
        .filter(c -> !c.getId().equals(base.getId()))
        .sorted((a,b)-> Double.compare(b.getRating(),a.getRating()))
        .collect(Collectors.toList());
    }

}
