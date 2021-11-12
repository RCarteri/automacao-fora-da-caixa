package foradacaixa.pages;

import org.openqa.selenium.support.PageFactory;

import foradacaixa.commons.TestRule;
import foradacaixa.elementMap.MenusElementMap;

public class MenusPage extends MenusElementMap{
    public MenusPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
    public void acessarMenuClientesInserir() {
        menuCliente.click();
		submenuClientesInserir.click();
    }
    
}
