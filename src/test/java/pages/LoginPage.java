package pages;

import org.openqa.selenium.support.PageFactory;

import foradacaixa.TestRule;
import foradacaixa.elementMap.LoginElementMap;

public class LoginPage extends LoginElementMap{
	public LoginPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
    public void efetuarLogin () {
		login.sendKeys("john");
		senha.sendKeys("john");
		btnLogin.click();
	}
}
