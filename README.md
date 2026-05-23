# PROGRAMACION 3 TP: Streaming de Musica

## Integrantes
- Argañaraz Martina
- Medina Arapa Antonella
- Vizgarra Maria Virginia


## Análisis de Complejidad Big O

### Búsqueda Binaria por Título
- **Complejidad: O(log n)**
- Divide la lista ordenada a la mitad en cada iteración
- Si hay 1000 canciones, hace máximo 10 comparaciones

### Búsqueda Lineal con Predicados (Streams filter)
- **Complejidad: O(n)**
- Recorre todas las canciones una vez

### Ordenamiento personalizado
- **Complejidad: O(n log n)**
- Usa el algoritmo TimSort de Java internamente

### Top 10 más reproducidas
- **Complejidad: O(n log n)**
- Ordena toda la lista y toma los primeros 10git add .
