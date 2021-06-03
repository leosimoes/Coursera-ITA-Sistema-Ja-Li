CREATE USER IF NOT EXISTS "LEO" SALT '4f5693c0b98543a0' HASH 'c5dc752a02416a3d6f4eb37deee1fdea2da1c904c6cf14f96430f467c464f75b' ADMIN;
CREATE SEQUENCE "PUBLIC"."HIBERNATE_SEQUENCE" START WITH 1;
CREATE MEMORY TABLE "PUBLIC"."LEITOR"(
    "LEITOR_ID" BIGINT NOT NULL,
    "LOGIN" VARCHAR(255),
    "NOME" VARCHAR(255),
    "PONTOS" INTEGER,
    "ROLE" VARCHAR(255),
    "SENHA" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."LEITOR" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("LEITOR_ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.LEITOR;
CREATE MEMORY TABLE "PUBLIC"."LEITOR_LIVROS"(
    "LEITOR_ID" BIGINT NOT NULL,
    "LIVRO_ID" BIGINT NOT NULL
);
ALTER TABLE "PUBLIC"."LEITOR_LIVROS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A" PRIMARY KEY("LEITOR_ID", "LIVRO_ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.LEITOR_LIVROS;
CREATE MEMORY TABLE "PUBLIC"."LEITOR_TROFEUS"(
    "LEITOR_LEITOR_ID" BIGINT NOT NULL,
    "TROFEUS" VARCHAR(255)
);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.LEITOR_TROFEUS;
CREATE MEMORY TABLE "PUBLIC"."LIVROS"(
    "LIVRO_ID" BIGINT NOT NULL,
    "ESTILO" VARCHAR(255),
    "NOMESAUTORES" VARCHAR(255),
    "NUMEROPAGINAS" INTEGER,
    "TITULO" VARCHAR(255)
);
ALTER TABLE "PUBLIC"."LIVROS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_85" PRIMARY KEY("LIVRO_ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.LIVROS;
ALTER TABLE "PUBLIC"."LEITOR_LIVROS" ADD CONSTRAINT "PUBLIC"."FK81MSPYBW3113L4TJRKVR537SG" FOREIGN KEY("LIVRO_ID") REFERENCES "PUBLIC"."LIVROS"("LIVRO_ID") NOCHECK;
ALTER TABLE "PUBLIC"."LEITOR_LIVROS" ADD CONSTRAINT "PUBLIC"."FK9OLN8RWJPYTWUCYOR116G6H1Q" FOREIGN KEY("LEITOR_ID") REFERENCES "PUBLIC"."LEITOR"("LEITOR_ID") NOCHECK;
ALTER TABLE "PUBLIC"."LEITOR_TROFEUS" ADD CONSTRAINT "PUBLIC"."FKCCOM9B9SYMUTX6IPXR6QW0DNI" FOREIGN KEY("LEITOR_LEITOR_ID") REFERENCES "PUBLIC"."LEITOR"("LEITOR_ID") NOCHECK;