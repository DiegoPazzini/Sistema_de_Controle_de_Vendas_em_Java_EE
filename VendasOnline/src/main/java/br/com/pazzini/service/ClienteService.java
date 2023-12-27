/**
 * A classe ClienteService é responsável por fornecer serviços relacionados à entidade Cliente.
 * 
 * Atributos:
 * - clienteDAO: Referência para a interface IClienteDAO, que é a interface do DAO associado a esta classe.
 * 
 * Construtores:
 * - ClienteService(IClienteDAO clienteDAO): Construtor que recebe uma instância de IClienteDAO e a utiliza para inicializar a classe base.
 * 
 * Métodos:
 * - buscarPorCPF(Long cpf): Método que busca um cliente pelo número do CPF.
 * - filtrarClientes(String query): Método que realiza a filtragem de clientes com base em uma consulta.
 * 
 * Anotações:
 * - @Stateless: Indica que a classe é um bean sem estado (stateless) do EJB, ou seja, não mantém estado entre chamadas do cliente.
 * - @Inject: Indica que a injeção de dependência deve ser realizada para obter uma instância de IClienteDAO.
 */
package br.com.pazzini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.pazzini.dao.IClienteDAO;
import br.com.pazzini.domain.Cliente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.MaisDeUmRegistroException;
import br.com.pazzini.exceptions.TableException;
import br.com.pazzini.services.generic.GenericService;

@Stateless
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	// Referência para a interface IClienteDAO, que é a interface do DAO associado a esta classe.
	private IClienteDAO clienteDAO;
	
	// Construtor que recebe uma instância de IClienteDAO e a utiliza para inicializar a classe base.
	@Inject
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	// Método que busca um cliente pelo número do CPF.
	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// Tratamento de exceções
			e.printStackTrace();
		}
		return null;
	}

	// Método que realiza a filtragem de clientes com base em uma consulta.
	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}
