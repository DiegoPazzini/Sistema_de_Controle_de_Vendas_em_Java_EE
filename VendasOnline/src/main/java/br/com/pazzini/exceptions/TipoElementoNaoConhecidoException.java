/**
 * A classe TipoElementoNaoConhecidoException é uma exceção específica para indicar que um tipo de elemento não é reconhecido ou conhecido.
 * 
 * Atributos:
 * - serialVersionUID: Identificador único para fins de serialização da classe.
 * 
 * Construtores:
 * - TipoElementoNaoConhecidoException(String msg): Construtor que permite definir uma mensagem para a exceção.
 * - TipoElementoNaoConhecidoException(String msg, Throwable e): Construtor que permite definir uma mensagem e uma causa para a exceção.
 * 
 * Anotações:
 * - Nenhuma anotação específica é usada nesta classe.
 */
package br.com.pazzini.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {
	
	// Identificador único para fins de serialização da classe.
	private static final long serialVersionUID = -2268140970978666251L;

	// Construtor que permite definir uma mensagem para a exceção.
	public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    // Construtor que permite definir uma mensagem e uma causa para a exceção.
    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }

}
