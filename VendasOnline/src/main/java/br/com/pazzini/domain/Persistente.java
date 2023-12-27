/**
 * A interface Persistente é implementada por todas as classes que representam entidades ou objetos da aplicação
 * que serão salvos no banco de dados.
 * 
 * Métodos:
 * - getId(): Retorna o identificador único da entidade.
 * - setId(Long id): Define o identificador único da entidade.
 * 
 * Essa interface é utilizada para garantir que todas as classes de domínio tenham métodos comuns para acesso
 * e manipulação de identificadores, facilitando operações de persistência e manipulação de objetos no contexto
 * do banco de dados.
 */
package br.com.pazzini.domain;

public interface Persistente {

	public Long getId();
	
	public void setId(Long id);
}
