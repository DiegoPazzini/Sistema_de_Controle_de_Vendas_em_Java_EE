/**
 * Controlador da página inicial da aplicação.
 * Este controlador possui métodos para redirecionar para as páginas de listagem de clientes, produtos e vendas.
 * A classe é anotada como @Named para ser reconhecida pelo CDI (Contexts and Dependency Injection),
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

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexController implements Serializable {

    private static final long serialVersionUID = -784519597996507487L;

    /**
     * Redireciona para a página de listagem de clientes.
     *
     * @return Caminho da página de listagem de clientes.
     */
    public String redirectCliente() {
        return "/cliente/list.xhtml";
    }

    /**
     * Redireciona para a página de listagem de produtos.
     *
     * @return Caminho da página de listagem de produtos.
     */
    public String redirectProduto() {
        return "/produto/list.xhtml";
    }

    /**
     * Redireciona para a página de listagem de vendas.
     *
     * @return Caminho da página de listagem de vendas.
     */
    public String redirectVenda() {
        return "/venda/list.xhtml";
    }
}
