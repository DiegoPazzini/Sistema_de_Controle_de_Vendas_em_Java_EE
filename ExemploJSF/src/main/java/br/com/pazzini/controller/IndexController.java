/**
 * Controlador da página inicial da aplicação.
 * Este controlador redireciona para a página de listagem de clientes.
 */
package br.com.pazzini.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Classe responsável pelo controle da página inicial da aplicação.
 * Esta classe é anotada como @Named para ser reconhecida pelo CDI (Contexts and Dependency Injection),
 * permitindo a injeção de dependências, e como @ViewScoped para definir o escopo da instância como o ciclo de vida
 * da visualização JSF.
 * O método goToClientPage() redireciona para a página de listagem de clientes.
 *
 * @author diego.pazzini
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    private static final long serialVersionUID = -3176307559028924604L;

    /**
     * Redireciona para a página de listagem de clientes.
     *
     * @return Caminho da página de listagem de clientes.
     */
    public String goToClientPage() {
        return "/cliente/list.xhtml";
    }
}
