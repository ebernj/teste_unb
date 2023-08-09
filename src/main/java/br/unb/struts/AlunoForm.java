package br.unb.struts;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import br.unb.dominio.*;

public class AlunoForm extends ActionForm {
	private Long id;
	private String nome;
	private String matricula;
	private String method;
	
	private String[] disciplinasSelecionadas; // Array para armazenar IDs das disciplinas selecionadas

    public String[] getDisciplinasSelecionadas() {
        return disciplinasSelecionadas;
    }
    
    public void setDisciplinasSelecionadas(String[] disciplinasSelecionadas) {
        this.disciplinasSelecionadas = disciplinasSelecionadas;
    }

    
    public List<Disciplina> getDisciplinasFromIds() {
        List<Disciplina> disciplinas = new ArrayList<>();
        
        if(disciplinasSelecionadas!=null) {
        
	        for(String id : disciplinasSelecionadas) {
	
	            Long disciplinaId = Long.valueOf(id);
	
	            Disciplina disciplina = new Disciplina();
	            disciplina.setId(disciplinaId);
	
	            if (disciplina != null) {
	                disciplinas.add(disciplina);
	            }
	        }
        }
        return disciplinas;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
