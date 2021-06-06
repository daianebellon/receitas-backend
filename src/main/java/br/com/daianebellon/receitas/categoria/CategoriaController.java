package br.com.daianebellon.receitas.categoria;

import br.com.daianebellon.receitas.receita.ReceitaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public CategoriaEntity buscarPeloId(@PathVariable Long id) {
        return categoriaService.buscarCategoriaPeloId(id);
    }

    @GetMapping("/")
    public List<CategoriaEntity> buscarCategorias() {
       return categoriaService.buscarCategorias();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaService.deletarCategoriaPeloId(id);
    }

    @PostMapping("/")
    public void cadastrar(@RequestBody CategoriaEntity categoriaEntity) {
        categoriaService.cadastrarCategoria(categoriaEntity);
    }
}
