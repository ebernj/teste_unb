package br.unb.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professor extends Pessoa{

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas;
    
    public Professor() {
	
	}

	public Professor(String nome) {
		setNome(nome);
	}

	public Professor(long id, String nome) {
		setId(id);
		setNome(nome);
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	@Override
	public String toString() {
		return getNome();
	}

}
