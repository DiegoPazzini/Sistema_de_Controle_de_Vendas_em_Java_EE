/**
 * Interface que define os métodos específicos para operações de persistência da entidade Venda.
 * Estende a interface genérica IGenericDAO, parametrizando com a entidade Venda e o tipo da chave primária Long.
 * 
 * Os métodos específicos incluem:
 * - finalizarVenda: utilizado para finalizar uma venda, realizando as operações necessárias.
 * - cancelarVenda: utilizado para cancelar uma venda, realizando as operações necessárias.
 * - consultarComCollection: utilizado para evitar a exception LazyInitializationException,
 *   buscando todos os dados de objetos que tenham coleções lazy.
 */
package br.com.pazzini.dao;

import br.com.pazzini.dao.generic.IGenericDAO;
import br.com.pazzini.domain.Venda;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

    /**
     * Método específico para finalizar uma venda.
     *
     * @param venda a ser finalizada
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método específico para cancelar uma venda.
     *
     * @param venda a ser cancelada
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método utilizado para evitar a exceção LazyInitializationException.
     * Busca todos os dados de objetos que tenham coleções lazy.
     * 
     * OBS: Não é uma boa prática utilizar FetchType.EAGER, pois ele sempre traz todos os objetos da coleção,
     * mesmo sem precisar utilizá-los.
     *
     * @param id identificador da venda
     * @return venda com coleções inicializadas
     */
    Venda consultarComCollection(Long id);

}
