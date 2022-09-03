package Aqua.com.example.Aqua.service;

import java.util.Optional;

import Aqua.com.example.Aqua.dto.Wallet;

public interface WalletService {

	Optional<Wallet> getWallet(Long id);

}
