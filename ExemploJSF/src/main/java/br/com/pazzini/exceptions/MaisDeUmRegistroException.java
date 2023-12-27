/**
 * Exceção personalizada para representar situações em que é esperado apenas um registro, mas mais de um é retornado.
 * 
 * @see MaisDeUmRegistroException
 * @see Exception
 * @author diego.pazzini
 */
package br.com.pazzini.exceptions;

public class MaisDeUmRegistroException extends Exception {

    private static final long serialVersionUID = -7509649433607067138L;

    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param msg Mensagem de erro.
     */
    public MaisDeUmRegistroException(String msg) {
        super(msg);
    }
}
