/**
 * A classe GenericService é uma implementação genérica de serviço para entidades que implementam a interface Persistente.
 * Implementa a interface IGenericService, fornecendo métodos genéricos de serviço.
 * 
 * Construtor:
 * - GenericService(IGenericDAO<T, E> dao): Construtor que recebe uma instância de IGenericDAO via injeção de dependência.
 * 
 * Métodos:
 * - cadastrar(T entity): Implementação do contrato da interface IGenericService para cadastrar uma entidade.
 * - excluir(T entity): Implementação do contrato da interface IGenericService para excluir uma entidade.
 * - alterar(T entity): Implementação do contrato da interface IGenericService para alterar uma entidade.
 * - consultar(E valor): Implementação do contrato da interface IGenericService para consultar uma entidade por sua chave primária.
 * - buscarTodos(): Implementação do contrato da interface IGenericService para buscar todas as entidades do tipo T.
 */
package br.com.pazzini.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.pazzini.dao.generic.IGenericDAO;
import br.com.pazzini.domain.Persistente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.MaisDeUmRegistroException;
import br.com.pazzini.exceptions.TableException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;
import br.com.pazzini.services.generic.IGenericService;

public abstract class GenericService<T extends Persistente, E extends Serializable> 
    implements IGenericService<T, E> {
    
    protected IGenericDAO<T, E> dao;
    
    /**
     * Construtor que recebe uma instância de IGenericDAO via injeção de dependência.
     * 
     * @param dao Instância de IGenericDAO.
     */
    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }
    

    /**
     * Implementação do contrato da interface IGenericService para cadastrar uma entidade.
     * 
     * @param entity Entidade a ser cadastrada.
     * @return Entidade cadastrada.
     * @throws TipoChaveNaoEncontradaException Se ocorrer um erro relacionado ao tipo da chave primária.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    /**
     * Implementação do contrato da interface IGenericService para excluir uma entidade.
     * 
     * @param entity Entidade a ser excluída.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    /**
     * Implementação do contrato da interface IGenericService para alterar uma entidade.
     * 
     * @param entity Entidade a ser alterada.
     * @return Entidade alterada.
     * @throws TipoChaveNaoEncontradaException Se ocorrer um erro relacionado ao tipo da chave primária.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    /**
     * Implementação do contrato da interface IGenericService para consultar uma entidade por sua chave primária.
     * 
     * @param valor Valor da chave primária.
     * @return Entidade consultada.
     * @throws MaisDeUmRegistroException Se mais de um registro for encontrado.
     * @throws TableException Se ocorrer um erro relacionado à tabela.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(valor);
    }

    /**
     * Implementação do contrato da interface IGenericService para buscar todas as entidades do tipo T.
     * 
     * @return Coleção de todas as entidades do tipo T.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }
}
