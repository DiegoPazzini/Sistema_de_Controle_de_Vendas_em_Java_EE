/**
 * A classe VendaService é uma implementação específica de serviço para a entidade Venda.
 * Estende a classe GenericService, que fornece implementações genéricas de serviços.
 * Anotada como Stateless para indicar que é uma EJB (Enterprise JavaBeans) sem estado.
 * 
 * Construtor:
 * - VendaService(IVendaDAO dao): Construtor que recebe uma instância de IVendaDAO via injeção de dependência.
 * 
 * Métodos:
 * - finalizarVenda(Venda venda): Implementação do contrato da interface IVendaService para finalizar uma venda, alterando seu status para CONCLUIDA.
 * - cancelarVenda(Venda venda): Implementação do contrato da interface IVendaService para cancelar uma venda, alterando seu status para CANCELADA.
 * - consultarComCollection(Long id): Implementação do contrato da interface IVendaService para consultar uma venda incluindo a coleção de produtos.
 * - cadastrar(Venda entity): Implementação do método de cadastro específico para Venda, configurando o status como INICIADA antes de salvar.
 */
package br.com.pazzini.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.pazzini.dao.IVendaDAO;
import br.com.pazzini.domain.Venda;
import br.com.pazzini.domain.Venda.Status;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;
import br.com.pazzini.services.generic.GenericService;

@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

    private IVendaDAO dao;

    @Inject
    public VendaService(IVendaDAO dao) {
        super(dao);
        this.dao = dao;
    }

    /**
     * Implementação do contrato da interface IVendaService para finalizar uma venda, alterando seu status para CONCLUIDA.
     * 
     * @param venda Venda a ser finalizada.
     * @throws TipoChaveNaoEncontradaException Se ocorrer um erro relacionado ao tipo da chave primária.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Status.CONCLUIDA);
        dao.finalizarVenda(venda);
    }

    /**
     * Implementação do contrato da interface IVendaService para cancelar uma venda, alterando seu status para CANCELADA.
     * 
     * @param venda Venda a ser cancelada.
     * @throws TipoChaveNaoEncontradaException Se ocorrer um erro relacionado ao tipo da chave primária.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Status.CANCELADA);
        dao.cancelarVenda(venda);
    }

    /**
     * Implementação do contrato da interface IVendaService para consultar uma venda incluindo a coleção de produtos.
     * 
     * @param id Identificador único da venda.
     * @return Venda consultada.
     */
    @Override
    public Venda consultarComCollection(Long id) {
        return dao.consultarComCollection(id);
    }

    /**
     * Implementação do método de cadastro específico para Venda, configurando o status como INICIADA antes de salvar.
     * 
     * @param entity Venda a ser cadastrada.
     * @return Venda cadastrada.
     * @throws TipoChaveNaoEncontradaException Se ocorrer um erro relacionado ao tipo da chave primária.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        entity.setStatus(Status.INICIADA);
        return super.cadastrar(entity);
    }
}
