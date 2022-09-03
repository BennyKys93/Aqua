package Aqua.com.example.Aqua.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "HUOBI")
public class HuobiEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "SYMBOL")
	private String symbol;

	
	@Column(name = "OPEN")
	private double open;

	@Column(name = "HIGH")
	private double high;

	@Column(name = "LOW")
	private double low;

	@Column(name = "CLOSE")
	private double close;

	@Column(name = "AMOUNT")
	private double amount;

	@Column(name = "VOL")
	private double vol;

	@Column(name = "COUNT")
	private int count;

	@Column(name = "BID")
	private double bid;

	@Column(name = "BID_SIZE")
	private double bidSize;

	@Column(name = "ASK")
	private double ask;
	
	@Column(name = "ASK_SIZE")
	private double askSize;

}
