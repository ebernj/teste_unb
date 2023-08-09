package br.unb.struts;

import java.util.List;

import org.apache.struts.action.ActionForm;

import br.unb.dominio.Disciplina;

public class ProfessorForm extends ActionForm {
	private Long id;
	private String nome;
	private List<Disciplina> disciplinas;

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		this.id = long1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
