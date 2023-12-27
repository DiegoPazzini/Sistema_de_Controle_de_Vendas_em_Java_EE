/**
 * A interface IGenericService define um conjunto de métodos genéricos para serviços relacionados a entidades persistentes.
 * Esses métodos incluem operações básicas como cadastrar, excluir, alterar, consultar e buscarTodos.
 * 
 * Métodos:
 * - cadastrar(T entity): Método para cadastrar novos registros no banco de dados.
 * - excluir(T entity): Método para excluir um registro do banco de dados.
 * - alterar(T entity): Método para alterar um registro no banco de dados.
 * - consultar(E valor): Método para consultar um registro no banco de dados por sua chave primária.
 * - buscarTodos(): Método para buscar todos os registros de uma determinada entidade no banco de dados.
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
     * @return Entidade cadastrada.
     * @throws TipoChaveNaoEncontradaException Se ocorrer um erro relacionado ao tipo da chave primária.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados.
     * 
     * @param entity Entidade a ser excluída.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    public void excluir(T entity) throws DAOException;

    /**
     * Método para alterar um registro no banco de dados.
     * 
     * @param entity Entidade a ser atualizada.
     * @return Entidade alterada.
     * @throws TipoChaveNaoEncontradaException Se ocorrer um erro relacionado ao tipo da chave primária.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados por sua chave primária.
     * 
     * @param valor Valor da chave primária.
     * @return Entidade consultada.
     * @throws MaisDeUmRegistroException Se mais de um registro for encontrado.
     * @throws TableException Se ocorrer um erro relacionado à tabela.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;

    /**
     * Método para buscar todos os registros de uma determinada entidade no banco de dados.
     * 
     * @return Coleção de todos os registros da entidade.
     * @throws DAOException Se ocorrer um erro no acesso aos dados.
     */
    public Collection<T> buscarTodos() throws DAOException;

}
