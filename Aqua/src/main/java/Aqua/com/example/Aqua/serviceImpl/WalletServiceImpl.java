package Aqua.com.example.Aqua.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Aqua.com.example.Aqua.dao.WalletRepository;
import Aqua.com.example.Aqua.dto.Wallet;
import Aqua.com.example.Aqua.model.WalletEntity;
import Aqua.com.example.Aqua.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletRepository walletRepository;

	@Override
	public Optional<Wallet> getWallet(Long id) {
		Optional<Wallet> wallet = walletRepository.findById(id).map(this::convertToWallet);

		return wallet;

	}

	private Wallet convertToWallet(WalletEntity entity) {
		return Wallet.builder().personId(entity.getPersonId()).balance(entity.getBalance())
				.currency(entity.getCurrency()).name(entity.getName()).build();
	}



}
