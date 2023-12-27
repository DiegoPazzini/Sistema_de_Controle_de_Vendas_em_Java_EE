/**
 * A interface IProdutoService define os contratos de serviço específicos para a entidade Produto.
 * Estende a interface IGenericService, que fornece operações genéricas de CRUD (Create, Read, Update, Delete).
 * 
 * Métodos:
 * - filtrarProdutos(String query): Método que realiza a filtragem de produtos com base em uma consulta.
 */
package br.com.pazzini.service;

import java.util.List;

import br.com.pazzini.domain.Produto;
import br.com.pazzini.services.generic.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

    /**
     * Método que realiza a filtragem de produtos com base em uma consulta.
     * 
     * @param query Consulta a ser utilizada para filtrar os produtos.
     * @return Lista de produtos que correspondem à consulta.
     */
    List<Produto> filtrarProdutos(String query);

}
