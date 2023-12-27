/**
 * A classe Venda representa uma transação de venda na aplicação.
 * 
 * Atributos:
 * - id: Identificador único da entidade (chave primária no banco de dados).
 * - codigo: Código identificador único da venda.
 * - cliente: Objeto do tipo Cliente associado à venda.
 * - produtos: Conjunto de objetos ProdutoQuantidade associados à venda.
 * - valorTotal: Valor total da venda, calculado com base nos produtos e suas quantidades.
 * - dataVenda: Data e hora em que a venda foi realizada.
 * - status: Status da venda (INICIADA, CONCLUIDA, CANCELADA).
 * 
 * Métodos:
 * - Getters e Setters para todos os atributos.
 * - adicionarProduto(Produto produto, Integer quantidade): Adiciona um produto à venda ou atualiza a quantidade se já existir.
 * - removerProduto(Produto produto, Integer quantidade): Remove a quantidade especificada de um produto da venda.
 * - removerTodosProdutos(): Remove todos os produtos da venda.
 * - getQuantidadeTotalProdutos(): Obtém a quantidade total de produtos na venda.
 * - recalcularValorTotalVenda(): Recalcula o valor total da venda com base nos produtos e suas quantidades.
 * - validarStatus(): Lança uma exceção se a venda estiver finalizada, impedindo alterações.
 * 
 * Anotações:
 * - @Entity: Indica que a classe é uma entidade JPA, ou seja, pode ser persistida no banco de dados.
 * - @Table: Especifica o nome da tabela no banco de dados que será associada à entidade.
 * - @Id: Indica o atributo que representa a chave primária.
 * - @GeneratedValue: Especifica a estratégia de geração de valores para a chave primária.
 * - @SequenceGenerator: Define o gerador de sequência associado à estratégia de geração de valores.
 * - @ManyToOne: Estabelece a associação muitos-para-um entre Venda e Cliente.
 * - @OneToMany: Estabelece a associação um-para-muitos entre Venda e ProdutoQuantidade.
 * - @JoinColumn: Especifica a coluna que será utilizada como chave estrangeira na tabela.
 * - @ForeignKey: Define o nome da chave estrangeira no banco de dados.
 * - @Enumerated: Especifica o tipo de enumeração para o atributo status.
 */
package br.com.pazzini.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VENDA")
public class Venda implements Persistente {
	
    // Enumeração para representar os diferentes estados da venda.
	public enum Status {
		INICIADA, CONCLUIDA, CANCELADA;

        // Método para obter um valor da enumeração pelo nome.
		public static Status getByName(String value) {
			for (Status status : Status.values()) {
	            if (status.name().equals(value)) {
	                return status;
	            }
	        }
			return null;
		}
	}
	
    // Identificador único da venda.
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="venda_seq")
	@SequenceGenerator(name="venda_seq", sequenceName="sq_venda", initialValue = 1, allocationSize = 1)
	private Long id;

    // Código identificador único da venda.
	@Column(name = "CODIGO", nullable = false, unique = true)
	private String codigo;
	
    // Cliente associado à venda.
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk", 
		foreignKey = @ForeignKey(name = "fk_venda_cliente"), 
		referencedColumnName = "id", nullable = false
	)
	private Cliente cliente;
	
    // Conjunto de produtos associados à venda.
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ProdutoQuantidade> produtos;
	
    // Valor total da venda.
	@Column(name = "VALOR_TOTAL", nullable = false)
	private BigDecimal valorTotal;
	
    // Data e hora da venda.
	@Column(name = "DATA_VENDA", nullable = false)
	private Instant dataVenda;
	
    // Status da venda.
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_VENDA", nullable = false)
	private Status status;
	
    // Construtor padrão para inicializar o conjunto de produtos.
	public Venda() {
		produtos = new HashSet<>();
	}

    // Métodos omitidos para brevidade...
}
