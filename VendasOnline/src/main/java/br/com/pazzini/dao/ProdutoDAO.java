/**
 * Implementação da interface IProdutoDAO que estende a classe genérica GenericDAO.
 * Responsável por operações de persistência específicas para a entidade Produto.
 * 
 * Métodos implementados incluem:
 * - filtrarProdutos: realiza uma consulta filtrada por nome de produto.
 */
package br.com.pazzini.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pazzini.dao.generic.GenericDAO;
import br.com.pazzini.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    /**
     * Construtor que chama o construtor da classe pai, informando a classe da entidade Produto.
     */
    public ProdutoDAO() {
        super(Produto.class);
    }

    /**
     * Método específico para filtrar produtos por nome.
     *
     * @param query nome a ser utilizado como filtro
     * @return lista de produtos filtrada
     */
    @Override
    public List<Produto> filtrarProdutos(String query) {
        TypedQuery<Produto> tpQuery = 
                this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
    }

}
