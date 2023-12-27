/**
 * Classe abstrata que fornece implementações padrão para operações de serviço genéricas.
 * Implementa a interface IGenericService para fornecer métodos de CRUD (Create, Read, Update, and Delete) genéricos.
 * 
 * @see IGenericService
 * @see GenericService
 * @see Persistente
 * @see IGenericDAO
 * @see DAOException
 * @see MaisDeUmRegistroException
 * @see TableException
 * @see TipoChaveNaoEncontradaException
 * @param <T> Tipo da entidade a ser manipulada.
 * @param <E> Tipo da chave primária da entidade.
 * @author diego.pazzini
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

public abstract class GenericService<T extends Persistente, E extends Serializable> 
    implements IGenericService<T, E> {
    
    /**
     * Instância de IGenericDAO injetada para manipulação de dados no banco.
     */
    protected IGenericDAO<T, E> dao;

    /**
     * Construtor que recebe uma instância de IGenericDAO e a atribui ao atributo dao.
     *
     * @param dao Instância de IGenericDAO injetada.
     */
    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    /**
     * Cadastra uma nova entidade no banco de dados.
     *
     * @param entity Entidade a ser cadastrada.
     * @return Entidade cadastrada.
     * @throws TipoChaveNaoEncontradaException Se o tipo da chave primária não for encontrado.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    /**
     * Exclui uma entidade do banco de dados.
     *
     * @param entity Entidade a ser excluída.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    /**
     * Altera uma entidade no banco de dados.
     *
     * @param entity Entidade a ser alterada.
     * @return Entidade alterada.
     * @throws TipoChaveNaoEncontradaException Se o tipo da chave primária não for encontrado.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    /**
     * Consulta uma entidade no banco de dados pelo valor da chave primária.
     *
     * @param valor Valor da chave primária da entidade a ser consultada.
     * @return Entidade consultada.
     * @throws MaisDeUmRegistroException Se mais de um registro for encontrado.
     * @throws TableException Se ocorrer um erro relacionado à tabela do banco de dados.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(valor);
    }

    /**
     * Busca todas as entidades do tipo T no banco de dados.
     *
     * @return Coleção de entidades encontradas.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }
}
