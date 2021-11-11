package foradacaixa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.Before;

public class TestRule {
    private static WebDriver driver;

    @Before
    public void beforeCenario() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/ruehlein/AppData/Local/Google/Chrome/User Data");
		driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
		driver.navigate().to("file:///C:/Users/ruehlein/eclipse-workspace/foradacaixa/src/test/resources/site/index.html");
		
	}

    public static WebDriver getDriver() {
        return driver;
    }
}
/*Como esse sistema de treinamento utiliza uma base de dados Web SQL Database criada no Chrome, 
o Selenium não carregava essa base ao iniciar o Chrome. Então como ele não 
encontrava a tabela “USUARIO” (onde são guardadas as informações de logins e senhas) 
estourava uma exceção “por debaixo dos panos” e o sistema travava na tela de login.
O que foi feito é o seguinte: como as informações de base de dados ficam nos dados de 
usuário do navegador, era preciso dizer ao Selenium para carregar essas informações ao abrir o Chrome. 
É isso o que as duas linhas de código fazem 18-19. Criam um objeto do tipo “ChromeOptions” 
e nele é explicitado para carregar os dados do usuário do Chrome. Em seguida é passado por
parâmetro no driver*/