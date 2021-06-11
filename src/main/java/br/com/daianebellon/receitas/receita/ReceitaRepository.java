package br.com.daianebellon.receitas.receita;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<ReceitaEntity, Long> { //vem com metodos padrão (save, findAll)


}
