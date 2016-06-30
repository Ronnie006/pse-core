package ph.com.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import ph.com.stocks.TestSpringApplication;
import ph.com.stocks.dto.StockDTO;
import ph.com.stocks.model.Stock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestSpringApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8081") 
public class TestSpringApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(TestSpringApplicationTests.class);
	TestRestTemplate rt;
	
	@Before
	public void setup(){
		rt = new TestRestTemplate();
	}
	
	@Test
	public void contextLoads() {}

	@Test
	public void getStocks(){
		StockDTO stockArr = rt.getForObject("http://localhost:8081/api/stocks", StockDTO.class);
		List<Stock> stocks = stockArr.getStock();
		Assert.isTrue(stocks.get(0).getName().equals("2GO Group"));
	}
}
