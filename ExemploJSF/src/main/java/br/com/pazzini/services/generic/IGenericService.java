/**
 * Interface genérica que define operações padrão para serviços de entidades persistentes.
 * 
 * @param <T> Tipo da entidade a ser manipulada.
 * @param <E> Tipo da chave primária da entidade.
 * 
 * @see IGenericService
 * @see Persistente
 * @see Serializable
 * @see DAOException
 * @see MaisDeUmRegistroException
 * @see TableException
 * @see TipoChaveNaoEncontradaException
 * @see Collection
 * @see br.com.pazzini.services.generic
 * @author diego.pazzini
 */
package br.com.pazzini.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.pazzini.domain.Persistente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.MaisDeUmRegistroException;
import br.com.pazzini.exceptions.TableException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente, E extends Serializable> {

    /**
     * Método para cadastrar novos registros no banco de dados.
     *
     * @param entity Entidade a ser cadastrada.
     * @return Entidade salva.
     * @throws TipoChaveNaoEncontradaException Se o tipo da chave primária não for encontrado.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados.
     *
     * @param entity Entidade a ser excluída.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void excluir(T entity) throws DAOException;

    /**
     * Método para alterar um registro no banco de dados.
     *
     * @param entity Entidade a ser atualizada.
     * @return Entidade salva.
     * @throws TipoChaveNaoEncontradaException Se o tipo da chave primária não for encontrado.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados.
     *
     * @param valor Chave única do dado a ser consultado.
     * @return Entidade consultada.
     * @throws MaisDeUmRegistroException Se mais de um registro for encontrado.
     * @throws TableException Se ocorrer um erro relacionado à tabela do banco de dados.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    /**
     * Método que retorna todos os registros do banco de dados de uma determinada entidade.
     *
     * @return Coleção de entidades encontradas.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    public Collection<T> buscarTodos() throws DAOException;
}
