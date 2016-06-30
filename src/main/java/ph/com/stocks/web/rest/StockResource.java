package ph.com.stocks.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ph.com.stocks.dto.StockDTO;
import ph.com.stocks.util.HttpUtils;

@RestController
@RequestMapping("/api")
public class StockResource {
	
	@Value("${pse.api.url}")	String pseUrl;
	@Value("${proxy.address}")	String proxyAddress;
	@Value("${proxy.port}")		int proxyPort;
	
	@RequestMapping(value="/stocks", method=RequestMethod.GET)
	public ResponseEntity<StockDTO> getStocks(){
		RestTemplate rest = new RestTemplate(new HttpUtils().getProxyAccess(proxyAddress,proxyPort));
		StockDTO stocks= rest.getForObject(pseUrl, StockDTO.class);
		HttpStatus status = HttpStatus.OK; 
		if(stocks==null){
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<StockDTO>(stocks, status);
	}

	
}
	