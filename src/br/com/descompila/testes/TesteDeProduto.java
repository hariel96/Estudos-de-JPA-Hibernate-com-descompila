package br.com.descompila.testes;

import br.com.descompila.Categoria;
import br.com.descompila.Produto;
import br.com.descompila.dao.ProdutoDAO;

public class TesteDeProduto {
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = new Produto();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		produto.setDescricao("Refrigerante");
		produto.setQtd(100);
		produto.setValor(8.50);
		produto.setCategoria(categoria);
		//produto.setId(1);
		
		for (Produto p: dao.findAll()) {
			
			System.out.println("Descricao: " + p.getDescricao() +  " Valor: " + p.getValor() + " Categoria: " + p.getCategoria().getDescricao());
		}
		
	}
}
