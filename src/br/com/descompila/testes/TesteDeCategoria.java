package br.com.descompila.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.descompila.Categoria;
import br.com.descompila.connection.ConnectionFactory;
import br.com.descompila.dao.CategoriaDAO;

public class TesteDeCategoria {
	public static void main(String[] args) {

		CategoriaDAO dao = new CategoriaDAO();
		Categoria c = new Categoria();
		c.setDescricao("Agua");
		dao.findById(2);
		//dao.save(c);
	}
}
