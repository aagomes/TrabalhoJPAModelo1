/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alexandre
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao;
    @NotNull(message = "A carga Horaria não pode ser nula!")
    @Min(value = 0, message = "A carga Horaria não pode ser negativa!")
    @Column(name = "cargaHoraria", columnDefinition = "numeric(12,2)", nullable = false)
    private Double cargaHoraria;
    @Column(name = "conhecimentoMinimo", columnDefinition = "text", nullable = false)
    private String conhecimentoMinimo;
    @NotNull(message = "O curso não pode ser nulo!") 
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false)
    private Curso curso;
    @ManyToMany
    List<Aluno> alunoDisciplina = new ArrayList<>();
    //array de alunos
    //comentario teste
    public Disciplina() {
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentoMinimo() {
        return conhecimentoMinimo;
    }

    public void setConhecimentoMinimo(String conhecimentoMinimo) {
        this.conhecimentoMinimo = conhecimentoMinimo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
