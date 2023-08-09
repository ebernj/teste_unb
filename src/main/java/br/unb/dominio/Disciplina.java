package br.unb.dominio;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //gerado pelo banco
	
	@Column(name = "nome")
	private String nome; // nome da disciplina
	
	@Column(name = "curso")
	private String curso; // nome do curso: civil, medicina, direito
	
	@Column(name = "turma")
	private String turma; // 20231
	
	@Column(name = "local")
	private String local; // Bloco sala
	
	@ManyToMany(mappedBy = "disciplinas")
    private List<Aluno> alunos;
	
	@ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long disciplinaId) {
		this.id = disciplinaId;
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
	
	public Disciplina() {}
	
	public Disciplina(String nome, String curso, String turma, String local) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.turma = turma;
		this.local = local;
	}
	public Disciplina(Long id, String nome, String curso, String turma, String local) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.turma = turma;
		this.local = local;
	}

}
