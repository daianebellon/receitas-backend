package br.com.daianebellon.receitas.receita;

import javax.persistence.*;

@Entity
@Table(name="receita")
public class ReceitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String modoPreparo;

    @Column(nullable = false)
    private Integer tempo;

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

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }
}

