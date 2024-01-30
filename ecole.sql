--
-- PostgreSQL database dump
--

-- Started on 2009-05-19 07:01:25

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 293 (class 1247 OID 16469)
-- Dependencies: 6 1493
-- Name: frame; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE frame AS (
	level integer,
	targetname text,
	func oid,
	linenumber integer,
	args text
);


--
-- TOC entry 303 (class 1247 OID 16484)
-- Dependencies: 6 1498
-- Name: proxyinfo; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE proxyinfo AS (
	serverversionstr text,
	serverversionnum integer,
	proxyapiver integer,
	serverprocessid integer
);


--
-- TOC entry 305 (class 1247 OID 16487)
-- Dependencies: 6 1499
-- Name: targetinfo; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE targetinfo AS (
	target oid,
	schema oid,
	nargs integer,
	argtypes oidvector,
	targetname name,
	argmodes "char"[],
	argnames text[],
	targetlang oid,
	fqname text,
	returnsset boolean,
	returntype oid
);


--
-- TOC entry 307 (class 1247 OID 16490)
-- Dependencies: 6 1500
-- Name: var; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE var AS (
	name text,
	varclass character(1),
	linenumber integer,
	isunique boolean,
	isconst boolean,
	isnotnull boolean,
	dtype oid,
	value text
);


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1491 (class 1259 OID 16461)
-- Dependencies: 6
-- Name: classe; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE classe (
    cls_id integer NOT NULL,
    cls_nom character varying(64) NOT NULL
);


--
-- TOC entry 1813 (class 0 OID 0)
-- Dependencies: 1491
-- Name: TABLE classe; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE classe IS 'Table contenant les classes de  l''école';


--
-- TOC entry 1501 (class 1259 OID 16491)
-- Dependencies: 1491 6
-- Name: classe_cls_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE classe_cls_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1814 (class 0 OID 0)
-- Dependencies: 1501
-- Name: classe_cls_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE classe_cls_id_seq OWNED BY classe.cls_id;


--
-- TOC entry 1815 (class 0 OID 0)
-- Dependencies: 1501
-- Name: classe_cls_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('classe_cls_id_seq', 12, true);


--
-- TOC entry 1492 (class 1259 OID 16464)
-- Dependencies: 6
-- Name: eleve; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE eleve (
    elv_id integer NOT NULL,
    elv_nom character varying(64) NOT NULL,
    elv_prenom character varying(64) NOT NULL,
    elv_cls_k bigint NOT NULL
);


--
-- TOC entry 1816 (class 0 OID 0)
-- Dependencies: 1492
-- Name: TABLE eleve; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE eleve IS 'Table contenant les élèves';


--
-- TOC entry 1502 (class 1259 OID 16493)
-- Dependencies: 1492 6
-- Name: eleve_elv_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE eleve_elv_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1817 (class 0 OID 0)
-- Dependencies: 1502
-- Name: eleve_elv_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE eleve_elv_id_seq OWNED BY eleve.elv_id;


--
-- TOC entry 1818 (class 0 OID 0)
-- Dependencies: 1502
-- Name: eleve_elv_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('eleve_elv_id_seq', 32, true);


--
-- TOC entry 1494 (class 1259 OID 16470)
-- Dependencies: 6
-- Name: j_cls_jmp; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE j_cls_jmp (
    jcm_id integer NOT NULL,
    jcm_cls_k bigint NOT NULL,
    jcm_jmp_k bigint NOT NULL
);


--
-- TOC entry 1819 (class 0 OID 0)
-- Dependencies: 1494
-- Name: TABLE j_cls_jmp; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE j_cls_jmp IS 'Table faisant le lien entre les classes et les liens professeurs-matières';


--
-- TOC entry 1503 (class 1259 OID 16495)
-- Dependencies: 6 1494
-- Name: j_cls_jmp_jcm_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE j_cls_jmp_jcm_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1820 (class 0 OID 0)
-- Dependencies: 1503
-- Name: j_cls_jmp_jcm_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE j_cls_jmp_jcm_id_seq OWNED BY j_cls_jmp.jcm_id;


