package br.com.daianebellon.receitas.receita;

import javax.persistence.*;

@Entity
@Table(name="receita")
public class ReceitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String modoPreparo;

    @Override
    public String toString() {
        return "ReceitaEntity{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", modoPreparo='" + modoPreparo + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }
}

