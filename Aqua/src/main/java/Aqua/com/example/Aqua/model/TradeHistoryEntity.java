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
@Table(name = "TRADE_HISTORY")
public class TradeHistoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRANSACTION_ID")
	private long transactionId;

	@Column(name = "PERSON_ID")
	private long personId;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "AMOUNT")
	private long amount;
	
	@Column(name = "TRANSACTION_DATE")
	private long transactionDate;
	

}