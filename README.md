# 🔑🤓👍🏾 Autentica Benezinho

|![fiap.jpg](documentacao%2Ffiap.jpg)                | **JAVA ADVANCED** |
|------------------------------------------|-------------------|
| **ALUNO:**                               | **TURMA:** 2TDSPF |
| **PROFESSOR:** Benefrancis do Nascimento | 11/03/2024        |
| **SIMULADO PARA O CP I**                 |                   |

# Sumário

[Estudo de caso ](#_Estudo_de_caso)

[O que deverá ser feito? ](#_O_que_devera_ser_feito)

[Diagrama de Classes ](#_Diagrama_de_Classes)

[Como entregar? ](#_Entrega)

[Correção ](#_Correcao)

<a id="_Estudo_de_caso"></a>

# Estudo de caso

A Holding Benezinho 🤓👍🏽 expandiu muito o seu portifólio de sistemas gerenciados, para prover maior segurança ao acesso
dos diversos sistemas da Holding, os arquitetos de software propuseram o desenvolvendo de um sistema para o
gerenciamento de permissões dos sistemas empresariais da Holding Benezinho.

Contratamos você como Engenheiro de Software para ajudar a construir esse sistema.

Na sprint atual, você foi incumbido de fazer:

1. O Mapeamento Objeto Relacional das primeiras classes envolvidas neste projeto de software;

2. A criação automatizada das tabelas no banco de dados Oracle;

3. A persistência de todos os dados, e;

4. A criação dos Seguintes Repositories :

    1. UsuarioRepository
    2. PermissaoRepository
    3. PerfilRepository
    4. SistemaRepository

5. A criação dos Seguintes Resources:

   1. PerfilResource com as seguintes ROTAS e VERBOS:
   
      1. "localhost/perfil" - **GET**;
      2. "localhost/perfil" - **POST**
      3. "logalhost/perfil/{id}" - **GET**
      4. "logalhost/perfil/{id}/permissoes" - **GET**;
      5. "logalhost/perfil/{id}/permissoes" - **POST**

   2. PermissaoResource com as seguintes ROTAS e VERBOS:
      
      1. "localhost/permissao" - **GET**;
      2. "localhost/permissao" - **POST**
      3. "logalhost/permissao/{id}" - **GET**

   3. SistemaResource com as seguintes ROTAS e VERBOS:
      
      1. "localhost/sistema" - **GET**;
      2. "localhost/sistema" - **POST**
      3. "logalhost/sistema/{id}" - **GET**
      4. "logalhost/sistema/{id}/responsaveis" - **GET**;
      5. "logalhost/sistema/{id}/responsaveis" - **POST**

   4. UsuarioResource com as seguintes ROTAS e VERBOS:
      
      1. "localhost/usuario" - **GET**;
      2. "localhost/usuario" - **POST**;
      3. "logalhost/usuario/{id}" - **GET**


<a id="_O_que_devera_ser_feito"></a>

# O que deverá ser feito?

**Você deverá:**

**Fazer o fork do projeto do github.**:

[https://github.com/Benefrancis/spring-pf-authentication](https://github.com/Benefrancis/spring-pf-authentication)

Caso o github esteja indisponível, você deverá pegar o projeto no diretório compartilhado.

Alterar o arquivo contido em  **documentacao/equipe.txt** para incluir os RMs e nomes e turma da dupla que fará esta
atividade.

**OBS:** Será com base nos nomes contidos neste aquivo que eu irei atribuir a nota.

1. **(0,5 Ponto)** acessar o arquivo **application.yml** e incluir as configurações para **persistencia** para que seja
   possível conectar-se ao banco de dados Oracle da FIAP com o seu usuário e senha (manter o seu usuário e senha ativo é
   sua responsabilidade). Não utilize o usuário e senha de outro aluno. Caso tenha problema para autenticar, comunique o
   professor.

## No pacote entity, criar as seguintes classes

1. **(1 Pontos)** Implementar e Mapear corretamente a classe **Perfil**.

2. **(0,5 Ponto)** Implementar e Mapear corretamente a classe **Permissao**.

3. **(0,5 Pontos)** Implementar e Mapear corretamente a classe **Usuario**.

4. **(0,5 Ponto)** Implementar e Mapear corretamente a classe **Pessoa**.

5. **(1 Pontos)** Implementar e Mapear corretamente a classe **Sistema**.

## No pacote repository criar as seguintes interfaces

6. **(1 Ponto)** A criação dos Seguintes Repositories :

    1. **(0,25 Ponto)** UsuarioRepository
    2. **(0,25 Ponto)** PermissaoRepository
    3. **(0,25 Ponto)** PerfilRepository
    4. **(0,25 Ponto)** SistemaRepository

7. **(0,5 Ponto)** criar um método capaz de consultar um **Usuario** pelo seu email e senha na interface UsuárioRepository;

## No pacote resources criar as seguintes classes

8. **(4,5 Pontos)**  A perfeita criação dos Seguintes Resources no pacote resources:

    1. **(1,5 Pontos)** PerfilResource com as seguintes ROTAS e VERBOS:
        1. "localhost/perfil" - **GET**;
        2. "localhost/perfil" - **POST**
        3. "logalhost/perfil/{id}" - **GET**
        4. "logalhost/perfil/{id}/permissoes" - **GET**;
        5. "logalhost/perfil/{id}/permissoes" - **POST**

    2. **(0,5 Ponto)** PermissaoResource com as seguintes ROTAS e VERBOS:
        1. "localhost/permissao" - **GET**;
        2. "localhost/permissao" - **POST**
        3. "logalhost/permissao/{id}" - **GET**

    3. **(1,5 Pontos)** SistemaResource com as seguintes ROTAS e VERBOS:
        1. "localhost/sistema" - **GET**;
        2. "localhost/sistema" - **POST**
        3. "logalhost/sistema/{id}" - **GET**
        4. "logalhost/sistema/{id}/responsaveis" - **GET**;
        5. "logalhost/sistema/{id}/responsaveis" - **POST**

    4. **(1 Ponto)** UsuarioResource com as seguintes ROTAS e VERBOS:
        1. "localhost/usuario" - **GET**;
        2. "localhost/usuario" - **POST**;
        3. "logalhost/usuario/{id}" - **GET**

<a id="_Diagrama_de_Classes"></a>

# Diagrama de Classes

![classes.png](documentacao%2Fclasses.png)

<a id="_Entrega"></a>

# Como entregar?
O aluno deverá postar no TEAMS o zip do projeto. A maneira mais segura de gerar o entregavel é: Fazer o commit e push para o github e, em seguida, acessar o projeto no seu github e fazer o download do código zipado.


<a id="_Correcao"></a>

# Correção

A correção será disponibilizada no github do professor (branch correcao):

Para acessar digite no prompt:

```shell
git clone https://github.com/Benefrancis/spring-pf-authentication.git && cd spring-pf-authentication && git checkout correcao
```

A avaliação é em **DUPLA**, em caso de fraude de qualquer tipo todos os envolvidos receberão nota ZERO.



Boa avaliação.
