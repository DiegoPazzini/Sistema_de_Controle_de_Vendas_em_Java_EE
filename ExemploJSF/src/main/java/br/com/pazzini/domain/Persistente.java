/**
 * Interface marcadora que representa entidades ou objetos da aplicação a serem persistidos no banco de dados.
 * Todas as classes que implementam esta interface devem fornecer métodos para obter e definir um identificador único (ID).
 * 
 * @see Persistente
 * @author diego.pazzini
 */
package br.com.pazzini.domain;

public interface Persistente {

    /**
     * Obtém o ID único da entidade ou objeto.
     *
     * @return ID único da entidade ou objeto.
     */
    public Long getId();

    /**
     * Define o ID único da entidade ou objeto.
     *
     * @param id Novo ID único da entidade ou objeto.
     */
    public void setId(Long id);
}
