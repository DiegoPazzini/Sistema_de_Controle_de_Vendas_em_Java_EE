/**
 * Classe de serviço que fornece operações específicas para a entidade Cliente.
 * Estende a classe genérica GenericService para herdar operações padrão de CRUD (Create, Read, Update, and Delete).
 * Implementa a interface IClienteService.
 * 
 * @see GenericService
 * @see IClienteService
 * @see Stateless
 * @see Inject
 * @see Cliente
 * @see IClienteDAO
 * @see DAOException
 * @see MaisDeUmRegistroException
 * @see TableException
 * @see GenericService
 * @author diego.pazzini
 */
package br.com.pazzini.service;

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
    
    /**
     * Construtor que recebe uma instância de IClienteDAO e repassa para o construtor da classe pai (GenericService).
     *
     * @param clienteDAO Instância de IClienteDAO injetada.
     */
    @Inject
    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    /**
     * Busca um cliente pelo CPF.
     *
     * @param cpf CPF do cliente a ser buscado.
     * @return Cliente encontrado ou null se não encontrado.
     * @throws DAOException Se ocorrer um erro ao acessar o banco de dados.
     */
    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // Em uma aplicação real, seria adequado tratar a exceção de forma apropriada,
            // como registrar logs ou lançar uma exceção específica.
            e.printStackTrace();
        }
        return null;
    }
}
