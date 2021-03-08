--Doctor
INSERT INTO doctor(
	doc_id, doc_cod, doc_nom, doc_apel, doc_espec)
	VALUES (1, 1010, 'Carlos', 'Lopez', 'Endodoncia');
INSERT INTO doctor(
	doc_id, doc_cod, doc_nom, doc_apel, doc_espec)
	VALUES (2, 2020, 'Maria', 'Castro', 'Ortodoncia');
	
--Paciente
INSERT INTO paciente(
	pac_id, pac_cod, pac_nom, pac_apell, pac_edad, pac_tel)
	VALUES (1, 1010, 'David', 'Vanegas', 29, 312654664);
INSERT INTO paciente(
	pac_id, pac_cod, pac_nom, pac_apell, pac_edad, pac_tel)
	VALUES (2, 2020, 'Camila', 'Bermudez', 32, 312665464);	
	
--Factura
INSERT INTO factura(
	fac_id, fac_fecha, fac_valor)
	VALUES (1, '02/03/2021', 50000);
INSERT INTO factura(
	fac_id, fac_fecha, fac_valor)
	VALUES (2, '03/03/2021', 80000);
	
--Cita
INSERT INTO cita(
	cit_id, cit_proced, cit_paccod, cit_doccod, cit_fecha, cit_facid)
	VALUES (1, 'Endodoncia', 1010, 2020, '02/03/2021', null);
	
INSERT INTO cita(
	cit_id, cit_proced, cit_paccod, cit_doccod, cit_fecha, cit_facid)
	VALUES (2, 'Ortodoncia', 2020, 1010, '04/03/2021', null);