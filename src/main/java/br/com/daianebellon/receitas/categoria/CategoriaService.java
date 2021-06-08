package br.com.daianebellon.receitas.categoria;

import br.com.daianebellon.receitas.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public CategoriaEntity buscarCategoriaPeloId(Long id) {
        if (id == null) {
            throw new NullPointerException("Id não pode ser null");
        }

        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
        return categoriaEntity.orElseThrow(() -> new NoResultException("Não encontrado!"));
    }

    @Transactional
    public List<CategoriaEntity> buscarCategorias() {
        return categoriaRepository.findAll();
    }

    @Transactional
    public void deletarCategoriaPeloId(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Transactional
    public void cadastrarCategoria(CategoriaEntity categoriaEntity) {
        //null, "", "    "  -> IllegalArgumentException("nome inválido.")
        if (categoriaEntity == null) {
            throw new NullPointerException("Categoria inválida.");
        }

        if (StringUtils.isBlank(categoriaEntity.getNome())) {
            throw new IllegalArgumentException("nome inválido.");
        }

        if (StringUtils.isBlank(categoriaEntity.getDescricao())) {
            throw new IllegalArgumentException("descricao inválida.");
        }

        if (categoriaEntity.getTipo() == null) {
            throw new NullPointerException("Tipo inválido.");
        }

        categoriaRepository.save(categoriaEntity);
    }

}
