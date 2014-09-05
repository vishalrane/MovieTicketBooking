import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class OverviewPageTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testHomePage() {
		driver.get("http://localhost:8080/MovieTicketBookingSystem");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Assert.assertEquals(2, links.size());
		Assert.assertEquals("Check Ticket Avability", links.get(0).getText());
		Assert.assertEquals("Book Ticket", links.get(1).getText());
	}
	
	@Test
	public void testCheckTicketAvabilityPage() {
		driver.get("http://localhost:8080/MovieTicketBookingSystem");
		WebElement link = driver.findElement(By.linkText("Check Ticket Avability"));
		link.click();
		Assert.assertEquals("Check Avability", driver.getTitle());
	}

	@Test
	public void testCheckTicketAvabilityResponse() {
		driver.get("http://localhost:8888/MovieTicketBookingSystem");
		WebElement link = driver.findElement(By.linkText("Check Ticket Avability"));
		link.click();
		driver.findElement(By.id("checkAvability")).click();
		WebElement responseDiv = driver.findElement(By.id("myDiv"));
		Assert.assertEquals("Check Avability", responseDiv.getValue());
	}
}