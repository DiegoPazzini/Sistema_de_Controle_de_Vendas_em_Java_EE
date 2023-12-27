package br.com.pazzini.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.pazzini.domain.Cliente;
import br.com.pazzini.service.IClienteService;

/**
 * Classe de controle para gerenciar clientes em uma aplicação web.
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 8030245985235567808L;
	
	private Cliente cliente;  // Representa um cliente individual.
	private Collection<Cliente> clientes;  // Representa uma coleção de clientes.
	
	@Inject
	private IClienteService clienteService;  // Serviço para operações relacionadas a clientes.
	
	private Boolean isUpdate;  // Indica se uma operação de atualização está sendo realizada.
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente();  // Inicializa um novo objeto de cliente.
			this.clientes = clienteService.buscarTodos();  // Recupera todos os clientes.
		} catch (Exception e) {
			// Manipula a exceção adicionando uma mensagem de erro ao FacesContext.
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente();  // Reseta o objeto de cliente ao cancelar.
		} catch (Exception e) {
			// Manipula a exceção adicionando uma mensagem de erro ao FacesContext.
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
    } 
	
	public void edit(Cliente cliente) {
		try {
			this.isUpdate = true;
			this.cliente = cliente;  // Define o cliente para edição.
		} catch (Exception e) {
			// Manipula a exceção adicionando uma mensagem de erro ao FacesContext.
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
    } 
	
	public void delete(Cliente cliente) {
		try {
			clienteService.excluir(cliente);  // Exclui o cliente especificado.
			clientes.remove(cliente);  // Remove o cliente da coleção.
		} catch (Exception e) {
			// Manipula a exceção adicionando uma mensagem de erro ao FacesContext.
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
    } 
	
	public void add() {
		try {
			clienteService.cadastrar(cliente);  // Adiciona um novo cliente.
			this.clientes = clienteService.buscarTodos();  // Atualiza a coleção de clientes.
			this.cliente = new Cliente();  // Reseta o objeto de cliente.
		} catch (Exception e) {
			// Manipula a exceção adicionando uma mensagem de erro ao FacesContext.
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
		}
    }

    public void update() {
    	try {
			clienteService.alterar(this.cliente);  // Atualiza o cliente.
			cancel();  // Reseta o objeto de cliente e o status de atualização após a atualização bem-sucedida.
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualizado com sucesso"));
		} catch (Exception e) {
			// Manipula a exceção adicionando uma mensagem de erro ao FacesContext.
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o cliente"));
		}
    }

	public Collection<Cliente> getClientes() {
		return clientes;  // Getter para a coleção de clientes.
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;  // Setter para a coleção de clientes.
	}

	public Cliente getCliente() {
		return cliente;  // Getter para o cliente atual.
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;  // Setter para o cliente atual.
	}

	public Boolean getIsUpdate() {
		return isUpdate;  // Getter para o status de atualização.
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;  // Setter para o status de atualização.
	}
}
