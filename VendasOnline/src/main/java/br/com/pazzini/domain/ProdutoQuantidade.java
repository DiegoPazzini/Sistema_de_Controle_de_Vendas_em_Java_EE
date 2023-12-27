/**
 * A classe ProdutoQuantidade representa a quantidade de um produto associada a uma venda na aplicação.
 * 
 * Atributos:
 * - id: Identificador único da entidade (chave primária no banco de dados).
 * - produto: Objeto do tipo Produto associado à quantidade.
 * - quantidade: Quantidade do produto associado à venda.
 * - valorTotal: Valor total calculado com base na quantidade e no valor unitário do produto.
 * - venda: Objeto do tipo Venda associado à quantidade.
 * 
 * Métodos:
 * - Getters e Setters para todos os atributos.
 * - adicionar(Integer quantidade): Atualiza a quantidade e o valor total ao adicionar mais unidades do produto.
 * - remover(Integer quantidade): Atualiza a quantidade e o valor total ao remover unidades do produto.
 * 
 * Anotações:
 * - @Entity: Indica que a classe é uma entidade JPA, ou seja, pode ser persistida no banco de dados.
 * - @Table: Especifica o nome da tabela no banco de dados que será associada à entidade.
 * - @Id: Indica o atributo que representa a chave primária.
 * - @GeneratedValue: Especifica a estratégia de geração de valores para a chave primária.
 * - @SequenceGenerator: Define o gerador de sequência associado à estratégia de geração de valores.
 * - @ManyToOne: Estabelece a associação muitos-para-um entre ProdutoQuantidade e Produto ou Venda.
 * - @JoinColumn: Especifica a coluna que será utilizada como chave estrangeira na tabela.
 * - @ForeignKey: Define o nome da chave estrangeira no banco de dados.
 */
package br.com.pazzini.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_qtd_seq")
	@SequenceGenerator(name="prod_qtd_seq", sequenceName="sq_prod_qtd", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Produto produto;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_venda_fk", 
		foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"), 
		referencedColumnName = "id", nullable = false
	)
	private Venda venda;
	
	public ProdutoQuantidade() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public void adicionar(Integer quantidade) {
		this.quantidade += quantidade;
		BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
		BigDecimal novoTotal = this.valorTotal.add(novoValor);
		this.valorTotal = novoTotal;
	}
	
	public void remover(Integer quantidade) {
		this.quantidade -= quantidade;
		BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
		this.valorTotal = this.valorTotal.subtract(novoValor);
	}
}
