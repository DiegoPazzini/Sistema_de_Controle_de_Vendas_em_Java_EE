/**
 * Interface que define os métodos específicos para operações de persistência da entidade Produto.
 * Estende a interface genérica IGenericDAO, parametrizando com a entidade Produto e o tipo da chave primária String.
 * 
 * Os métodos específicos incluem:
 * - filtrarProdutos: utilizado para filtrar produtos por nome.
 */
package br.com.pazzini.dao;

import java.util.List;

import br.com.pazzini.dao.generic.IGenericDAO;
import br.com.pazzini.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

    /**
     * Método específico para filtrar produtos com base no nome.
     *
     * @param query string de consulta para filtrar produtos por nome
     * @return lista de produtos filtrados
     */
    List<Produto> filtrarProdutos(String query);

}
