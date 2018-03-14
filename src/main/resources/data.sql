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

INSERT INTO Employee (version, first_name, second_name, middle_name, position, phone, address, countries_id, office_id, document_id)
   VALUES (0, 'John', 'Simonic', null, 'manager', '2525251', '2020 Main st. Sommerville NJ', 5, 1, 1);

INSERT INTO User (employee_id, version, name, login, password, role)
  VALUES (1, 0, 'Johnny', 'silent_assasin', '23rtswe5', 'admin');



