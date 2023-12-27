/**
 * A classe TableException é uma exceção personalizada para indicar problemas relacionados a tabelas no contexto do sistema.
 * 
 * Atributos:
 * - serialVersionUID: Identificador único para fins de serialização da classe.
 * 
 * Construtores:
 * - TableException(String msg): Construtor que permite definir uma mensagem para a exceção.
 * 
 * Anotações:
 * - Nenhuma anotação específica é usada nesta classe.
 */
package br.com.pazzini.exceptions;

public class TableException extends Exception {

    // Identificador único para fins de serialização da classe.
	private static final long serialVersionUID = -7509649433607067138L;

    // Construtor que permite definir uma mensagem para a exceção.
	public TableException(String msg) {
		super(msg);
    }
}
