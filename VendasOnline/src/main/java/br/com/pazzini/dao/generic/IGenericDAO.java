/**
 * Interface genérica para métodos de CRUD (Create, Read, Update, and Delete).
 * Define os métodos básicos para operações de persistência em um banco de dados.
 * 
 * Os parâmetros genéricos são:
 * - T: tipo da entidade persistente
 * - E: tipo da chave primária da entidade
 * 
 * Os métodos definidos são:
 * - cadastrar: para persistir um novo registro no banco de dados.
 * - excluir: para remover um registro do banco de dados.
 * - alterar: para atualizar um registro no banco de dados.
 * - consultar: para buscar um registro com base na chave primária.
 * - buscarTodos: para recuperar todos os registros da entidade.
 * 
 * As exceções lançadas incluem:
 * - TipoChaveNaoEncontradaException: quando o tipo da chave não é encontrado.
 * - DAOException: para exceções genéricas de operações no banco de dados.
 * - MaisDeUmRegistroException: quando mais de um registro é retornado na consulta por uma chave única.
 * - TableException: para exceções relacionadas à tabela no banco de dados.
 */
package br.com.pazzini.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.pazzini.domain.Persistente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.MaisDeUmRegistroException;
import br.com.pazzini.exceptions.TableException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericDAO<T extends Persistente, E extends Serializable> {

    /**
     * Método para cadastrar novos registros no banco de dados.
     *
     * @param entity a ser cadastrada
     * @return retorna o objeto salvo
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados.
     *
     * @param entity a ser excluída
     * @throws DAOException
     */
    public void excluir(T entity) throws DAOException;

    /**
     * Método para alterar um registro no banco de dados.
     *
     * @param entity a ser atualizada
     * @return retorna o objeto salvo
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados.
     *
     * @param id chave única do registro a ser consultado
     * @return registro encontrado
     * @throws MaisDeUmRegistroException
     * @throws TableException
     * @throws DAOException
     */
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;

    /**
     * Método que retorna todos os registros do banco de dados da entidade.
     *
     * @return registros encontrados
     * @throws DAOException
     */
    public Collection<T> buscarTodos() throws DAOException;
}
