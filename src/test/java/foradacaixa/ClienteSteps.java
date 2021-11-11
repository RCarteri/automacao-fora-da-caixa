package foradacaixa;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClienteSteps {
	@Given("efetuei login no sistema")
	public void efetuarLogin() {
		
	}

	@And("acessei o menu Clientes >> Inserir")
	public void acessarMenuClientesInserir() {

	}

	@When("na tela Dados de Identificacao informo os dados de Pessoa Fisica")
	public void informarDadosIdentificacaoPF() {
		ClientePage clientePage = new ClientePage ();
		clientePage.InformarDadosIdentificacaoPF();
	}

	@And("na tela Dados de Identificacao clico em Avancar")
	public void clicarAvancar() {
		ClientePage clientePage = new ClientePage ();
		clientePage.clicarAvancar();
	}

	@And("na tela Enderecos informo os enderecos")
	public void informarEnderecos() {
		ClientePage clientePage = new ClientePage ();
		clientePage.informaEnderecos();
	}

	@And("na tela Enderecos clico em Salvar")
	public void clicarSalvar() {
		ClientePage clientePage = new ClientePage ();
		clientePage.clicarSalvar();
	}

	@Then("na tela Enderecos sera exibida mensagem de sucesso")
	public void verificarMensagemSucesso() {
		ClientePage clientePage = new ClientePage ();
		clientePage.verificarMensagemSucesso();
	}

	@And("efetuarei logout do sistema")
	public void efetuarLogout() {

	}
}
