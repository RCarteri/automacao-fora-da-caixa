# Projeto automação fora da caixa

Neste repositório encontram-se os arquivos do [projeto fora da caixa][foradacaixa]. Onde foi realizada a automação das funcionalidades de um [site local][site] utilizando Java, Junit, Cucumber e Selenium.

## Ambiente

Para realizar os testes é necessário ter instalado na máquina:

* [Maven][maven] para a organização do projeto
* [Java][java] como linguagem de programação (como eu usei o VS Code precisou ser o Java 8 "não sei porque")
* Definir o Maven e Java como variáveis de ambiente e adicionar ao Path
* [Visual Studio Code][vscode], [Eclipse][Eclipse] ou [IntelliJ IDEA][intelliJ] como IDE
* Verificar a versão do Chrome se é a 95, senão baixar o chromedriver correspondente a sua versão no [link][chromedriver] e substituir no [diretorio][dirChromedriver].

## Exemplo

A automação realiza o login no sistema e cadastra usuários PF e PJ validando se o cadastro foi feito com sucesso e gerando um htmlReport com os prints referentes a cada step.

*Como o sistema é local o Chrome não deve estar aberto para realizar o teste

A seguir um vídeo mostrando o sistema em funcionamento:

![video](automacao.mp4)
[dirChromedriver]: src/test/resources/chromedriver
[chromedriver]: https://chromedriver.chromium.org/downloads
[intelliJ]: https://www.jetbrains.com/pt-br/idea/download/#section=windows
[eclipse]: https://www.eclipse.org/downloads/
[vscode]: https://code.visualstudio.com/download
[java]: https://www.oracle.com/java/technologies/downloads/#java8
[maven]: https://maven.apache.org/download.cgi
[site]: src/test/resources/site
[foradacaixa]: https://automacaoforadacaixa.wordpress.com/2017/05/01/1-configuracao-ambiente-selenium-e-cucumber/
