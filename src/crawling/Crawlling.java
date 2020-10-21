package crawling;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dto.MenuInfoDto;
import util.DataCode;

public class Crawlling {
	public void getNutrition(String search, String cateType) throws IOException{
		
		String url = "https://www.starbucks.co.kr/menu";
		String fullUrl = "";
		String typeUrl = "";
		String typeUrl2 = "";
		if(cateType.equals("food")) {
			typeUrl = "/food_list.do";
			typeUrl2 = "/food_view.do";
		}else if(cateType.equals("drink")) {
			typeUrl = "/drink_list.do";
		}
		fullUrl = url + typeUrl;
		ChromeDriver driver = null;
		try {
			Path path = Paths.get("src/driver/chromedriver.exe"); 
			System.setProperty("webdriver.chrome.driver", path.toString());
			
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--start-maximized");          // 창 최대 크기로
	        options.addArguments("--headless");                 // Browser 표시 안함
	        options.addArguments("--disable-gpu");              // GPU로드 안함 (Linux 필수)
	        options.addArguments("--no-sandbox");               // Sandbox (Linux 필수)
	        
	        // 3. WebDriver 로드
	        driver = new ChromeDriver( options );
	        
	        // 4. url 열기
	        driver.get(fullUrl);
	        
	        Thread.sleep(2000);
	        
	        List<WebElement> elements = driver.findElements(By.cssSelector("li.menuDataSet"));		
	        
	        System.out.println("Size :" + elements.size());
	        
	        MenuInfoDto menuDto = null;
	        for(WebElement ele : elements) {
	        	if(ele.getText().equals(search)) {
	        		menuDto = new MenuInfoDto();
	        		String skuNo = ele.findElement(By.tagName("a")).getAttribute("prod");
	        		menuDto.setMenuName(ele.getText());
	        		menuDto.setSkuNo(skuNo);
	        		menuDto.setNutritionInfoUrl(url + typeUrl2 + "?product_cd=" + skuNo);
	        		System.out.println("메뉴 명 : " + ele.getText() + " | skuNo : " + ele.findElement(By.tagName("a")).getAttribute("prod"));
	        	}
	        }
	        
	        
	        if(menuDto == null) {
	        	System.out.println("검색 결과 없음");
	        }else {
	        	driver.get(menuDto.getNutritionInfoUrl());
	        	Thread.sleep(2000);
	        	WebElement ele = driver.findElement(By.cssSelector("div.product_info_content"));
	        	List<WebElement> eleList = ele.findElements(By.tagName("li"));
	        	for(WebElement el : eleList) {
	        		System.out.println(el.findElement(By.className(DataCode.CAROLY_STR)).getText());
	        	}
	        }
	        
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(driver != null) {
				driver.quit();
			}
		}
	}
}
