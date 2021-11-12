@all
Feature: Cadastro de clientes

    @pf @regression
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
            | Automação fora da caixa | automacao@teste.com | 02/07/1990      | Masculino | Solteiro     |
            # | Automação               | autao@teste.com     | 09/07/1978      | Feminino  | Solteiro     |

    @pj @regression
    Scenario Outline: Inserir cliente Pessoa Juridica
        Given efetuei login no sistema com john e john
        And acessei o menu Clientes >> Inserir
        When na tela Dados de Identificacao informo os dados de Pessoa Juridica: <razao_social> e <email>
        And na tela Dados de Identificacao clico em Avancar
        And na tela Enderecos informo os enderecos
        And na tela Enderecos clico em Salvar
        Then na tela Enderecos sera exibida mensagem de sucesso

        Examples:
            | razao_social            | email                     |
            | Automação fora da Caixa | automacao@foradacaixa.com |
            | Automação               | automacao@foradacaixa.com |
            
    @smoke
    Scenario: Verificar se a tela de Dados de Identificação foi exibidade
        Given efetuei login no sistema com paul e paul
        And acessei o menu Clientes >> Inserir
        Then a tela de Dados de Identificação deve ser exibida na tela