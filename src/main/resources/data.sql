INSERT INTO Organization (version, name, full_name, inn, kpp, address, phone, is_active)
   VALUES (0, 'BitCom', 'BitCom Gmbh', '323342234323', '769545932', '2043 Hamburg st. Baltimore MD', '2332562', TRUE);

INSERT INTO Office (version, organization_id, name, address, phone, is_active)
   VALUES (0, 1, 'Headquorter', '2043 Hamburg st. Baltimore MD', '2332562', TRUE);

INSERT INTO Countries (version, code, name) VALUES (0, '023','Нидерланды');
INSERT INTO Countries (version, code, name) VALUES (0, '113','Папуа Новая Гвинея');
INSERT INTO Countries (version, code, name) VALUES (0, '020','Австралия');
INSERT INTO Countries (version, code, name) VALUES (0, '078','Испания');
INSERT INTO Countries (version, code, name) VALUES (0, '003','США');

INSERT INTO Doc_types (version, code, name) VALUES (0, '21','Паспорт гражданина Российской Федерации');
INSERT INTO Doc_types (version, code, name) VALUES (0, '10','Паспорт иностранного гражданина');
INSERT INTO Doc_types (version, code, name) VALUES (0, '07','Военный билет');
INSERT INTO Doc_types (version, code, name) VALUES (0, '03','Свидетельство о рождении');
INSERT INTO Doc_types (version, code, name) VALUES (0, '13','Удостоверение беженца');

INSERT INTO Document (version, doc_types_id, doc_number, doc_date, is_identified)
   VALUES (0, 1, '2354 327654', '2007-02-02', TRUE);


INSERT INTO Address (version, address, countries_id)
   VALUES(0, '3454 Main st. Sommerville NJ', 5);

INSERT INTO Employee (version, first_name, last_name, middle_name, position, phone, office_id, document_id, address_id)
   VALUES (0, 'John', 'Simonic', null, 'manager', '2525251', 1, 1, 1);

INSERT INTO User (version, name, login, password, is_active, code, role)
  VALUES (0, 'Johnny', 'silent_assasin', '23rtswe5', false, 'bas43k7nty51', 'admin');

INSERT INTO Office (version, organization_id, name, address, phone, is_active)
   VALUES (0, 1, 'Local Branch', '1122 Main st. Bangor MN', '11746532', TRUE);


