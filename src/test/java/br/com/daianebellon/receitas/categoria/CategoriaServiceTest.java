package br.com.daianebellon.receitas.categoria;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoriaServiceTest {

    @InjectMocks
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

}
