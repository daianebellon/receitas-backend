package br.com.daianebellon.receitas.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping("/")
    public List<ReceitaEntity> buscarReceitas() {
        return receitaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ReceitaEntity buscarPeloId(@PathVariable Long id) {
        Optional<ReceitaEntity> receita = receitaRepository.findById(id);
        return receita.orElseThrow(() -> new NoResultException("Não encontrou!"));
    }

    @DeleteMapping("/{id}")
    public void deletarPeloId(@PathVariable Long id) {
        receitaRepository.deleteById(id);
    }

    @PostMapping("/")
    public void cadastrar(@RequestBody ReceitaEntity receitaEntity) {
        System.out.println(receitaEntity);

        receitaRepository.save(receitaEntity);
    }
}
