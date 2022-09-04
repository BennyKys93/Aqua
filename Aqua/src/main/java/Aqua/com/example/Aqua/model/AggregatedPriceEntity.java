package Aqua.com.example.Aqua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "AGGREGATED_PRICE")
public class AggregatedPriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "SYMBOL")
	private String symbol;

	@Column(name = "BID_PRICE")
	private String bidPrice;

	@Column(name = "BID_QTY")
	private String bidQty;
	
	@Column(name = "ASK_PRICE")
	private String askPrice;	

	@Column(name = "ASK_QTY")
	private String askQty;
	

}