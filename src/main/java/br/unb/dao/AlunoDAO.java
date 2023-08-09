package br.unb.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.unb.dominio.Aluno;

public class AlunoDAO {
	private static final String URL = "jdbc:h2:tcp://localhost/~/test";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	public AlunoDAO() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void salvar(Aluno aluno) throws SQLException {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(aluno);
		tx.commit();
		session.close();
		
	}

	public void atualizar(Aluno aluno) throws SQLException {
		System.out.println("AlunoDAO::atualizar::aluno->"+aluno);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.update(aluno);

		tx.commit();
		session.close();
	}

	public void excluir(Long id) throws SQLException {
		System.out.println("AlunoDAO::excluir::aluno->"+id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Aluno aluno = (Aluno) session.get(Aluno.class, id);
		session.delete(aluno);

		tx.commit();
		session.close();
	}

	public Aluno buscarPorId(Long id) throws SQLException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Aluno aluno = (Aluno) session.get(Aluno.class, id);

		session.close();
		return aluno;
	}

	public List<Aluno> listarTodos() throws SQLException, ClassNotFoundException {
		System.out.println("AlunoDAO::listarTodos");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Aluno");
		List<Aluno> alunos = query.list();
		session.close();
		System.out.println("AlunoDAO::listarTodos::alunos->"+alunos);
		return alunos;
	}
}
