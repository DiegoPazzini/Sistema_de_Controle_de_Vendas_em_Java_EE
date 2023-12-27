/**
 * Classe de implementação do acesso a dados (DAO) para a entidade Cliente.
 * Estende a classe genérica GenericDAO para herdar métodos padrão de CRUD (Create, Read, Update, and Delete).
 * Implementa a interface IClienteDAO.
 * 
 * @see GenericDAO
 * @see IClienteDAO
 * @author diego.pazzini
 */
package br.com.pazzini.dao;

import br.com.pazzini.dao.generic.GenericDAO;
import br.com.pazzini.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    /**
     * Construtor padrão que chama o construtor da classe pai (GenericDAO) passando a classe da entidade Cliente.
     */
    public ClienteDAO() {
        super(Cliente.class);
    }
}
