/**
 * Interface para operações de acesso a dados (DAO) específicas da entidade Cliente.
 * Estende a interface genérica IGenericDAO, parametrizando com a entidade Cliente e o tipo Long para a chave primária.
 * 
 * @see IGenericDAO
 * @see Cliente
 * @see Long
 * @author diego.pazzini
 */
package br.com.pazzini.dao;

import br.com.pazzini.dao.generic.IGenericDAO;
import br.com.pazzini.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

}
