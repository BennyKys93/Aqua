package Aqua.com.example.Aqua.dto;

import javax.persistence.Entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class AggregatedPrice {

	private String symbol;

	private String bidPrice;

	private String bidQty;

	private String askPrice;

	private String askQty;

}
