@tag
Feature: Cadastro de clientes

    @tag1
    Scenario: Inserir cliente pessoa fisica
        Given efetuei login no sistema
        And acessei o menu Clientes >> Inserir
        When na tela Dados de Identificacao informo os dados de Pessoa Fisica
        And na tela Dados de Identificacao clico em Avancar
        And na tela Enderecos informo os enderecos
        And na tela Enderecos clico em Salvar
        Then na tela Enderecos sera exibida mensagem de sucesso