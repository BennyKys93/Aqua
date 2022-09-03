package Aqua.com.example.Aqua.dto;

import javax.persistence.Entity;

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
public class Data {

	private String symbol;

	private double open;

	private double high;

	private double low;

	private double close;

	private double amount;

	private double vol;

	private int count;

	private double bid;

	private double bidSize;

	private double ask;

	private double askSize;

}
