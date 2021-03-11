--Doctor
INSERT INTO doctor(
	doc_id, doc_cod, doc_nom, doc_apel, doc_espec)
	VALUES (1, 1010, 'Carlos', 'Lopez', 'ENDODONCIA');
INSERT INTO doctor(
	doc_id, doc_cod, doc_nom, doc_apel, doc_espec)
	VALUES (2, 2020, 'Maria', 'Castro', 'ORTODONCIA');
	
--Paciente
INSERT INTO paciente(
	pac_id, pac_cod, pac_nom, pac_apell, pac_edad, pac_tel)
	VALUES (1, 1010, 'David', 'Vanegas', 29, 312654664);
INSERT INTO paciente(
	pac_id, pac_cod, pac_nom, pac_apell, pac_edad, pac_tel)
	VALUES (2, 2020, 'Camila', 'Bermudez', 32, 312665464);	
	
--Factura --H2
/*
 INSERT INTO factura(
	fac_id, fac_fecha, fac_valor)
	VALUES (1, '2021-02-03', 50000);
INSERT INTO factura(
	fac_id, fac_fecha, fac_valor)
	VALUES (2, '2021-03-03', 80000);
*/
	
--Cita--H2
INSERT INTO cita(
	cit_id, cit_proced, cit_paccod, cit_doccod, cit_fecha, cit_facid)
	VALUES (1, 'ENDODONCIA', 1010, 2020, '2021-02-03', null);
	
INSERT INTO cita(
	cit_id, cit_proced, cit_paccod, cit_doccod, cit_fecha, cit_facid)
	VALUES (2, 'ORTODONCIA', 2020, 1010, '2021-04-03', null);