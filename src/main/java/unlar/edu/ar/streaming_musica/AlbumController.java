package unlar.edu.ar.streaming_musica;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/albumes")
public class AlbumController {

    private List<Album> albumes = new ArrayList<>();

    public AlbumController() {
        albumes.add(new Album("SOUR", 2021));
        albumes.add(new Album("Midnights", 2022));
        albumes.add(new Album("Lover", 2019));
    }

    @GetMapping
    public List<Album> getAlbumes() {
        return albumes;
    }

    @GetMapping("/{id}")
    public Album getAlbumPorId(@PathVariable String id) {
        return albumes.stream()
            .filter(a -> a.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @GetMapping("/buscar")
    public List<Album> buscar(@RequestParam String nombre) {
        return albumes.stream()
            .filter(a -> a.getTitulo().contains(nombre))
            .toList();
    }
}