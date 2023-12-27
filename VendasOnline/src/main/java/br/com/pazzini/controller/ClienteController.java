	/**
 * Controlador responsável pela lógica de negócios da página de clientes.
 * Esta classe é anotada como @Named para ser reconhecida pelo CDI (Contexts and Dependency Injection),
 * permitindo a injeção de dependências, e como @ViewScoped para definir o escopo da instância como o ciclo de vida
 * da visualização JSF.
 * Utiliza o serviço IClienteService para interagir com a camada de serviço.
 * Os métodos desta classe realizam operações como adicionar, editar, excluir e listar clientes.
 * Adicionalmente, faz uso da classe ReplaceUtils para remover caracteres inválidos dos campos de CPF e telefone.
 *
 * @see Named
 * @see ViewScoped
 * @see Serializable
 * @see Cliente
 * @see Collection
 * @see IClienteService
 * @see FacesContext
 * @see FacesMessage
 * @see PostConstruct
 * @see ReplaceUtils
 * @see Inject
 * @author diego.pazzini
 */
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
import br.com.pazzini.utils.ReplaceUtils;

@Named
@ViewScoped
public class ClienteController implements Serializable {

    private static final long serialVersionUID = 8030245985235567808L;

    private Cliente cliente;

    private Collection<Cliente> clientes;

    @Inject
    private IClienteService clienteService;

    private Boolean isUpdate;

    private String cpfMask;

    private String telMask;

    /**
     * Inicializa o controlador, atribuindo valores iniciais e carregando a lista de clientes.
     * Em caso de erro, exibe uma mensagem de erro utilizando o FacesContext.
     */
    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.cliente = new Cliente();
            this.clientes = clienteService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));
        }
    }

    /**
     * Cancela a operação em andamento, resetando o estado do controlador.
     * Em caso de erro, exibe uma mensagem de erro utilizando o FacesContext.
     */
    public void cancel() {
        try {
            this.isUpdate = false;
            this.cliente = new Cliente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }
    }

    /**
     * Inicia o modo de edição para o cliente fornecido.
     * Em caso de erro, exibe uma mensagem de erro utilizando o FacesContext.
     *
     * @param cliente Cliente a ser editado.
     */
    public void edit(Cliente cliente) {
        try {
            this.isUpdate = true;
            this.cliente = cliente;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }
    }

    /**
     * Exclui o cliente fornecido.
     * Em caso de erro, exibe uma mensagem de erro utilizando o FacesContext.
     *
     * @param cliente Cliente a ser excluído.
     */
    public void delete(Cliente cliente) {
        try {
            clienteService.excluir(cliente);
            clientes.remove(cliente);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
        }
    }

    /**
     * Adiciona um novo cliente, limpando os campos e atualizando a lista de clientes.
     * Em caso de erro, exibe uma mensagem de erro utilizando o FacesContext.
     */
    public void add() {
        try {
            removerCaracteresInvalidos();
            limparCampos();
            clienteService.cadastrar(cliente);
            this.clientes = clienteService.buscarTodos();
            this.cliente = new Cliente();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
        }
    }

    /**
     * Atualiza o cliente em edição, cancela o modo de edição e exibe uma mensagem de sucesso.
     * Em caso de erro, exibe uma mensagem de erro utilizando o FacesContext.
     */
    public void update() {
        try {
            removerCaracteresInvalidos();
            clienteService.alterar(this.cliente);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualizado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o cliente"));
        }
    }

    /**
     * Retorna à tela inicial da aplicação.
     *
     * @return Caminho da página inicial.
     */
    public String voltarTelaInicial() {
        return "/index.xhtml";
    }

    // Getters e Setters omitidos para brevidade

    /**
     * Remove caracteres inválidos dos campos de CPF e telefone.
     */
    private void removerCaracteresInvalidos() {
        Long cpf = Long.valueOf(ReplaceUtils.replace(getCpfMask(), ".", "-"));
        this.cliente.setCpf(cpf);

        Long tel = Long.valueOf(ReplaceUtils.replace(getTelMask(), "(", ")", " ", "-"));
        this.cliente.setTel(tel);
    }

    /**
     * Limpa os campos de máscaras após a operação.
     */
    private void limparCampos() {
        setCpfMask(null);
        setTelMask(null);
    }

    // Getters e Setters omitidos para brevidade
}
