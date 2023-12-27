/**
 * A classe DAOException é uma exceção personalizada para lidar com erros relacionados a operações de acesso a dados.
 * 
 * Atributos:
 * - serialVersionUID: Identificador único para fins de serialização da classe.
 * 
 * Construtores:
 * - DAOException(String msg, Exception ex): Construtor que permite definir uma mensagem e a exceção original que causou a exceção.
 * 
 * Anotações:
 * - Nenhuma anotação específica é usada nesta classe.
 */
package br.com.pazzini.exceptions;

public class DAOException extends Exception {

    // Identificador único para fins de serialização da classe.
	private static final long serialVersionUID = 7054379063290825137L;

    // Construtor que permite definir uma mensagem e a exceção original que causou a exceção.
	public DAOException(String msg, Exception ex) {
		super(msg, ex);
    }
}
