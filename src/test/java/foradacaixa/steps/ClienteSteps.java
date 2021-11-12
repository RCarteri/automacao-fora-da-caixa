package foradacaixa.steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import foradacaixa.commons.Utils;
import foradacaixa.pages.ClientePage;
import foradacaixa.pages.LoginPage;
import foradacaixa.pages.MenusPage;

public class ClienteSteps {
	@Given("efetuei login no sistema com (.*) e (.*)")
	public void efetuarLogin(String strUsuario, String strSenha) {
		LoginPage loginPage = new LoginPage();
		loginPage.efetuarLogin(strUsuario, strSenha);
	}

	@And("acessei o menu Clientes >> Inserir")
	public void acessarMenuClientesInserir() {
		MenusPage menusPage = new MenusPage();
		menusPage.acessarMenuClientesInserir();
	}

	@When("na tela Dados de Identificacao informo os dados de Pessoa Fisica: (.*), (.*), (.*), (.*) e (.*)")
	public void informarDadosIdentificacaoPF(String strNome, String strEmail, String strDataNascimento, String strSexo,
			String strEstadoCivil) {
		ClientePage clientePage = new ClientePage();
		clientePage.InformarDadosIdentificacaoPF(strNome, strEmail, strDataNascimento, strSexo, strEstadoCivil);
		Utils.logPrint("Dados de Identificacao");
	}

	@When("na tela Dados de Identificacao informo os dados de Pessoa Juridica: (.*) e (.*)")
	public void informarDadosIdentificacaoPF(String strRazaoSocial, String strEmail) {
		ClientePage clientePage = new ClientePage();
		clientePage.informarDadosIdentificacaoPJ(strRazaoSocial, strEmail);
		Utils.logPrint("Dados de Identificacao PJ");
	}

	@And("na tela Dados de Identificacao clico em Avancar")
	public void clicarAvancar() {
		ClientePage clientePage = new ClientePage();
		clientePage.clicarAvancar();
	}

	@And("na tela Enderecos informo os enderecos")
	public void informarEnderecos() {
		ClientePage clientePage = new ClientePage();
		clientePage.informaEnderecos();
		Utils.logPrint("Enderecos");
	}

	@And("na tela Enderecos clico em Salvar")
	public void clicarSalvar() {
		ClientePage clientePage = new ClientePage();
		clientePage.clicarSalvar();
		Utils.logPrint("Cliente Cadastrado");
	}

	@Then ("a tela de Dados de Identificação deve ser exibida na tela")
	public void verificarExibicaoTelaDadosIdentificacao(){
		ClientePage clientePage = new ClientePage();
		boolean blnExibiuMensagemSucesso = clientePage.verificarExibicaoTelaDadosIdentificacao();
		if (blnExibiuMensagemSucesso){
			Utils.logPass("Tela Dados de Identificacao exibida com sucesso");
		}else {
			Utils.logFail("Erro ao exibir a tela dados de Identificacao");
		}
		Assert.assertTrue("Não exibiu a tela dados de Identificacao", blnExibiuMensagemSucesso);
	}
	
	@Then("na tela Enderecos sera exibida mensagem de sucesso")
	public void verificarMensagemSucesso() {
		ClientePage clientePage = new ClientePage();
		boolean blnExibiuMensagemSucesso = clientePage.verificarMensagemSucesso();
		if (blnExibiuMensagemSucesso) {
			Utils.logPass("Cliente cadastrado com sucesso");
		} else {
			Utils.logFail("Erro ao cadastrar o cliente");
		}
		Assert.assertTrue("Não exibiu a mensagem de sucesso", blnExibiuMensagemSucesso);
	}
}
