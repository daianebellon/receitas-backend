package br.com.daianebellon.receitas.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public CategoriaEntity buscarCategoriaPeloId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new NoResultException("Não encontrado!"));
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
        System.out.println(categoriaEntity);
        categoriaRepository.save(categoriaEntity);
    }
}
