/**
 * Classe genérica para operações de acesso a dados (DAO) usando o padrão JPA.
 * Esta classe fornece métodos comuns para cadastro, exclusão, alteração, consulta e busca de todos os registros de uma entidade persistente.
 * Os métodos utilizam o EntityManager do JPA para interagir com o banco de dados.
 */
package br.com.pazzini.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pazzini.domain.Persistente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.MaisDeUmRegistroException;
import br.com.pazzini.exceptions.TableException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;

/**
 * Implementação genérica da interface IGenericDAO.
 * Esta classe é parametrizada para trabalhar com qualquer entidade persistente (T) que implementa a interface Persistente
 * e qualquer tipo de chave primária (E) que seja serializável.
 *
 * @param <T> Tipo da entidade persistente.
 * @param <E> Tipo da chave primária.
 * @author diego.pazzini
 */
public class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T, E> {

    private Class<T> persistenteClass;  // Classe da entidade persistente.

    @PersistenceContext
    private EntityManager entityManager;  // Gerenciador de entidades do JPA.

    /**
     * Construtor que recebe a classe da entidade persistente como parâmetro.
     *
     * @param persistenteClass Classe da entidade persistente.
     */
    public GenericDAO(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        entityManager.persist(entity);  // Persiste a entidade no banco de dados.
        return entity;
    }

    @Override
    public void excluir(T entity) throws DAOException {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            T managedCustomer = entityManager.find(this.persistenteClass, entity.getId());
            if (managedCustomer != null) {
                entityManager.remove(managedCustomer);
            }
        }
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        entity = entityManager.merge(entity);  // Atualiza a entidade no banco de dados.
        return entity;
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        T entity = entityManager.find(this.persistenteClass, valor);  // Consulta a entidade pelo valor da chave primária.
        return entity;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        List<T> list = entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
        return list;
    }

    /**
     * Gera a string SQL para a consulta de todos os registros da entidade persistente.
     *
     * @return String SQL para a consulta de todos os registros.
     */
    private String getSelectSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT obj FROM ");
        sb.append(this.persistenteClass.getSimpleName());
        sb.append(" obj");
        return sb.toString();
    }
}
