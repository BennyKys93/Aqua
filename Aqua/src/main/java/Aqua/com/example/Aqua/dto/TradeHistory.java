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
public class TradeHistory {

	private long transactionId;
	
	private long personId;

	private String type;

	private long amount;
	
	private long transactionDate;

}
