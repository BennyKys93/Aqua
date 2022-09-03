package Aqua.com.example.Aqua.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Aqua.com.example.Aqua.dao.TradeHistoryRepository;
import Aqua.com.example.Aqua.dto.TradeHistory;
import Aqua.com.example.Aqua.model.TradeHistoryEntity;
import Aqua.com.example.Aqua.service.TradeHistoryService;

@Service
public class TradeHistoryServiceImpl implements TradeHistoryService {

	@Autowired
	private TradeHistoryRepository tradeHistoryRepository;

	@Override
	public List<TradeHistory> getTradeHistory(Long id) {

		List<TradeHistory> trades = tradeHistoryRepository.findAllByPersonId(id).parallelStream()
				.map(this::convertToTradeHistory).collect(Collectors.toList());

		return trades;
	}

	private TradeHistory convertToTradeHistory(TradeHistoryEntity entity) {
		return TradeHistory.builder().amount(entity.getAmount()).personId(entity.getPersonId())
				.transactionDate(entity.getTransactionDate()).transactionId(entity.getTransactionId())
				.personId(entity.getPersonId()).build();
	}

}
