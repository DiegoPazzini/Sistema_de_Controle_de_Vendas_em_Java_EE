/**
 * A classe ProdutoService é uma implementação específica de serviço para a entidade Produto.
 * Estende a classe GenericService, que fornece implementações genéricas de serviços.
 * Anotada como Stateless para indicar que é uma EJB (Enterprise JavaBeans) sem estado.
 * 
 * Construtor:
 * - ProdutoService(IProdutoDAO produtoDao): Construtor que recebe uma instância de IProdutoDAO via injeção de dependência.
 * 
 * Métodos:
 * - filtrarProdutos(String query): Implementação do contrato da interface IProdutoService para filtrar produtos com base em uma consulta.
 */
package br.com.pazzini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.pazzini.dao.IProdutoDAO;
import br.com.pazzini.domain.Produto;
import br.com.pazzini.services.generic.GenericService;

@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    private IProdutoDAO produtoDao;

    @Inject
    public ProdutoService(IProdutoDAO produtoDao) {
        super(produtoDao);
        this.produtoDao = produtoDao;
    }

    /**
     * Implementação do contrato da interface IProdutoService para filtrar produtos com base em uma consulta.
     * 
     * @param query Consulta a ser realizada nos produtos.
     * @return Lista de produtos que correspondem à consulta.
     */
    @Override
    public List<Produto> filtrarProdutos(String query) {
        return produtoDao.filtrarProdutos(query);
    }
}
