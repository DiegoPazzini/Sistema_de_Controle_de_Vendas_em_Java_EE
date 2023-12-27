/**
 * Implementação da interface IVendaDAO que estende a classe genérica GenericDAO.
 * Responsável por operações de persistência específicas para a entidade Venda.
 * 
 * Métodos implementados incluem:
 * - finalizarVenda: realiza a finalização de uma venda.
 * - cancelarVenda: realiza o cancelamento de uma venda.
 * - excluir: sobrescrito para lançar UnsupportedOperationException.
 * - cadastrar: realiza o cadastro de uma venda, atualizando as associações com Cliente e Produto.
 * - consultarComCollection: consulta uma venda incluindo as coleções associadas (cliente e produtos).
 */
package br.com.pazzini.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.pazzini.dao.generic.GenericDAO;
import br.com.pazzini.domain.Cliente;
import br.com.pazzini.domain.Produto;
import br.com.pazzini.domain.Venda;
import br.com.pazzini.exceptions.DAOException;
import br.com.pazzini.exceptions.TipoChaveNaoEncontradaException;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

    /**
     * Construtor que chama o construtor da classe pai, informando a classe da entidade Venda.
     */
    public VendaDAO() {
        super(Venda.class);
    }

    /**
     * Realiza a finalização de uma venda.
     *
     * @param venda a ser finalizada
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    /**
     * Realiza o cancelamento de uma venda.
     *
     * @param venda a ser cancelada
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(venda);
    }

    /**
     * Sobrescreve o método excluir para lançar UnsupportedOperationException.
     *
     * @param entity a ser excluída
     * @throws DAOException
     */
    @Override
    public void excluir(Venda entity) throws DAOException {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    /**
     * Realiza o cadastro de uma venda, atualizando as associações com Cliente e Produto.
     *
     * @param entity a ser cadastrada
     * @return a venda cadastrada
     * @throws TipoChaveNaoEncontradaException
     * @throws DAOException
     */
    @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            entity.getProdutos().forEach(prod -> {
                Produto prodJpa = entityManager.merge(prod.getProduto());
                prod.setProduto(prodJpa);
            });
            Cliente cliente = entityManager.merge(entity.getCliente());
            entity.setCliente(cliente);
            entityManager.persist(entity);
            return entity;
        } catch (Exception e) {
            throw new DAOException("ERRO SALVANDO VENDA ", e);
        }
    }

    /**
     * Consulta uma venda incluindo as coleções associadas (cliente e produtos).
     *
     * @param id identificador da venda
     * @return a venda consultada
     */
    @Override
    public Venda consultarComCollection(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
        Root<Venda> root = query.from(Venda.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Venda> tpQuery = entityManager.createQuery(query);
        Venda venda = tpQuery.getSingleResult(); 
        return venda;
    }
}
