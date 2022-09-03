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
@Table(name = "WALLET")
public class WalletEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long personId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CURRENCY")
	private String currency;

	@Column(name = "BALANCE")
	private long balance;

}