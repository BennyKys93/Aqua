package Aqua.com.example.Aqua.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Aqua.com.example.Aqua.dao.AggregatedPriceRepository;
import Aqua.com.example.Aqua.dao.BinanceRepository;
import Aqua.com.example.Aqua.dao.HuobiRepository;
import Aqua.com.example.Aqua.model.AggregatedPriceEntity;
import Aqua.com.example.Aqua.model.BinanceEntity;
import Aqua.com.example.Aqua.model.HuobiEntity;
import Aqua.com.example.Aqua.service.AggregatedService;

@Service
public class AggregatedServiceImpl implements AggregatedService {

	@Autowired
	private HuobiRepository huobiRepository;

	@Autowired
	private BinanceRepository binanceRepository;

	@Autowired
	private AggregatedPriceRepository aggregatedPriceRepository;

	@Override
	public void getAggregatedPrice() {

		List<BinanceEntity> binance = binanceRepository.findAll();

		List<HuobiEntity> huobi = huobiRepository.findAll();

		huobi.forEach(hb -> {

			AggregatedPriceEntity aggre = new AggregatedPriceEntity();
			aggre.setAskPrice(String.valueOf(hb.getBid()));
			aggre.setAskQty(String.valueOf(hb.getAskSize()));
			aggre.setBidPrice(String.valueOf(hb.getBid()));
			aggre.setBidQty(String.valueOf(hb.getBidSize()));
			aggre.setSymbol(hb.getSymbol());
			aggregatedPriceRepository.save(aggre);

			binance.forEach(bn -> {

				Optional<AggregatedPriceEntity> entityOpt = aggregatedPriceRepository.findBySymbol(bn.getSymbol());

				if (Boolean.TRUE.equals(entityOpt.isPresent())) {

					AggregatedPriceEntity entity = entityOpt.get();
					if (hb.getSymbol().equalsIgnoreCase(bn.getSymbol())) {

						if ((hb.getBid() - hb.getAsk()) > Double.valueOf(bn.getBidPrice())
								- Double.valueOf(bn.getAskPrice())) {

							entity.setSymbol(hb.getSymbol());
							entity.setAskPrice(String.valueOf(hb.getBid()));
							entity.setAskQty(String.valueOf(hb.getAskSize()));
							entity.setBidPrice(String.valueOf(hb.getBid()));
							entity.setBidQty(String.valueOf(hb.getBidSize()));
							aggregatedPriceRepository.save(entity);

						} else {
							entity.setSymbol(bn.getSymbol());
							entity.setAskPrice(bn.getAskPrice());
							entity.setAskQty(bn.getAskQty());
							entity.setBidPrice(bn.getBidPrice());
							entity.setBidQty(bn.getBidQty());
							aggregatedPriceRepository.save(entity);

						}
					}

				}
				;

			});

		});

	}
}
