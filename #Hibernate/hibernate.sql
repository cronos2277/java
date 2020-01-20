--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-01-20 11:18:48

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 204 (class 1259 OID 24610)
-- Name: alunos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.alunos (
    alu_nome character varying(40),
    alu_cidade character varying(30),
    alu_fone character varying(30),
    alu_codigo integer NOT NULL
);


ALTER TABLE public.alunos OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24599)
-- Name: dados; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dados (
    id integer NOT NULL,
    data json
);


ALTER TABLE public.dados OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24597)
-- Name: dados_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dados_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dados_id_seq OWNER TO postgres;

--
-- TOC entry 2829 (class 0 OID 0)
-- Dependencies: 202
-- Name: dados_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dados_id_seq OWNED BY public.dados.id;


--
-- TOC entry 2692 (class 2604 OID 24602)
-- Name: dados id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dados ALTER COLUMN id SET DEFAULT nextval('public.dados_id_seq'::regclass);


--
-- TOC entry 2823 (class 0 OID 24610)
-- Dependencies: 204
-- Data for Name: alunos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.alunos (alu_nome, alu_cidade, alu_fone, alu_codigo) FROM stdin;
Neiri	Carazinho	04143394823	1
Julia	Ponta Grossa	2349085903453	3
Paulo	Curitiba	34535345435	4
Lucas	Manaus	345345345345	5
Maria	Hortensia	353534535354545	6
Rosy	Castro	123456	7
Ana	Joinville	4390890458904	8
Luiza	Fortaleza	56456456456	9
Flavia	Guarulhos	43534543543545	10
Caroline	Laranjeiras	343434343434343434	11
Mariane	Florianópolis	324234234343434	12
Marines	Porto Velho	34534534534545	13
Jonas Paulo	Guaratuba	3453535345345	2
\.


--
-- TOC entry 2822 (class 0 OID 24599)
-- Dependencies: 203
-- Data for Name: dados; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dados (id, data) FROM stdin;
\.


--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 202
-- Name: dados_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dados_id_seq', 1, false);


--
-- TOC entry 2694 (class 2606 OID 24607)
-- Name: dados dados_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dados
    ADD CONSTRAINT dados_pkey PRIMARY KEY (id);


-- Completed on 2020-01-20 11:18:48

--
-- PostgreSQL database dump complete
--