--
-- TOC entry 1821 (class 0 OID 0)
-- Dependencies: 1503
-- Name: j_cls_jmp_jcm_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('j_cls_jmp_jcm_id_seq', 75, true);


--
-- TOC entry 1495 (class 1259 OID 16473)
-- Dependencies: 6
-- Name: j_mat_prof; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE j_mat_prof (
    jmp_id integer NOT NULL,
    jmp_mat_k bigint NOT NULL,
    jmp_prof_k bigint NOT NULL
);


--
-- TOC entry 1822 (class 0 OID 0)
-- Dependencies: 1495
-- Name: TABLE j_mat_prof; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE j_mat_prof IS 'Table faisant le lien entre les professeurs et les matières
';


--
-- TOC entry 1504 (class 1259 OID 16497)
-- Dependencies: 1495 6
-- Name: j_mat_prof_jmp_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE j_mat_prof_jmp_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1823 (class 0 OID 0)
-- Dependencies: 1504
-- Name: j_mat_prof_jmp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE j_mat_prof_jmp_id_seq OWNED BY j_mat_prof.jmp_id;


--
-- TOC entry 1824 (class 0 OID 0)
-- Dependencies: 1504
-- Name: j_mat_prof_jmp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('j_mat_prof_jmp_id_seq', 18, true);


--
-- TOC entry 1496 (class 1259 OID 16476)
-- Dependencies: 6
-- Name: matiere; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE matiere (
    mat_id integer NOT NULL,
    mat_nom character varying(64) NOT NULL
);


--
-- TOC entry 1825 (class 0 OID 0)
-- Dependencies: 1496
-- Name: TABLE matiere; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE matiere IS 'Table référençant les matières';


--
-- TOC entry 1505 (class 1259 OID 16499)
-- Dependencies: 6 1496
-- Name: matiere_mat_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE matiere_mat_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1826 (class 0 OID 0)
-- Dependencies: 1505
-- Name: matiere_mat_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE matiere_mat_id_seq OWNED BY matiere.mat_id;


--
-- TOC entry 1827 (class 0 OID 0)
-- Dependencies: 1505
-- Name: matiere_mat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('matiere_mat_id_seq', 6, true);


--
-- TOC entry 1497 (class 1259 OID 16479)
-- Dependencies: 6
-- Name: professeur; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE professeur (
    prof_id integer NOT NULL,
    prof_nom character varying(64) NOT NULL,
    prof_prenom character varying(64) NOT NULL
);


--
-- TOC entry 1828 (class 0 OID 0)
-- Dependencies: 1497
-- Name: TABLE professeur; Type: COMMENT; Schema: public; Owner: -
--

COMMENT ON TABLE professeur IS 'Tables contenant la liste des professeurs';


--
-- TOC entry 1506 (class 1259 OID 16501)
-- Dependencies: 6 1497
-- Name: professeur_prof_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE professeur_prof_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1829 (class 0 OID 0)
-- Dependencies: 1506
-- Name: professeur_prof_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE professeur_prof_id_seq OWNED BY professeur.prof_id;


--
-- TOC entry 1830 (class 0 OID 0)
-- Dependencies: 1506
-- Name: professeur_prof_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('professeur_prof_id_seq', 8, true);


--
-- TOC entry 1507 (class 1259 OID 16503)
-- Dependencies: 6
-- Name: s_classe; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE s_classe
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1831 (class 0 OID 0)
-- Dependencies: 1507
-- Name: s_classe; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('s_classe', 0, false);


--
-- TOC entry 1508 (class 1259 OID 16505)
-- Dependencies: 6
-- Name: s_eleve; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE s_eleve
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1832 (class 0 OID 0)
-- Dependencies: 1508
-- Name: s_eleve; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('s_eleve', 0, false);


