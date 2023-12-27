/**
 * Controlador da entidade Produto responsável por gerenciar as interações entre a camada de visão e a camada de serviço
 * para operações relacionadas aos produtos.
 * Esta classe é anotada como @Named para ser reconhecida pelo CDI (Contexts and Dependency Injection),
 * permitindo a injeção de dependências, e como @ViewScoped para definir o escopo da instância como o ciclo de vida
 * da visualização JSF.
 *
 * @see Named
 * @see ViewScoped
 * @see Serializable
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

import br.com.pazzini.domain.Produto;
import br.com.pazzini.service.IProdutoService;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

    private static final long serialVersionUID = 367088063926303823L;

    private Produto produto;
    private Collection<Produto> produtos;

    @Inject
    private IProdutoService produtoService;

    private Boolean isUpdate;

    /**
     * Inicializa o controlador, populando a lista de produtos e configurando o estado inicial.
     */
    @PostConstruct
    public void init() {
        try {
            this.isUpdate = false;
            this.produto = new Produto();
            this.produtos = produtoService.buscarTodos();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os produtos"));
        }
    }

    /**
     * Cancela a ação em andamento, resetando o estado do produto.
     */
    public void cancel() {
        try {
            this.isUpdate = false;
            this.produto = new Produto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
        }
    }

    /**
     * Edita as informações de um produto existente.
     *
     * @param produto Produto a ser editado.
     */
    public void edit(Produto produto) {
        try {
            this.isUpdate = true;
            this.produto = produto;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar o produto"));
        }
    }

    /**
     * Exclui um produto existente.
     *
     * @param produto Produto a ser excluído.
     */
    public void delete(Produto produto) {
        try {
            produtoService.excluir(produto);
            produtos.remove(produto);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
        }
    }

    /**
     * Adiciona um novo produto.
     */
    public void add() {
        try {
            produtoService.cadastrar(produto);
            this.produtos = produtoService.buscarTodos();
            this.produto = new Produto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o produto"));
        }
    }

    /**
     * Atualiza as informações de um produto existente.
     */
    public void update() {
        try {
            produtoService.alterar(this.produto);
            cancel();
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Produto Atualizado com sucesso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o produto"));
        }
    }

    /**
     * Retorna o caminho para a tela inicial.
     *
     * @return Caminho da página inicial.
     */
    public String voltarTelaInicial() {
        return "/index.xhtml";
    }

    // Getters e Setters omitidos para brevidade.
}
