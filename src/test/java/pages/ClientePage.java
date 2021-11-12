package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import foradacaixa.TestRule;
import foradacaixa.elementMap.ClienteElementMap;

public class ClientePage extends ClienteElementMap {
	public ClientePage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void InformarDadosIdentificacaoPF(String strNome, String strEmail, String strDataNascimento, String strSexo,
			String strEstadoCivil) {
		fisica.click();
		cpf_cnpj.sendKeys("404.357.110-08");
		nome_razaosocial.sendKeys(strNome);
		email.sendKeys(strEmail);
		data_nascimento.sendKeys(strDataNascimento);

		Select cmbSexo = new Select(sexo);
		cmbSexo.selectByVisibleText(strSexo);

		Select cmbEstado_Civil = new Select(estado_civil);
		cmbEstado_Civil.selectByVisibleText(strEstadoCivil);

	}

	public void clicarAvancar() {
		avancar.click();
	}

	public void informaEnderecos() {

		// Endereco Principal

		endp_cep.sendKeys("38400762");
		endp_endereco.sendKeys("Rua Brasia");
		endp_numero.sendKeys("355");
		endp_complemento.sendKeys("bl 26");
		endp_cidade.sendKeys("Uberlandia");
		Select cmbEstadoEndPrincipal = new Select(endp_estado);
		cmbEstadoEndPrincipal.selectByVisibleText("RS");
		endp_telefone.sendKeys("54999510456");
		endp_celular.sendKeys("54999510456");

		// Endereco Cobran�a

		endc_cep.sendKeys("38400762");
		endc_endereco.sendKeys("Rua Bralia");
		endc_numero.sendKeys("355");
		endc_complemento.sendKeys("bl 26");
		endc_cidade.sendKeys("Uberlandia");
		Select cmbEstadoEndCobranca = new Select(endc_estado);
		cmbEstadoEndCobranca.selectByVisibleText("RS");
		endc_telefone.sendKeys("54999510456");
		endc_celular.sendKeys("54999510456");

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

}
