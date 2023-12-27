/**
 * Classe responsável por operações de persistência específicas para a entidade Cliente.
 * Estende a classe genérica GenericDAO e implementa a interface IClienteDAO.
 * 
 * Os métodos específicos incluem:
 * - filtrarClientes: realiza uma consulta filtrada por nome de cliente.
 * 
 * A classe é parametrizada com a entidade Cliente e o tipo da chave primária Long.
 */
package br.com.pazzini.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pazzini.dao.generic.GenericDAO;
import br.com.pazzini.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    /**
     * Construtor padrão que chama o construtor da classe pai (GenericDAO) passando a classe da entidade Cliente.
     */
    public ClienteDAO() {
        super(Cliente.class);
    }

    /**
     * Método específico para filtrar clientes com base no nome.
     *
     * @param query string de consulta para filtrar clientes por nome
     * @return lista de clientes filtrados
     */
    @Override
    public List<Cliente> filtrarClientes(String query) {
        TypedQuery<Cliente> typedQuery =
                this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
        typedQuery.setParameter("nome", "%" + query + "%");
        return typedQuery.getResultList();
    }
}
