package br.unb.struts;

import org.apache.struts.action.ActionForm;

import br.unb.dominio.Professor;

public class DisciplinaForm extends ActionForm {
	
	private Long id;
	private String nome;
	private String curso;
	private String turma;
	private String local;
	
	private Long professorSelecionado;
	
	public Long getProfessorSelecionado() {
		return professorSelecionado;
	}
	public void setProfessorSelecionado(Long professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}
	
	public Professor getProfessorselecionadoById() {
		Professor p = new Professor();
		p.setId(professorSelecionado);
		return p;
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}


}
