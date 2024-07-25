package jerff.devs.FPBE_Aula3.controller;

import jerff.devs.FPBE_Aula3.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jerff.devs.FPBE_Aula3.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public Categoria adicionarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obterCategoria(@PathVariable Long id) {
        Categoria categoria = categoriaService.obterCategoriaPorId(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDetalhes) {
        Categoria categoria = categoriaService.obterCategoriaPorId(id);
        if (categoria != null) {
            categoria.setNome(categoriaDetalhes.getNome());
            return ResponseEntity.ok(categoriaService.salvarCategoria(categoria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}