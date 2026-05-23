package unlar.edu.ar.streaming_musica;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendacionDescubrimiento implements EstrategiaRecomendacion{
    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        LocalDate haceDoAnios = LocalDate.now().minusYears(2);
        return catalogo.stream()
            .filter(c -> c.getReproducciones().get() < 1000)
            .filter(c -> c.getFechaLanzamiento().isAfter(haceDoAnios))
            .filter(c -> !c.getGenero().equals(base.getGenero()))
            .collect(Collectors.toList());
    }

}
