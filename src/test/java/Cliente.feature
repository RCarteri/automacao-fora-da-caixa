
@tag
Feature: Cadastro de clientes

    @tag1
    Scenario Outline: Inserir cliente pessoa fisica
        Given efetuei login no sistema com john e john
        And acessei o menu Clientes >> Inserir
        When na tela Dados de Identificacao informo os dados de Pessoa Fisica: <nome>, <email>, <data_nascimento>, <sexo> e <estado_civil>
        And na tela Dados de Identificacao clico em Avancar
        And na tela Enderecos informo os enderecos
        And na tela Enderecos clico em Salvar
        Then na tela Enderecos sera exibida mensagem de sucesso

        Examples:
            | nome                    | email               | data_nascimento | sexo      | estado_civil |
            | Automação fora da caixa | automacao@teste.com | 02071990        | Masculino | Solteiro     |