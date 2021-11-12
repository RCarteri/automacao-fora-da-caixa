package foradacaixa.pages;

import java.util.Locale;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import foradacaixa.commons.TestRule;
import foradacaixa.elementMap.ClienteElementMap;
import foradacaixa.commons.Utils;

public class ClientePage extends ClienteElementMap {
	public ClientePage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void InformarDadosIdentificacaoPF(
			String strNome, String strEmail, String strDataNascimento, String strSexo, String strEstadoCivil) {
		fisica.click();
		cpf_cnpj.sendKeys(Utils.gerarCPF());
		nome_razaosocial.sendKeys(strNome);
		email.sendKeys(strEmail);
		data_nascimento.sendKeys(strDataNascimento.replace("/", ""));

		Select cmbSexo = new Select(sexo);
		cmbSexo.selectByVisibleText(strSexo);

		Select cmbEstado_Civil = new Select(estado_civil);
		cmbEstado_Civil.selectByVisibleText(strEstadoCivil);
	}

	public void clicarAvancar() {
		avancar.click();
	}

	public void informaEnderecos() {
		Faker faker = new Faker(new Locale("pt-BR"));
		String phone = faker.phoneNumber().cellPhone().replaceAll("[ |(|)|-]", "");
		// Endereco Principal
		endp_cep.sendKeys(faker.address().zipCode().replace("-", ""));
		endp_endereco.sendKeys(faker.address().firstName());
		endp_numero.sendKeys(faker.number().digits(3));
		endp_complemento.sendKeys(faker.address().lastName());
		endp_cidade.sendKeys(faker.address().cityName());
		Select cmbEstadoEndPrincipal = new Select(endp_estado);
		cmbEstadoEndPrincipal.selectByVisibleText("RS");
		endp_telefone.sendKeys(phone);
		endp_celular.sendKeys(phone);

		// Endereco Cobrança
		endc_cep.sendKeys(faker.address().zipCode());
		endc_endereco.sendKeys(faker.address().firstName());
		endc_numero.sendKeys(faker.number().digits(100));
		endc_complemento.sendKeys(faker.address().lastName());
		endc_cidade.sendKeys(faker.address().cityName());
		Select cmbEstadoEndCobranca = new Select(endc_estado);
		cmbEstadoEndCobranca.selectByVisibleText("RS");
		endc_telefone.sendKeys(phone);
		endc_celular.sendKeys(phone);
	}

	public void clicarSalvar() {
		salvar.click();
	}

	public boolean verificarMensagemSucesso() {
		String strMensagemExibida = mensagem.getText();
		if (strMensagemExibida.contains("Cliente cadastrado com sucesso")) {
			return true;
		} else {
			return false;
		}
	}

	public void informarDadosIdentificacaoPJ(String strRazaoSocial, String strEmail) {
		juridica.click();
		cpf_cnpj.sendKeys(Utils.gerarCNPJ());
		nome_razaosocial.sendKeys(strRazaoSocial);
		email.sendKeys(strEmail);
	}

	public boolean verificarExibicaoTelaDadosIdentificacao() {
		int intQuantidadeItensEncontrados = TestRule.getDriver().findElements(By.id("cpf_cnpj")).size();
		if (intQuantidadeItensEncontrados > 0) {
			return true;
		} else {
			return false;
		}
	}
}
