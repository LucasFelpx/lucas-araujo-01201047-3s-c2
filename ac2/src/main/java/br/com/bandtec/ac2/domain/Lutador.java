package br.com.bandtec.ac2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Lutador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 12)
    private String nome;

    @DecimalMin("0")
    @NotNull
    private Double forcaGolpe;

    private Double vida = 100.0;

    private Integer concentracoesRealizadas = 0;

    private Boolean vivo = true;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getForcaGolpe() {
        return forcaGolpe;
    }

    public void setForcaGolpe(Double forcaGolpe) {
        this.forcaGolpe = forcaGolpe;
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double vida) {
        this.vida = vida;
    }

    public Integer getConcentracoesRealizadas() {
        return concentracoesRealizadas;
    }

    public void setConcentracoesRealizadas(Integer concentracoesRealizadas) {
        this.concentracoesRealizadas = concentracoesRealizadas;
    }

    public Boolean getVivo() {
        return vivo;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }

    public Boolean concentrar(){
        if (concentracoesRealizadas == 3)
            return false;
        concentracoesRealizadas = concentracoesRealizadas + 1;
        vida = vida * 1.15;
        return true;
    }

    @Override
    public String toString() {
        return "Lutador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", forcaGolpe=" + forcaGolpe +
                ", vida=" + vida +
                ", concentracoesRealizadas=" + concentracoesRealizadas +
                ", vivo=" + vivo +
                '}';
    }
}
