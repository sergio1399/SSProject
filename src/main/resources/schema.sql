CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    name       VARCHAR(50) NOT NULL,
    full_name  VARCHAR(100) NOT NULL,
    inn        VARCHAR(12),
    kpp        VARCHAR(9),
    address    VARCHAR(50),
    phone      VARCHAR(20),
    is_active  BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    organization_id INTEGER,
    name       VARCHAR(50) NOT NULL,
    address    VARCHAR(50) NOT NULL,
    phone      VARCHAR(20),
    is_active  BOOLEAN
);

CREATE TABLE IF NOT EXISTS Employee (
    id            INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER NOT NULL,
    first_name    VARCHAR(20) NOT NULL,
    last_name     VARCHAR(20) NOT NULL,
    middle_name   VARCHAR(20),
    position      VARCHAR(20),
    phone         VARCHAR(20),
    office_id     INTEGER,
    document_id   INTEGER,
    address_id    INTEGER
);

CREATE TABLE IF NOT EXISTS Address (
    id            INTEGER  PRIMARY KEY AUTO_INCREMENT,
    address       VARCHAR(80) NOT NULL,
    countries_id  INTEGER
);

CREATE TABLE IF NOT EXISTS User (
    employee_id   INTEGER PRIMARY KEY,
    version       INTEGER NOT NULL,
    name          VARCHAR(20) NOT NULL,
    login         VARCHAR(16) UNIQUE NOT NULL,
    password      VARCHAR(16) NOT NULL,
    is_active     BOOLEAN     NOT NULL,
    code          VARCHAR(16)
    role          VARCHAR(16)
);

CREATE TABLE IF NOT EXISTS Doc_types (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version        INTEGER NOT NULL,
    code           VARCHAR(3) NOT NULL,
    name           VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS Document (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER NOT NULL,
    doc_types_id  INTEGER,
    doc_number    VARCHAR(16),
    doc_date      DATE,
    is_identified BOOLEAN
);

CREATE TABLE IF NOT EXISTS Countries (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version        INTEGER NOT NULL,
    code           VARCHAR(3) NOT NULL,
    name           VARCHAR(20) NOT NULL
);

ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);
ALTER TABLE Employee ADD FOREIGN KEY (office_id) REFERENCES Office(id);
ALTER TABLE Address ADD FOREIGN KEY (countries_id) REFERENCES Countries(id);
ALTER TABLE Employee ADD FOREIGN KEY (document_id) REFERENCES Document(id);
ALTER TABLE Employee ADD FOREIGN KEY (address_id) REFERENCES Address(id);
ALTER TABLE User ADD FOREIGN KEY (employee_id) REFERENCES Employee(id);
ALTER TABLE Document ADD FOREIGN KEY(doc_types_id) REFERENCES Doc_types(id);
CREATE INDEX IX_Office_Org_Id ON Office (organization_id);
CREATE INDEX IX_Employee_Office_Id ON Employee (office_id);
CREATE INDEX IX_Address_Countries_Id ON Address (countries_id);
CREATE INDEX IX_Employee_Document_Id ON Employee (document_id);
CREATE INDEX IX_Employee_Address_Id ON Employee (address_id);
CREATE INDEX IX_User_Employee_Id ON User (employee_id);
CREATE INDEX IX_Document_Doc_types_Id ON Document (doc_types_id);