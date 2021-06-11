package br.com.daianebellon.receitas.receita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Transactional(readOnly = true) //transacao somente leitura (só faz select)
    public List<ReceitaEntity> buscarReceitas() {
        return receitaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ReceitaEntity buscarPeloId(Long id) {
        Optional<ReceitaEntity> receita = receitaRepository.findById(id); //Optional - trabalha com objetos que podem ou não ser null
        return receita.orElseThrow(() -> new NoResultException("Não encontrou!"));
    }

    @Transactional
    public void deletarPeloId(Long id) {
        receitaRepository.deleteById(id);
    }

    @Transactional
    public void cadastrar(ReceitaEntity receitaEntity) {
        System.out.println(receitaEntity);
        receitaRepository.save(receitaEntity);
    }
}
