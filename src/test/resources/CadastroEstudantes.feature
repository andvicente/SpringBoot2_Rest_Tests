# language: pt

Funcionalidade: Cadastrar Estudantes em um Sistema.

  Contexto:
    Dado novos estudantes cadastrados

  Esquema do Cenario: Consultar Estudantes Cadastrados <idEstudante>
    Dado um estudante com <idEstudante>
    Quando eu procurar pelo estudante
    Entao o status da consulta sera <status>

  Exemplos:
  | idEstudante | status     |
  | 10001       | 200        |
  | 1           | 200        |
  | 2           | 200        |
  | 3           | 404        |

