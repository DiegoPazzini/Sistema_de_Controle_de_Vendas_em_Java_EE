/**
 * Exceção personalizada para representar erros específicos relacionados a operações de acesso a dados (DAO).
 * 
 * @see DAOException
 * @see Exception
 * @author diego.pazzini
 */
package br.com.pazzini.exceptions;

public class DAOException extends Exception {

    private static final long serialVersionUID = 7054379063290825137L;

    /**
     * Construtor que recebe uma mensagem de erro e uma exceção relacionada.
     *
     * @param msg Mensagem de erro.
     * @param ex Exceção relacionada.
     */
    public DAOException(String msg, Exception ex) {
        super(msg, ex);
    }
}
