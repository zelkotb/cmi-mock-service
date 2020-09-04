insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('INWI', '0001', 'INWI Recharge', 'http://localhost:8080/inwi-logo.jpg','https://inwi.com','2');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Recharge Téléphonique',true,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de ligne à recharger','text','chaine',4,15,1);
insert into form_field (field_name, field_type, list_vals, field_format, min_size, max_size, contrainte) values ('Montant','select','10;20;30;40;50;100;150;300;500','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (1,1),(1,2);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('ORANGE', '0002', 'Orange Recharge', 'http://localhost:8080/orange-logo.png','https://orange.com','2');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Recharge Téléphonique',true,2);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de ligne à recharger','text','chaine',4,15,1);
insert into form_field (field_name, field_type, list_vals, field_format, min_size, max_size, contrainte) values ('Montant','select','10;20;25;30;45;50;100;150;300;500','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (2,3),(2,4);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('MAROC TELECOM', '0003', 'IAM Recharge', 'http://localhost:8080/maroc-telecom-logo.jpg','https://maroctelecom.com','2');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Recharge Téléphonique',false,3);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de ligne à recharger','text','chaine',4,15,1);
insert into form_field (field_name, field_type, list_vals, field_format, min_size, max_size, contrainte) values ('Montant','select','10;20;25;30;45;50;100;150;300;500','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (3,5),(3,6);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('MAROC TELECOM', '0004', 'IAM Facture', 'http://localhost:8080/maroc-telecom-logo.jpg','https://maroctelecom.com','2');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Facture Fixe',true,4);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de téléphone Fixe','text','chaine',4,15,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Code Confidentiel','text','chaine',5,5,1);
insert into debt_form_fields (debt_id, form_fields_id) values (4,7),(4,8);
insert into debt (debt_code, debt_name, active, biller_id) values ('02','Facture Mobile',true,4);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de téléphone Mobile','text','chaine',4,15,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Code Fidélio','text','chaine',5,5,1);
insert into debt_form_fields (debt_id, form_fields_id) values (5,9),(5,10);
insert into debt (debt_code, debt_name, active, biller_id) values ('03','Facture Internet',true,4);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Identifiant de Paiement','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (6,11);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('ORANGE', '0005', 'ORANGE Facture', 'http://localhost:8080/orange-logo.png','https://orange.com','2');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Facture Particuliers',true,5);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de Ligne','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (7,12);
insert into debt (debt_code, debt_name, active, biller_id) values ('02','Facture Entreprises',true,5);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('RC','text','chaine',4,15,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('CIN','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (8,13),(8,14);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('REDAL', '0006', 'Paiement de Facture', 'http://localhost:8080/redal_logo.jpg','https://redal.com','1');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Facture REDAL',true,6);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('CIL','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (9,15);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('ONEE', '0007', 'ONEE Branche éléctricité', 'http://localhost:8080/onee-logo.png','https://onee.com','1');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Paiement par Contrat',true,7);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de Contrat','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (10,16);
insert into debt (debt_code, debt_name, active, biller_id) values ('02','Paiement par Facture',true,7);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Numéro de Facture','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (11,17);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('DGI', '0008', 'Paiement Impots', 'http://localhost:8080/dgi-logo.jpg','https://dgi.com','4');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Frais Immatriculation',true,8);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Référence de paiment','text','chaine',4,15,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Montant avant la virgule','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (12,18),(12,19);
insert into debt (debt_code, debt_name, active, biller_id) values ('02','DGI E-TIMBRE',true,8);
insert into form_field (field_name, field_type, list_vals, field_format, min_size, max_size, contrainte) values ('Rechercher par','select','Référence E-Timbre','chaine',4,15,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Référence E-Timbre','text','chaine',4,15,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Montant','text','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (13,20),(13,21),(13,22);

insert into biller (biller_name, biller_code, biller_description, logo_path, website, category) values ('RAM', '0009', 'Achat Ticket Avion', 'http://localhost:8080/ram-logo.png','https://ram.com','3');
insert into debt (debt_code, debt_name, active, biller_id) values ('01','Billets Avion',true,9);
insert into form_field (libelle, field_type, field_format, min_size, max_size, contrainte) values ('pour récuperer le référence veuillez contacter CRC Fatourati','libelle','chaine',4,15,1);
insert into form_field (field_name, field_type, field_format, min_size, max_size, contrainte) values ('Référence Fatourati','text','chaine',4,15,1);
insert into form_field (field_name, field_type, list_vals, field_format, min_size, max_size, contrainte) values ('Type de Vole','checkbox','Aller-Retour VIP;Aller-Retour SIMPLE;Aller-VIP','chaine',4,15,1);
insert into debt_form_fields (debt_id, form_fields_id) values (14,23),(14,24),(14,25);

insert into debt_canal (debt, canal) values (1,'1'),(1,'2'),(1,'3'),(1,'4');
insert into debt_canal (debt, canal) values (2,'1'),(2,'2'),(2,'3'),(2,'4');
insert into debt_canal (debt, canal) values (3,'1'),(3,'2'),(3,'3'),(3,'4');
insert into debt_canal (debt, canal) values (4,'1'),(4,'2'),(4,'3'),(4,'4');
insert into debt_canal (debt, canal) values (5,'1'),(5,'2'),(5,'3'),(5,'4');
insert into debt_canal (debt, canal) values (6,'1'),(6,'2'),(6,'3'),(6,'4');
insert into debt_canal (debt, canal) values (7,'1'),(7,'2'),(7,'3'),(7,'4');
insert into debt_canal (debt, canal) values (8,'1'),(8,'2'),(8,'3'),(8,'4');
insert into debt_canal (debt, canal) values (9,'1'),(9,'2'),(9,'3'),(9,'4');
insert into debt_canal (debt, canal) values (10,'1'),(10,'2'),(10,'3'),(10,'4');
insert into debt_canal (debt, canal) values (11,'1'),(11,'2'),(11,'3'),(11,'4');
insert into debt_canal (debt, canal) values (12,'1'),(12,'2'),(12,'3'),(12,'4');
insert into debt_canal (debt, canal) values (13,'1'),(13,'2'),(13,'3'),(13,'4');
insert into debt_canal (debt, canal) values (14,'1'),(14,'2'),(14,'3'),(14,'4');

insert into biller_canal (biller, canal) values (1,'1'),(1,'2'),(1,'3'),(1,'4');
insert into biller_canal (biller, canal) values (2,'1'),(2,'2'),(2,'3'),(2,'4');
insert into biller_canal (biller, canal) values (3,'1'),(3,'2'),(3,'3'),(3,'4');
insert into biller_canal (biller, canal) values (4,'1'),(4,'2'),(4,'3'),(4,'4');
insert into biller_canal (biller, canal) values (5,'1'),(5,'2'),(5,'3'),(5,'4');
insert into biller_canal (biller, canal) values (6,'1'),(6,'2'),(6,'3'),(6,'4');
insert into biller_canal (biller, canal) values (7,'1'),(7,'2'),(7,'3'),(7,'4');
insert into biller_canal (biller, canal) values (8,'1'),(8,'2'),(8,'3'),(8,'4');
insert into biller_canal (biller, canal) values (9,'1'),(9,'2'),(9,'3'),(9,'4');



