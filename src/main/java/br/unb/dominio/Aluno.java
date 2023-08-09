package br.unb.dominio;

import java.util.List;

import javax.persistence.*;

/**
 * @author
 *
 */
@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa {
	
	@Column(name = "matricula")
	private String matricula;
	
	@ManyToMany
    @JoinTable(name = "aluno_disciplina",
               joinColumns = @JoinColumn(name = "aluno_id"),
               inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    private List<Disciplina> disciplinas;

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Aluno() {
	}

	public Aluno(String nome, String matricula) {
		setNome(nome);
		setMatricula(matricula);
	}

	public Aluno(long id, String nome, String matricula2) {
		setId(id);
		setNome(nome);
		setMatricula(matricula2);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Aluno{" + "id=" + super.getId() + ", nome='" + super.getNome() + '\'' + ", matricula='" + matricula + '\'' + '}';
	}
}
