package unlar.edu.ar.streaming_musica;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    private List<Artista> artistas = new ArrayList<>();

    public ArtistaController() {
        artistas.add(new Artista("Olivia Rodrigo", "Estadounidense"));
        artistas.add(new Artista("Taylor Swift", "Estadounidense"));
       
    }

    @GetMapping
    public List<Artista> getArtistas() {
        return artistas;
    }

    @GetMapping("/{id}")
    public Artista getArtistaPorId(@PathVariable String id) {
        return artistas.stream()
            .filter(a -> a.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @GetMapping("/buscar")
    public List<Artista> buscar(@RequestParam String nombre) {
        return artistas.stream()
            .filter(a -> a.getNombre().contains(nombre))
            .toList();
    }
}