/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author alexandre
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "professor")
public class Professor implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_professor", sequenceName = "sequence_professor_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_professor", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "A titulacao não pode ter mais de {max} caracteres!")
    @NotNull(message = "A titulacao não pode ser nulo!") 
    @NotBlank(message = "A titulacao não pode estar em branco!")
    private String titulacao;
    @Length(max = 50, message = "Os topicos de Interesse não podem ter mais de {max} caracteres!")
    @NotNull(message = "Os topicos de Interesse não podem ser nulo!") 
    @NotBlank(message = "Os topicos de Interesse não podem estar em branco!")
    private String topicosInteresse;
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Integer especialidade;
    

    public Professor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTopicosInteresse() {
        return topicosInteresse;
    }

    public void setTopicosInteresse(String topicosInteresse) {
        this.topicosInteresse = topicosInteresse;
    }
    
    public Integer getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Integer especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.titulacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        return true;
    }       
  
}
