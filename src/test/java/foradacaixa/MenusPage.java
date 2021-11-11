package foradacaixa;

import org.openqa.selenium.support.PageFactory;

public class MenusPage extends MenusElementMap{
    public MenusPage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}
    public void acessarMenuClientesInserir() {
        menuCliente.click();
		submenuClientesInserir.click();
    }
    
}
