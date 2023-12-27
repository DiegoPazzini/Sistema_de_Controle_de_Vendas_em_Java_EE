/**
 * A classe Produto representa um item comercializável na aplicação, que pode ser vendido aos clientes.
 * 
 * Atributos:
 * - id: Identificador único do produto (chave primária no banco de dados).
 * - codigo: Código identificador único do produto, deve ser único para cada produto.
 * - nome: Nome do produto.
 * - descricao: Descrição do produto.
 * - valor: Valor do produto.
 * 
 * Métodos:
 * - Getters e Setters para todos os atributos.
 * 
 * Anotações:
 * - @Entity: Indica que a classe é uma entidade JPA, ou seja, pode ser persistida no banco de dados.
 * - @Table: Especifica o nome da tabela no banco de dados que será associada à entidade.
 * - @NamedQuery: Define uma consulta nomeada que pode ser usada posteriormente em consultas JPA.
 * - @Id: Indica o atributo que representa a chave primária.
 * - @GeneratedValue: Especifica a estratégia de geração de valores para a chave primária.
 * - @SequenceGenerator: Define o gerador de sequência associado à estratégia de geração de valores.
 * - @Column: Permite a especificação de propriedades adicionais para o mapeamento de colunas no banco de dados.
 */
package br.com.pazzini.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
@NamedQuery(name = "Produto.findByNome", query = "SELECT c FROM Produto c WHERE c.nome LIKE :nome") 
public class Produto implements Persistente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_seq")
	@SequenceGenerator(name="prod_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "codigo", nullable = false, length = 10, unique = true)
	private String codigo;
	
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "DESCRICAO", nullable = false, length = 50)
	private String descricao;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
