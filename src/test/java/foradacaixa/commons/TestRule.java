package foradacaixa.commons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {
	private static WebDriver driver;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;

    @Before
    public void beforeCenario(Scenario cenario) {
    	if (extentReport == null) {
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter("src/test/resources/report/htmlReporter.html");
			extentReport.attachReporter(htmlReporter);
		}
		extentTest = extentReport.createTest(cenario.getId());
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/ruehlein/AppData/Local/Google/Chrome/User Data");
		driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
		driver.navigate().to("file:///C:/Users/ruehlein/eclipse-workspace/foradacaixa/src/test/resources/site/index.html");
		
	}
    
    @After
	public void afterCenario(Scenario cenario) {
		if(cenario.isFailed()) {
			extentTest.log(Status.FAIL, "Cenario: " + cenario.getName() + " EXECUTADO COM FALHAS!");
			extentReport.flush();
		} else {
			extentTest.log(Status.PASS, "Cenario: " + cenario.getName() + " EXECUTADO COM SUCESSO!");
			extentReport.flush();
		}
		
		if(driver != null) {
			driver.close();
		}
	}

    public static WebDriver getDriver() {
        return driver;
    }
    public static ExtentTest getExtentTest() {
        return extentTest;
    }
}
/*Como esse sistema de treinamento utiliza uma base de dados Web SQL Database criada no Chrome, 
o Selenium nao carregava essa base ao iniciar o Chrome. Entao como ele nao 
encontrava a tabela USUARIO (onde sao guardadas as informacoes de logins e senhas) 
estourava uma excessao por debaixo dos panos e o sistema travava na tela de login.
O que foi feito e o seguinte: como as informacoes de base de dados ficam nos dados de 
usuario do navegador, era preciso dizer ao Selenium para carregar essas informacoes ao abrir o Chrome. 
E isso o que as duas linhas de codigo fazem. Criam um objeto do tipo ChromeOptions 
e nele e explicitado para carregar os dados do usuario do Chrome. Em seguida e passado por
parametro no driver*/