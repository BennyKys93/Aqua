package Aqua.com.example.Aqua.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Aqua.com.example.Aqua.model.WalletEntity;

public interface WalletRepository extends CrudRepository<WalletEntity, Long> {

	List<WalletEntity> findAll();

}