--
-- TOC entry 1509 (class 1259 OID 16507)
-- Dependencies: 6
-- Name: s_matiere; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE s_matiere
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1833 (class 0 OID 0)
-- Dependencies: 1509
-- Name: s_matiere; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('s_matiere', 0, false);


--
-- TOC entry 1510 (class 1259 OID 16509)
-- Dependencies: 6
-- Name: s_professeur; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE s_professeur
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1834 (class 0 OID 0)
-- Dependencies: 1510
-- Name: s_professeur; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('s_professeur', 0, false);


--
-- TOC entry 1777 (class 2604 OID 16511)
-- Dependencies: 1501 1491
-- Name: cls_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE classe ALTER COLUMN cls_id SET DEFAULT nextval('classe_cls_id_seq'::regclass);


--
-- TOC entry 1778 (class 2604 OID 16512)
-- Dependencies: 1502 1492
-- Name: elv_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE eleve ALTER COLUMN elv_id SET DEFAULT nextval('eleve_elv_id_seq'::regclass);


--
-- TOC entry 1779 (class 2604 OID 16513)
-- Dependencies: 1503 1494
-- Name: jcm_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE j_cls_jmp ALTER COLUMN jcm_id SET DEFAULT nextval('j_cls_jmp_jcm_id_seq'::regclass);


--
-- TOC entry 1780 (class 2604 OID 16514)
-- Dependencies: 1504 1495
-- Name: jmp_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE j_mat_prof ALTER COLUMN jmp_id SET DEFAULT nextval('j_mat_prof_jmp_id_seq'::regclass);


--
-- TOC entry 1781 (class 2604 OID 16515)
-- Dependencies: 1505 1496
-- Name: mat_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE matiere ALTER COLUMN mat_id SET DEFAULT nextval('matiere_mat_id_seq'::regclass);


--
-- TOC entry 1782 (class 2604 OID 16516)
-- Dependencies: 1506 1497
-- Name: prof_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE professeur ALTER COLUMN prof_id SET DEFAULT nextval('professeur_prof_id_seq'::regclass);


