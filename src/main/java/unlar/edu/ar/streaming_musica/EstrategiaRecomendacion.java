package unlar.edu.ar.streaming_musica;
import java.util.List;

public interface EstrategiaRecomendacion {
    List <Cancion> recomendar(List<Cancion> catalogo, Cancion base);

}
