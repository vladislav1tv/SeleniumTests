import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Замените на путь к ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testTextBox() {
        driver.get("https://demoqa.com/");

        // Нажать на блок "Elements"
        driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]")).click();

        // Выбрать "Text Box"
        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[1]/span")).click();

        // Заполнить поля
        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("Тюкин Владислав Вячеславович");

        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("qa.engineer.tv@gmail.com");

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("Нижегородская обл, рп Воротынец, ул М.Горького, д 39");

        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        permanentAddressInput.sendKeys("Нижегородская обл, рп Воротынец, ул М.Горького, д 39");

        // Нажать на кнопку "Submit"
        driver.findElement(By.id("submit")).click();

        // Проверить выведенные данные
        WebElement fullNameOutput = driver.findElement(By.id("name"));
        Assert.assertEquals(fullNameOutput.getText(), "Name: Тюкин Владислав Вячеславович");

        WebElement emailOutput = driver.findElement(By.id("email"));
        Assert.assertEquals(emailOutput.getText(), "Email: qa.engineer.tv@gmail.com");

        WebElement currentAddressOutput = driver.findElement(By.id("currentAddress"));
        Assert.assertEquals(currentAddressOutput.getText(), "Current Address :Нижегородская обл, рп Воротынец, ул М.Горького, д 39");

        WebElement permanentAddressOutput = driver.findElement(By.id("permanentAddress"));
        Assert.assertEquals(permanentAddressOutput.getText(), "Permananet Address :Нижегородская обл, рп Воротынец, ул М.Горького, д 39");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
