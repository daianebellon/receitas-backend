package br.com.daianebellon.receitas.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/")
    public List<ReceitaEntity> buscarReceitas() {
        return receitaService.buscarReceitas();
    }

    @GetMapping("/{id}")
    public ReceitaEntity buscarPeloId(@PathVariable Long id) {
        return receitaService.buscarPeloId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPeloId(@PathVariable Long id) {
        receitaService.deletarPeloId(id);
    }

    @PostMapping("/")
    public void cadastrar(@RequestBody ReceitaEntity receitaEntity) {
        receitaService.cadastrar(receitaEntity);
    }
}
