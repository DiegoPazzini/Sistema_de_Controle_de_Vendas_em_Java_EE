/**
 * A classe TipoChaveNaoEncontradaException é uma exceção específica para indicar que um tipo de chave não foi encontrado, geralmente utilizado em operações de CRUD.
 * 
 * Atributos:
 * - serialVersionUID: Identificador único para fins de serialização da classe.
 * 
 * Construtores:
 * - TipoChaveNaoEncontradaException(String msg): Construtor que permite definir uma mensagem para a exceção.
 * - TipoChaveNaoEncontradaException(String msg, Throwable e): Construtor que permite definir uma mensagem e uma causa para a exceção.
 * 
 * Anotações:
 * - Nenhuma anotação específica é usada nesta classe.
 */
package br.com.pazzini.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

    // Identificador único para fins de serialização da classe.
	private static final long serialVersionUID = -1389494676398525746L;

    // Construtor que permite definir uma mensagem para a exceção.
	public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    // Construtor que permite definir uma mensagem e uma causa para a exceção.
    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
