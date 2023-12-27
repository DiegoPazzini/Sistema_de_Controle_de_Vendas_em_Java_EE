/**
 * Interface que define operações específicas para a entidade Cliente em um serviço.
 * Estende a interface genérica IGenericService para herdar operações padrão de CRUD (Create, Read, Update, and Delete).
 * 
 * @see IGenericService
 * @see Cliente
 * @see DAOException
 * @see IClienteService
 * @author diego.pazzini
 */
package br.com.pazzini.service;

import br.com.pazzini.domain.Cliente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    /**
     * Busca um cliente pelo CPF.
     *
     * @param cpf CPF do cliente a ser buscado.
     * @return Cliente encontrado ou null se não encontrado.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    Cliente buscarPorCPF(Long cpf) throws DAOException;
}
