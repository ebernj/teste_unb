package br.unb.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.unb.dominio.Professor;

public class ProfessorDAO {
	private static final String URL = "jdbc:h2:tcp://localhost/~/test";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	public ProfessorDAO() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void salvar(Professor professor) throws SQLException {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(professor);
		tx.commit();
		session.close();
		
	}

	public void atualizar(Professor professor) throws SQLException {
		System.out.println("ProfessorDAO::atualizar::professor->"+professor);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.update(professor);

		tx.commit();
		session.close();
	}

	public void excluir(Long id) throws SQLException {
		System.out.println("ProfessorDAO::excluir::professor->"+id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Professor professor = (Professor) session.get(Professor.class, id);
		session.delete(professor);

		tx.commit();
		session.close();
	}

	public Professor buscarPorId(long id) throws SQLException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Professor professor = (Professor) session.get(Professor.class, id);
		session.close();
		return professor;
	}

	public List<Professor> listarTodos() throws SQLException, ClassNotFoundException {
		System.out.println("ProfessorDAO::listarTodos");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Professor");
		List<Professor> professores = query.list();
		session.close();
		System.out.println("ProfessorDAO::listarTodos::professors->"+professores);
		return professores;
	}
}
