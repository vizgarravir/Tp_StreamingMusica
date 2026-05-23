package unlar.edu.ar.streaming_musica;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {
    private CatalogoMusica catalogo = new CatalogoMusica();
    public CancionController(){
        // Olivia Rodrigo
catalogo.agregarCancion(new Cancion("drivers license", "Olivia Rodrigo", "SOUR", "POP", 242, 4.8, LocalDate.of(2021, 1, 8)));
catalogo.agregarCancion(new Cancion("good 4 u", "Olivia Rodrigo", "SOUR", "POP", 178, 4.7, LocalDate.of(2021, 5, 14)));
catalogo.agregarCancion(new Cancion("Anti-Hero", "Taylor Swift", "Midnights", "POP", 200, 4.9, LocalDate.of(2022, 10, 21)));
catalogo.agregarCancion(new Cancion("Cruel Summer", "Taylor Swift", "Lover", "POP", 178, 4.8, LocalDate.of(2019, 8, 23)));

    }
    @GetMapping
    public List<Cancion> getCanciones(){
        return catalogo.getCanciones();
    }
    @GetMapping("{id}")
    public Cancion getCancionPorId(@PathVariable String id){
        return catalogo.getCanciones().stream()
        .filter(c->c.getId().equals(id))
        .findFirst()
        .orElse(null);
    }
    @GetMapping("/buscar")
    public List<Cancion> buscar( @RequestParam(required = false)String titulo,@RequestParam(required = false)String artista){
        return catalogo.getCanciones().stream()
        .filter(c-> titulo == null || c.getTitulo ().contains(titulo))
        .filter(c -> artista == null || c.getArtista().contains(artista))
        .toList();
    }
   @PostMapping("/{id}/reproducir")
        public String reproducir(@PathVariable String id) {
        catalogo.getCanciones().stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .ifPresent(Cancion::reproducir);
        return "Reproducción registrada";
    }
    // GET /api/canciones/estadisticas/promedio-por-genero
@GetMapping("/estadisticas/promedio-por-genero")
public double promedioPorGenero(@RequestParam String genero) {
    return catalogo.promedioDuracionPorGenero(genero);
}

// GET /api/canciones/estadisticas/artista-mas-popular
@GetMapping("/estadisticas/artista-mas-popular")
public String artistaMasPopular() {
    return catalogo.getCanciones().stream()
        .max((a, b) -> Integer.compare(
            a.getReproducciones().get(),
            b.getReproducciones().get()))
        .map(Cancion::getArtista)
        .orElse("Sin datos");
}

// GET /api/canciones/top10
@GetMapping("/top10")
public List<Cancion> top10() {
    return catalogo.top10MasReproducidas();
}
@GetMapping("/busqueda-binaria")
public Cancion busquedaBinaria(@RequestParam String titulo) {
    return catalogo.busquedaBinariaPorTitulo(titulo);
}
@GetMapping("/ordenar")
public List<Cancion> ordenar() {
    return catalogo.ordenarPorArtistaYFecha();
}
@GetMapping("/estadisticas/distribucion-decadas")
public java.util.Map<String, Long> distribucionDecadas() {
    return catalogo.distribucionPorDecadas();
}

}
