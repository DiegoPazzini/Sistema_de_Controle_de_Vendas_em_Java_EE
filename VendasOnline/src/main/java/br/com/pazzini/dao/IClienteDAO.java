/**
 * Interface que define os métodos específicos para operações de persistência da entidade Cliente.
 * Estende a interface genérica IGenericDAO, parametrizando com a entidade Cliente e o tipo da chave primária Long.
 * 
 * Os métodos específicos incluem:
 * - filtrarClientes: utilizado para filtrar clientes por nome.
 */
package br.com.pazzini.dao;

import java.util.List;

import br.com.pazzini.dao.generic.IGenericDAO;
import br.com.pazzini.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

    /**
     * Método específico para filtrar clientes com base no nome.
     *
     * @param query string de consulta para filtrar clientes por nome
     * @return lista de clientes filtrados
     */
    List<Cliente> filtrarClientes(String query);

}
