/**
 * Exceção personalizada para representar situações em que o tipo da chave primária não é encontrado.
 * 
 * @see TipoChaveNaoEncontradaException
 * @see Exception
 * @author diego.pazzini
 */
package br.com.pazzini.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = -1389494676398525746L;

    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param msg Mensagem de erro.
     */
    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    /**
     * Construtor que recebe uma mensagem de erro e uma exceção relacionada.
     *
     * @param msg Mensagem de erro.
     * @param e Exceção relacionada.
     */
    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
