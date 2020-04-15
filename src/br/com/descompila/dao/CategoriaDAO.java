package br.com.descompila.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.descompila.Categoria;
import br.com.descompila.connection.ConnectionFactory;

public class CategoriaDAO {

	public Categoria save(Categoria categoria) {

		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return categoria;

	}

	public Categoria update(Categoria categoria) {

		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();

			if (categoria.getId() == null) {
				em.persist(categoria);
			} else {
				em.merge(categoria);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.err.println(e);
		} finally {
			em.close();

		}
		return categoria;

	}

	public Categoria findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Categoria categoria = null;

		try {
			categoria = em.find(Categoria.class, id);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return categoria;
	}

	public List<Categoria> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Categoria> categorias = null;

		try {
			categorias = em.createQuery("from Categoria").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return categorias;
	}

	public Categoria remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Categoria categoria = em.find(Categoria.class, id);
		try {

			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return categoria;
	}

}
