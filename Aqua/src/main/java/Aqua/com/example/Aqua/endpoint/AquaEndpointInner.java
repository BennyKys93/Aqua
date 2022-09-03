package Aqua.com.example.Aqua.endpoint;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import Aqua.com.example.Aqua.dto.Binance;
import Aqua.com.example.Aqua.dto.Data;
import Aqua.com.example.Aqua.dto.Huobi;
import Aqua.com.example.Aqua.service.BinanceService;
import Aqua.com.example.Aqua.service.HuobiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AquaEndpointInner {
	
	@Autowired
	private BinanceService binanceService;
	
	@Autowired
	private HuobiService huobiService;

	@GetMapping(value = "/binance")
	private void getBinance() {
		String url = "https://api.binance.com/api/v3/ticker/bookTicker";

		RestTemplate restTemplate = new RestTemplate();

		Binance[] binance = restTemplate.getForObject(url, Binance[].class);
		
		binanceService.saveBinance(binance);


	}
	
	@GetMapping(value = "/huobi")
	private void getHuobi() {
		String url = "https://api.huobi.pro/market/tickers";

		RestTemplate restTemplate = new RestTemplate();

		Huobi huobi = restTemplate.getForObject(url, Huobi.class);
		
		huobiService.saveHuobi(huobi);


	}

}
