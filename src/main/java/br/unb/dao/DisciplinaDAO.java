package br.unb.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import br.unb.dominio.Disciplina;

public class DisciplinaDAO {

	private static final String URL = "jdbc:h2:tcp://localhost/~/test";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	public DisciplinaDAO() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void salvar(Disciplina disciplina) throws SQLException {
		System.out.println("DisciplinaDAO::salvar::disciplina->"+disciplina);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(disciplina);
		tx.commit();
		session.close();
		
	}

	public void atualizar(Disciplina disciplina) throws SQLException {
		System.out.println("DisciplinaDAO::atualizar::disciplina->"+disciplina);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.update(disciplina);

		tx.commit();
		session.close();
	}

	public void excluir(int id) throws SQLException {
		System.out.println("DisciplinaDAO::excluir::disciplina->"+id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Disciplina disciplina = (Disciplina) session.get(Disciplina.class, id);
		session.delete(disciplina);

		tx.commit();
		session.close();
	}

	public Disciplina buscarPorId(int id) throws SQLException {
		System.out.println("DisciplinaDAO::buscarPorId::disciplina->"+id);
		Session session = HibernateUtil.getSessionFactory().openSession();

		Disciplina disciplina = (Disciplina) session.get(Disciplina.class, id);

		session.close();
		return disciplina;
	}

	public List<Disciplina> listarTodos() throws SQLException, ClassNotFoundException {
		System.out.println("DisciplinaDAO::listarTodos");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Disciplina");
		List<Disciplina> disciplinas = query.list();
		session.close();
		System.out.println("DisciplinaDAO::listarTodos::disciplinas->"+disciplinas);
			return disciplinas;
		}
}
