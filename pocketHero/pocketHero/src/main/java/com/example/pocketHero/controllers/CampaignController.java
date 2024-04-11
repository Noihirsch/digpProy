package com.example.pocketHero.controllers;

import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/campaign")
public class CategoryController {
    @Autowired
    public CategoryService categoriaService;
    @Autowired
    public ProductoService productoService;
    

    @GetMapping("/")
    public ResponseEntity<?> showCategories() {
        return ResponseEntity.ok(categoriaService.obtenerTodos());
    }

    @GetMapping("/nuevaCategoria")
    public ResponseEntity<?> createCategoria(@Valid @RequestBody Categoria categoria) {
        if (categoria != null){
            try{
                categoriaService.añadir(categoria);
                return ResponseEntity.ok(categoria);
            } catch (Exception e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("No se ha podido añadir la categoria");
        }

    }

    @GetMapping("/editarCategoria/{id}")
    public ResponseEntity<?> showEditForm(@PathVariable long id) {
        Categoria categoria;
        try {
            categoria = categoriaService.obtenerPorId(id);
        } catch (NotFoundException nfe){
            return ResponseEntity.notFound().build();
        }
        if (categoria != null)
            return ResponseEntity.ok(categoria);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/borrarCategoria/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable long id) {
        try {
            if (productoService.obtenerPorCategoria(id).size() == 0){
                categoriaService.borrarPorId(id);
                return ResponseEntity.ok().build();
        }   else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede borrar una categoria con productos asociados a ella");
        }  
        } catch (NotFoundException nfe) {
            return ResponseEntity.notFound().build();
        }
    }
}