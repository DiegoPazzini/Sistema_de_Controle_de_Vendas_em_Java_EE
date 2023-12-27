/**
 * A classe GenericDAO implementa a interface IGenericDAO para fornecer operações genéricas de persistência
 * utilizando o EntityManager do JPA (Java Persistence API).
 * 
 * Ela é parametrizada pelos tipos T (entidade persistente) e E (tipo da chave primária), e possui métodos
 * para cadastrar, excluir, alterar, consultar e buscar todos os registros da entidade.
 * 
 * As transações de persistência (commit) não são realizadas nesta classe, pois o controle transacional é
 * geralmente feito em camadas mais altas da aplicação.
 * 
 * A anotação @PersistenceContext injeta o EntityManager no atributo entityManager, que é utilizado para interagir
 * com o contexto de persistência.
 * 
 * Os métodos desta classe utilizam o EntityManager para realizar as operações de persistência e consulta no banco de dados.
 * 
 * Esta classe possui uma variável persistenteClass que armazena a classe da entidade persistente, e é utilizada
 * para compor as consultas JPQL (Java Persistence Query Language).
 * 
 * Para buscar todos os registros, é construída uma consulta JPQL simples que seleciona todos os registros da entidade
 * persistente armazenada na variável persistenteClass.
 */
package br.com.pazzini.dao.generic;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pazzini.dao.generic.IGenericDAO;
import br.com.pazzini.domain.Persistente;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.MaisDeUmRegistroException;
import br.com.pazzini.exceptions.TableException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;

public class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T, E> {

    protected Class<T> persistenteClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDAO(Class<T> persistenteClass) {
        this.persistenteClass = persistenteClass;
    }

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        entityManager.persist(entity);
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
        entity = entityManager.merge(entity);
        return entity;
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        T entity = entityManager.find(this.persistenteClass, valor);
        return entity;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        List<T> list = entityManager.createQuery(getSelectSql(), this.persistenteClass).getResultList();
        return list;
    }

    private String getSelectSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT obj FROM ");
        sb.append(this.persistenteClass.getSimpleName());
        sb.append(" obj");
        return sb.toString();
    }

}
