package Aqua.com.example.Aqua.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Wallet {

	private long personId;

	private String name;

	private String currency;

	private long balance;

}
