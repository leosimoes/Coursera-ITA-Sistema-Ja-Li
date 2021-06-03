
-- Preenchendo tabela de leitores
    -- obs.: "senha"  encriptada equivale a: "$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe"

INSERT INTO LEITOR(LEITOR_ID, SENHA, LOGIN, NOME, PONTOS, ROLE) VALUES
(1, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'admin', 'admin', 0, 'ROLE_ADMIN'),
(2, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'leo', 'Leonardo', 100, 'ROLE_USER'),
(3, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login1', 'Eduardo', 25, 'ROLE_USER'),
(4, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login2', 'Clovis', 16, 'ROLE_USER'),
(5, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login3', 'João', 17, 'ROLE_USER'),
(6, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login4', 'Maria', 18, 'ROLE_USER'),
(7, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login5', 'Sara', 19, 'ROLE_USER'),
(8, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login6', 'Carol', 20, 'ROLE_USER'),
(9, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login7', 'Carlos', 21, 'ROLE_USER'),
(10, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login8', 'Leandro', 22, 'ROLE_USER'),
(11, '$2a$10$oCQnj1zypbxeZox66RcTrOEmtkedkSaJnUQyuCwtxrGZSvN1EndCe', 'login9', 'Lucas', 25, 'ROLE_USER');

-- Preenchendo tabela de livros
INSERT INTO LIVROS (LIVRO_ID, TITULO, NOMESAUTORES, NUMEROPAGINAS, ESTILO) VALUES
  (1, 'Código Limpo', 'Tio Bob', 500, 'Computação'),
  (2, 'Códificador Limpo', 'Tio Bob', 500, 'Computação'),
  (3, 'Arquitetura Limpa', 'Tio Bob', 500, 'Computação'),
  (4, 'Titulo', 'Autores', 50, 'Estilo livre');

-- Leitor livros
INSERT INTO LEITOR_LIVROS(LEITOR_ID, LIVRO_ID) VALUES
    (1, 1), (1,2), (1,3), (2,4);


