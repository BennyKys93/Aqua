package Aqua.com.example.Aqua.endpoint;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import Aqua.com.example.Aqua.dto.Binance;
import Aqua.com.example.Aqua.dto.Data;
import Aqua.com.example.Aqua.dto.Huobi;
import Aqua.com.example.Aqua.dto.TradeHistory;
import Aqua.com.example.Aqua.dto.Wallet;
import Aqua.com.example.Aqua.service.AggregatedService;
import Aqua.com.example.Aqua.service.BinanceService;
import Aqua.com.example.Aqua.service.HuobiService;
import Aqua.com.example.Aqua.service.TradeHistoryService;
import Aqua.com.example.Aqua.service.WalletService;
import lombok.extern.slf4j.Slf4j;

@RestController
public class AquaEndpointInner {

	@Autowired
	private BinanceService binanceService;

	@Autowired
	private HuobiService huobiService;

	@Autowired
	private TradeHistoryService tradeHistoryService;

	@Autowired
	private WalletService walletService;

	@Autowired
	private AggregatedService aggregatedService;

	@Scheduled(fixedRate = 10000)
	@GetMapping(value = "/binance")
	private void getBinance() {

		String url = "https://api.binance.com/api/v3/ticker/bookTicker";

		RestTemplate restTemplate = new RestTemplate();

		Binance[] binance = restTemplate.getForObject(url, Binance[].class);

		binanceService.saveBinance(binance);

	}

	@Scheduled(fixedRate = 10000)
	@GetMapping(value = "/huobi")
	private void getHuobi() {
		String url = "https://api.huobi.pro/market/tickers";

		RestTemplate restTemplate = new RestTemplate();

		Huobi huobi = restTemplate.getForObject(url, Huobi.class);

		huobiService.saveHuobi(huobi);

	}

	@GetMapping("/getAggregated")
	private void getAggregated() {

		aggregatedService.getAggregatedPrice();
	}

	@GetMapping("/getTradeHistory")
	private List<TradeHistory> getTradeHistory(Long personId) {

		return tradeHistoryService.getTradeHistory(personId);
	}

	@GetMapping("/getWallet")
	private Optional<Wallet> getWallet(Long personId) {

		return walletService.getWallet(personId);
	}

}
