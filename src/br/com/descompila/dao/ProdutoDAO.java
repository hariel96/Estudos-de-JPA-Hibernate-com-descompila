package br.com.descompila.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.descompila.Categoria;
import br.com.descompila.Produto;
import br.com.descompila.connection.ConnectionFactory;

public class ProdutoDAO {

	public Produto save(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return produto;
	}
	
	public Produto update(Produto produto) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();
			if (produto.getId()==null) {
				em.persist(produto);
			}else {
				em.merge(produto);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return produto;
	}
	
	public Produto remove(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = em.find(Produto.class, id);
		try {

			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return produto;
	}
	
	public Produto findById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Produto produto = null;

		try {
			produto = em.find(Produto.class, id);
			System.out.println("Descricao: "+ produto.getDescricao() + " Quantidade: " + produto.getQtd() + " Valor: " + produto.getValor() + " Categoria: " + produto.getCategoria().getDescricao());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return produto;
	}
	
	public List<Produto> findAll() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Produto> produtos = null;

		try {
			produtos = em.createQuery("from Produto").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return produtos;
	}
	
}
