/**
 * Exceção personalizada para representar erros relacionados a problemas nas tabelas do banco de dados.
 * 
 * @see TableException
 * @see Exception
 * @author diego.pazzini
 */
package br.com.pazzini.exceptions;

public class TableException extends Exception {

    private static final long serialVersionUID = -7509649433607067138L;

    /**
     * Construtor que recebe uma mensagem de erro.
     *
     * @param msg Mensagem de erro.
     */
    public TableException(String msg) {
        super(msg);
    }
}