--
-- TOC entry 1802 (class 0 OID 16461)
-- Dependencies: 1491
-- Data for Name: classe; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO classe (cls_id, cls_nom) VALUES (1, '6° A');
INSERT INTO classe (cls_id, cls_nom) VALUES (2, '6° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (3, '6° C');
INSERT INTO classe (cls_id, cls_nom) VALUES (4, '5 ° A');
INSERT INTO classe (cls_id, cls_nom) VALUES (5, '5° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (6, '5°C');
INSERT INTO classe (cls_id, cls_nom) VALUES (7, '4°A');
INSERT INTO classe (cls_id, cls_nom) VALUES (8, '4° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (9, '4° C');
INSERT INTO classe (cls_id, cls_nom) VALUES (10, '3° A');
INSERT INTO classe (cls_id, cls_nom) VALUES (11, '3° B');
INSERT INTO classe (cls_id, cls_nom) VALUES (12, '3° C');


--
-- TOC entry 1803 (class 0 OID 16464)
-- Dependencies: 1492
-- Data for Name: eleve; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (1, 'HERBY', 'Cyrille', 1);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (2, 'COURTEL ', 'Angelo', 1);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (3, 'PITON ', 'Thomas', 1);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (4, 'COQUILLE', 'Olivier', 2);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (5, 'SALMON', 'Dylan', 2);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (6, 'MERLET', 'Benoit', 3);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (7, 'LE GALL', 'Yann', 3);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (8, 'LE GALL', 'Morgane', 4);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (9, 'LIGERON', 'Yanninck', 4);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (10, 'LIGERON ', 'Didier', 4);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (11, 'MARLEY', 'Bob', 5);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (12, 'MAHE', 'Marie', 5);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (13, 'PICARD', 'Séverine', 6);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (14, 'PICARD', 'Manuela', 6);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (15, 'BOTTE', 'Jérôme', 6);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (16, 'CARDON', 'Mathieu', 7);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (17, 'MARDET', 'Cécile', 7);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (18, 'BUBUTE', 'Armel', 7);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (19, 'MANIQUE', 'Pascal', 8);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (20, 'ALTE', 'Paul', 8);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (21, 'CORLOT', 'Amandine', 8);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (22, 'KIBOU', 'Bahija', 9);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (23, 'MADI', 'Feti', 9);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (24, 'KERGOULET', 'Erwan', 9);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (25, 'FERNAT', 'Fernand', 10);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (26, 'JOUBERT', 'Aline', 10);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (27, 'TARTUFE', 'Thérèse', 10);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (28, 'MONIN', 'Gérald', 11);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (29, 'DROUIN', 'Albert', 11);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (30, 'NAEMI', 'Toufic', 11);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (31, 'NILBE', 'Nadia', 12);
INSERT INTO eleve (elv_id, elv_nom, elv_prenom, elv_cls_k) VALUES (32, 'VIVOT', 'Valérie', 12);


--
-- TOC entry 1804 (class 0 OID 16470)
-- Dependencies: 1494
-- Data for Name: j_cls_jmp; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (1, 1, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (2, 1, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (3, 1, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (4, 1, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (5, 2, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (6, 2, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (7, 2, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (8, 2, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (9, 3, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (10, 3, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (11, 3, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (12, 3, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (13, 4, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (14, 4, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (15, 4, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (16, 4, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (19, 4, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (20, 5, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (23, 5, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (24, 5, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (25, 5, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (26, 6, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (27, 6, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (28, 6, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (29, 6, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (30, 7, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (31, 7, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (32, 7, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (33, 7, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (34, 8, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (35, 8, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (36, 8, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (37, 8, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (38, 9, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (39, 9, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (40, 9, 7);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (41, 9, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (42, 10, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (43, 10, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (44, 10, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (45, 10, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (46, 11, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (47, 11, 2);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (48, 11, 5);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (51, 11, 8);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (52, 12, 4);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (53, 12, 6);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (54, 12, 3);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (58, 12, 1);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (61, 1, 11);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (62, 1, 12);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (63, 2, 13);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (64, 2, 14);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (65, 3, 11);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (66, 3, 12);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (67, 4, 13);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (68, 4, 14);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (69, 5, 11);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (70, 6, 12);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (71, 7, 13);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (72, 8, 14);
INSERT INTO j_cls_jmp (jcm_id, jcm_cls_k, jcm_jmp_k) VALUES (75, 7, 12);


--
-- TOC entry 1805 (class 0 OID 16473)
-- Dependencies: 1495
-- Data for Name: j_mat_prof; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (1, 1, 1);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (2, 1, 2);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (3, 2, 3);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (4, 2, 4);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (5, 3, 5);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (6, 3, 6);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (7, 4, 7);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (8, 4, 8);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (11, 5, 1);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (12, 5, 2);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (13, 6, 3);
INSERT INTO j_mat_prof (jmp_id, jmp_mat_k, jmp_prof_k) VALUES (14, 6, 4);


--
-- TOC entry 1806 (class 0 OID 16476)
-- Dependencies: 1496
-- Data for Name: matiere; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO matiere (mat_id, mat_nom) VALUES (1, 'Mathématiques');
INSERT INTO matiere (mat_id, mat_nom) VALUES (2, 'Français');
INSERT INTO matiere (mat_id, mat_nom) VALUES (3, 'Anglais');
INSERT INTO matiere (mat_id, mat_nom) VALUES (4, 'Physique');
INSERT INTO matiere (mat_id, mat_nom) VALUES (5, 'Biologie');
INSERT INTO matiere (mat_id, mat_nom) VALUES (6, 'Sport');


--
-- TOC entry 1807 (class 0 OID 16479)
-- Dependencies: 1497
-- Data for Name: professeur; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (1, 'MAMOU', 'Daniel');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (2, 'SACRE', 'Sophie');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (3, 'JADEN', 'Boudy');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (4, 'BADEN', 'Baden');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (5, 'MIOU', 'Miou');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (6, 'BORA', 'Kernel');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (7, 'CAISSE', 'Jean');
INSERT INTO professeur (prof_id, prof_nom, prof_prenom) VALUES (8, 'MOISSAT', 'Marc');


--
-- TOC entry 1784 (class 2606 OID 16518)
-- Dependencies: 1491 1491
-- Name: clé primaire; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY classe
    ADD CONSTRAINT "clé primaire" PRIMARY KEY (cls_id);


--
-- TOC entry 1786 (class 2606 OID 16520)
-- Dependencies: 1492 1492
-- Name: eleve_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY eleve
    ADD CONSTRAINT eleve_pkey PRIMARY KEY (elv_id);


--
-- TOC entry 1788 (class 2606 OID 16522)
-- Dependencies: 1494 1494
-- Name: j_cls_jmp_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY j_cls_jmp
    ADD CONSTRAINT j_cls_jmp_pkey PRIMARY KEY (jcm_id);


--
-- TOC entry 1790 (class 2606 OID 16524)
-- Dependencies: 1495 1495 1495
-- Name: j_mat_prof_jmp_mat_k_key; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY j_mat_prof
    ADD CONSTRAINT j_mat_prof_jmp_mat_k_key UNIQUE (jmp_mat_k, jmp_prof_k);


--
-- TOC entry 1792 (class 2606 OID 16526)
-- Dependencies: 1495 1495
-- Name: j_mat_prof_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY j_mat_prof
    ADD CONSTRAINT j_mat_prof_pkey PRIMARY KEY (jmp_id);


--
-- TOC entry 1794 (class 2606 OID 16528)
-- Dependencies: 1496 1496
-- Name: matiere_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY matiere
    ADD CONSTRAINT matiere_pkey PRIMARY KEY (mat_id);


--
-- TOC entry 1796 (class 2606 OID 16530)
-- Dependencies: 1497 1497
-- Name: professeur_pkey; Type: CONSTRAINT; Schema: public; Owner: -; Tablespace: 
--

ALTER TABLE ONLY professeur
    ADD CONSTRAINT professeur_pkey PRIMARY KEY (prof_id);


--
-- TOC entry 1797 (class 2606 OID 16531)
-- Dependencies: 1491 1492 1783
-- Name: eleve_elv_cls_k_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY eleve
    ADD CONSTRAINT eleve_elv_cls_k_fkey FOREIGN KEY (elv_cls_k) REFERENCES classe(cls_id);


--
-- TOC entry 1798 (class 2606 OID 16536)
-- Dependencies: 1783 1494 1491
-- Name: j_cls_jmp_jcm_cls_k_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY j_cls_jmp
    ADD CONSTRAINT j_cls_jmp_jcm_cls_k_fkey FOREIGN KEY (jcm_cls_k) REFERENCES classe(cls_id);


--
-- TOC entry 1799 (class 2606 OID 16541)
-- Dependencies: 1494 1791 1495
-- Name: j_cls_jmp_jcm_jmp_k_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY j_cls_jmp
    ADD CONSTRAINT j_cls_jmp_jcm_jmp_k_fkey FOREIGN KEY (jcm_jmp_k) REFERENCES j_mat_prof(jmp_id);


--
-- TOC entry 1800 (class 2606 OID 16546)
-- Dependencies: 1495 1496 1793
-- Name: j_mat_prof_jmp_mat_k_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY j_mat_prof
    ADD CONSTRAINT j_mat_prof_jmp_mat_k_fkey FOREIGN KEY (jmp_mat_k) REFERENCES matiere(mat_id);


--
-- TOC entry 1801 (class 2606 OID 16551)
-- Dependencies: 1795 1495 1497
-- Name: j_mat_prof_jmp_prof_k_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY j_mat_prof
    ADD CONSTRAINT j_mat_prof_jmp_prof_k_fkey FOREIGN KEY (jmp_prof_k) REFERENCES professeur(prof_id);


--
-- TOC entry 1812 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2009-05-19 07:01:26

--
-- PostgreSQL database dump complete
--