/**
 * A interface IClienteService define os contratos de serviço específicos para a entidade Cliente.
 * Estende a interface IGenericService, que fornece operações genéricas de CRUD (Create, Read, Update, Delete).
 * 
 * Métodos:
 * - buscarPorCPF(Long cpf): Método que busca um cliente pelo número do CPF.
 * - filtrarClientes(String query): Método que realiza a filtragem de clientes com base em uma consulta.
 */
package br.com.pazzini.service;

import java.util.List;

import br.com.pazzini.domain.Cliente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    /**
     * Método que busca um cliente pelo número do CPF.
     * 
     * @param cpf Número do CPF do cliente a ser buscado.
     * @return Objeto Cliente correspondente ao CPF fornecido.
     * @throws DAOException Exceção lançada em caso de erro na camada de acesso a dados.
     */
    Cliente buscarPorCPF(Long cpf) throws DAOException;

    /**
     * Método que realiza a filtragem de clientes com base em uma consulta.
     * 
     * @param query Consulta a ser utilizada para filtrar os clientes.
     * @return Lista de clientes que correspondem à consulta.
     */
    List<Cliente> filtrarClientes(String query);

}
