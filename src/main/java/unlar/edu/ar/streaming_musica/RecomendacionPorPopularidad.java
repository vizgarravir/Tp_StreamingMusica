package unlar.edu.ar.streaming_musica;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendacionPorPopularidad implements EstrategiaRecomendacion{
    @Override
    public List<Cancion> recomendar (List<Cancion> catalogo, Cancion base){
        return catalogo.stream()
        .sorted((a,b) -> Integer.compare(b.getReproducciones().get(), a.getReproducciones().get()))
        .limit(5)
        .collect(Collectors.toList());
    }

}
