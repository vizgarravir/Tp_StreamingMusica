package unlar.edu.ar.streaming_musica;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productoras")
public class ProductoraController {

    private List<Productora> productoras = new ArrayList<>();

    public ProductoraController() {
        productoras.add(new Productora("Geffen Records", "Estados Unidos"));
        productoras.add(new Productora("Republic Records", "Estados Unidos"));
    }

    @GetMapping
    public List<Productora> getProductoras() {
        return productoras;
    }

    @GetMapping("/{id}")
    public Productora getProductoraPorId(@PathVariable String id) {
        return productoras.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @GetMapping("/buscar")
    public List<Productora> buscar(@RequestParam String nombre) {
        return productoras.stream()
            .filter(p -> p.getNombre().contains(nombre))
            .toList();
    }
}