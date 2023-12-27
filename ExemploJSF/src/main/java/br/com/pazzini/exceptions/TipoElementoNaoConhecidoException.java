/**
 * Exceção personalizada para representar situações em que um tipo de elemento não é reconhecido.
 * 
 * @see TipoElementoNaoConhecidoException
 * @see Exception
 * @author diego.pazzini
 */
package br.com.pazzini.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

    private static final long serialVersionUID = -2268140970978666251L;

    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param msg Mensagem de erro.
     */
    public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    /**
     * Construtor que recebe uma mensagem de erro e uma exceção relacionada.
     *
     * @param msg Mensagem de erro.
     * @param e Exceção relacionada.
     */
    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }
}
