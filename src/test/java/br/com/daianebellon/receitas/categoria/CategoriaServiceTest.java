package br.com.daianebellon.receitas.categoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CategoriaServiceTest {

    @InjectMocks //
    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Test
    public void buscarCategoriaPeloIdQuandoIdForNull() {
        try {
            categoriaService.buscarCategoriaPeloId(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Id não pode ser null", e.getMessage());
        }
    }

    @Test
    public void buscarCategoriaPeloId() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(1L);
        categoriaEntity.setNome("Bolo");
        categoriaEntity.setTipo(TipoCategoria.COMIDA);

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoriaEntity));

        CategoriaEntity categoriaEntityRetorno = categoriaService.buscarCategoriaPeloId(1L);

        assertEquals(categoriaEntity.getNome(), categoriaEntityRetorno.getNome()); //valor explicito(esperado) tenho que saber qual o valor/ valor dinamico
        assertEquals(categoriaEntity.getTipo(), categoriaEntityRetorno.getTipo());
        assertEquals(categoriaEntity.getId(), categoriaEntityRetorno.getId());
    }

    @Test
    public void verificaSeCategoriaEhNull() {
        try {
            categoriaService.cadastrarCategoria(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Categoria inválida.", e.getMessage());
        }
    }

    @Test
    public void cadastrarCategoriaQuandoCategoriaNomeForNull() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome(null);
        categoriaEntity.setDescricao("bolo de chocolate");
        categoriaEntity.setTipo(TipoCategoria.COMIDA);

        try {
            categoriaService.cadastrarCategoria(categoriaEntity);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("nome inválido.", e.getMessage());
        }

        verify(categoriaRepository, never()).save(categoriaEntity);
    }

    @Test
    public void cadastrarCategoriaQuandoCategoriaNomeForEmBranca() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome("  ");
        categoriaEntity.setDescricao("bolo de chocolate");
        categoriaEntity.setTipo(TipoCategoria.COMIDA);

        try {
            categoriaService.cadastrarCategoria(categoriaEntity);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("nome inválido.", e.getMessage());
        }
    }

    @Test
    public void cadastrarCategoriaQuandoCategoriaDescricaoForNull() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome("Bolo de chocolate");
        categoriaEntity.setDescricao(null);
        categoriaEntity.setTipo(TipoCategoria.COMIDA);

        try {
            categoriaService.cadastrarCategoria(categoriaEntity);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("descricao inválida.", e.getMessage());
        }
    }

    @Test
    public void cadastrarCategoriaQuandoCategoriaDescricaoForEmBranca() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome("Bolo de chocolate");
        categoriaEntity.setDescricao("      ");
        categoriaEntity.setTipo(TipoCategoria.COMIDA);

        try {
            categoriaService.cadastrarCategoria(categoriaEntity);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("descricao inválida.", e.getMessage());
        }
    }

    @Test
    public void cadastrarCategoriaQuandoTipoCategoriaForNull() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome("Bolo de chocolate");
        categoriaEntity.setDescricao("Bata no liquidificador");
        categoriaEntity.setTipo(null);

        try {
            categoriaService.cadastrarCategoria(categoriaEntity);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Tipo inválido.", e.getMessage());
        }

    }

    @Test
    public void cadastrarCategoria() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(1L);
        categoriaEntity.setNome("Bolo");
        categoriaEntity.setDescricao("Bolo de cenoura");
        categoriaEntity.setTipo(TipoCategoria.COMIDA);

        categoriaService.cadastrarCategoria(categoriaEntity);

        verify(categoriaRepository).save(categoriaEntity);
    }

    @Test
    public void buscarCategorias() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNome("Suco");
        categoriaEntity.setDescricao("Suco de frutas vermelhas batidas no liquidificador");
        categoriaEntity.setTipo(TipoCategoria.BEBIDA);

        CategoriaEntity categoriaEntity1 = new CategoriaEntity();
        categoriaEntity1.setNome("Torta");
        categoriaEntity1.setDescricao("Torta de chocolate");
        categoriaEntity1.setTipo(TipoCategoria.COMIDA);

        when(categoriaRepository.findAll()).thenReturn(List.of(categoriaEntity, categoriaEntity1));

        List<CategoriaEntity> categoriaEntityRetornoList = categoriaService.buscarCategorias();

        Assertions.assertEquals(2, categoriaEntityRetornoList.size());
    }

    @Test
    public void deletarCategoriaPeloId() {
        categoriaService.deletarCategoriaPeloId(1L);
        verify(categoriaRepository).deleteById(1L);
    }

    @Test
    public  void deletarCategoriaQuandoIdForNull() {
        try {
            categoriaService.deletarCategoriaPeloId(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Id null", e.getMessage());
        }
    }
}
