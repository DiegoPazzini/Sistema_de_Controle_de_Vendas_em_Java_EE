/**
 * A classe MaisDeUmRegistroException é uma exceção personalizada para indicar que uma consulta retornou mais de um registro quando deveria retornar no máximo um.
 * 
 * Atributos:
 * - serialVersionUID: Identificador único para fins de serialização da classe.
 * 
 * Construtores:
 * - MaisDeUmRegistroException(String msg): Construtor que permite definir uma mensagem para a exceção.
 * 
 * Anotações:
 * - Nenhuma anotação específica é usada nesta classe.
 */
package br.com.pazzini.exceptions;

public class MaisDeUmRegistroException extends Exception {

    // Identificador único para fins de serialização da classe.
	private static final long serialVersionUID = -7509649433607067138L;

    // Construtor que permite definir uma mensagem para a exceção.
	public MaisDeUmRegistroException(String msg) {
		super(msg);
    }
}
