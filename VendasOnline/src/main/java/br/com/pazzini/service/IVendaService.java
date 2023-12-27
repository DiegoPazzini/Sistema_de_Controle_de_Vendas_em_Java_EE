/**
 * A interface IVendaService define os contratos de serviço específicos para a entidade Venda.
 * Estende a interface IGenericDAO, que fornece operações genéricas de CRUD (Create, Read, Update, Delete).
 * 
 * Métodos:
 * - finalizarVenda(Venda venda): Método para finalizar uma venda.
 * - cancelarVenda(Venda venda): Método para cancelar uma venda.
 * - consultarComCollection(Long id): Método que busca uma venda pelo ID, evitando a exceção LazyInitializationException
 *   carregando todos os dados de objetos que possuem coleções de forma antecipada.
 */
package br.com.pazzini.service;

import br.com.pazzini.dao.generic.IGenericDAO;
import br.com.pazzini.domain.Venda;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaService extends IGenericDAO<Venda, Long> {

    /**
     * Método para finalizar uma venda.
     * 
     * @param venda Venda a ser finalizada.
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para cancelar uma venda.
     * 
     * @param venda Venda a ser cancelada.
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método que busca uma venda pelo ID, evitando a exceção LazyInitializationException
     * carregando todos os dados de objetos que possuem coleções de forma antecipada.
     * 
     * @param id ID da venda a ser consultada.
     * @return Venda com os dados carregados.
     */
    Venda consultarComCollection(Long id);

}
