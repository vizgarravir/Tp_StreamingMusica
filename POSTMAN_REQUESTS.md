# Colección de Requests de Prueba

## 1. Listar todas las canciones
GET http://localhost:8080/api/canciones

## 2. Buscar canción por título (búsqueda binaria)
GET http://localhost:8080/api/canciones/busqueda-binaria?titulo=Anti-Hero

## 3. Filtrar por artista
GET http://localhost:8080/api/canciones/buscar?artista=Taylor Swift

## 4. Reproducir una canción
POST http://localhost:8080/api/canciones/{id}/reproducir

## 5. Top 10 más reproducidas
GET http://localhost:8080/api/canciones/top10

## 6. Estadísticas - distribución por décadas
GET http://localhost:8080/api/canciones/estadisticas/distribucion-decadas

## 7. Ordenamiento personalizado
GET http://localhost:8080/api/canciones/ordenar

## 8. Artista más popular
GET http://localhost:8080/api/canciones/estadisticas/artista-mas-popular

