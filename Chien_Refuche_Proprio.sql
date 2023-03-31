
-- SELECT * FROM tep_thomas.chien;
-- SELECT * FROM tep_thomas.refuge; 
-- SELECT * FROM tep_thomas.proprio;

-- SELECT chien.Nom_Chien ,refuge.Nom_Refuge FROM Chien JOIN Refuge ON chien.ID_Refuge_Chien = refuge.ID_Refuge ;

-- SELECT * FROM tep_thomas.chien;
-- SELECT * FROM tep_thomas.refuge; 
-- SELECT * FROM tep_thomas.proprio;

-- SELECT chien.Nom_Chien ,refuge.Nom_Refuge FROM Chien JOIN Refuge ON chien.ID_Refuge_Chien = refuge.ID_Refuge ;

-- SELECT chien.sex_chien, chien.Nom_Chien ,refuge.Nom_Refuge, proprio.nom_proprio FROM Chien INNER JOIN Refuge ON Chien.ID_Refuge_chien = refuge.ID_Refuge INNER JOIN Proprio ON Chien.ID_Proprio_chien = proprio.ID_proprio;
-- SELECT * FROM chien WHERE ID_Chien = 4;

-- SELECT Nom_Refuge FROM REFUGE;
-- SELECT * FROM REFUGE;
-- DELETE FROM REFUGE WHERE ID_Refuge = 0;

-- SELECT * FROM CHIEN WHERE CONTAINS(Date_Chien, '18')

-- SELECT * FROM CHIEN WHERE Date_Chien LIKE '%2004%';
-- SELECT * FROM CHIEN WHERE Race_Chien = 'Chihuahua';
-- SELECT * FROM REFUGE;
-- SELECT * FROM PROPRIO;
-- DELETE FROM PROPRIO WHERE ID_Proprio = '4' ;


-- BASE DE DONNEE 

DROP DATABASE IF EXISTS TEP_WAM;
CREATE DATABASE TEP_WAM;
USE TEP_THOMAS;
-- ------------------------
-- ---   TABLE PROPRIO ------
-- ------------------------

CREATE TABLE PROPRIO(
	ID_Proprio int UNSIGNED NOT NULL PRIMARY KEY auto_increment,
	Nom_Proprio varchar(30) NOT NULL,
	Adresse_Proprio varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ------------------------
-- ---  TABLE REFUGE ------
-- ------------------------

CREATE TABLE REFUGE(
	ID_Refuge int UNSIGNED NOT NULL PRIMARY KEY auto_increment,
	Nom_Refuge varchar(30) NOT NULL,
	Adresse_Refuge varchar(70) NOT NULL,
	Num_Tel_Refuge varchar(13) NOT NULL,
	Place_Refuge int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ------------------------
-- ---   TABLE CHIEN ------
-- ------------------------


CREATE TABLE CHIEN(
	ID_Chien int UNSIGNED NOT NULL PRIMARY KEY auto_increment,
    -- Photo_Chien LONGBLOB DEFAULT NULL,
	Nom_Chien varchar(30) NOT NULL,
	Date_Chien date NOT NULL,
	Sex_Chien varchar(10) NOT NULL,
	Race_Chien varchar(30) NOT NULL,
	Steril_Chien boolean NOT NULL,
	Date_Entre_Chien date NOT NULL,
	Date_Sortie_Chien date DEFAULT NULL,
	ID_Proprio_Chien int UNSIGNED DEFAULT NULL,
	ID_Refuge_Chien int UNSIGNED NOT NULL
  -- FOREIGN KEY (ID_Proprio_Chien) REFERENCES PROPRIO(ID_Proprio)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO PROPRIO(ID_Proprio, Nom_Proprio, Adresse_Proprio) VALUES
(1,"Aucun", "Aucun"),
(2,"Leon S. Kenedy", "Rue du bout du monde 500");
-- (3,"Jhon Doh", "Rue de Ricoré 501");

INSERT INTO REFUGE(ID_Refuge ,Nom_Refuge, Adresse_Refuge, Num_Tel_Refuge,Place_refuge) VALUES
(1,"Sky-Dogs life","Rue de Ville 85 ,Bruxelle", "081306932",10),
(2,"Dogs Wart ","Rue de Quartier 69 ,Charleroi","081303252",14);

INSERT INTO CHIEN(ID_Chien , Nom_Chien ,Date_Chien ,Sex_Chien ,Race_Chien ,Steril_Chien ,Date_Entre_Chien ,Date_Sortie_Chien ,ID_Proprio_Chien ,ID_Refuge_Chien) VALUES 
(1,  "Nina",str_to_date('09-11-2004','%d-%m-%Y'), 'Femelle',"Chihuahua", true, str_to_date('07-08-2023','%d-%m-%Y'),null,1,'1'),
(2,  "Luna", str_to_date('05-09-2017','%d-%m-%Y'), 'Femelle',"Chihuahua", false, str_to_date('07-08-2023','%d-%m-%Y'),null,1,'1'),
(3,  "Saria", str_to_date('18-06-2017','%d-%m-%Y') , 'Femelle',"Chihuahua", false, str_to_date('07-08-2023','%d-%m-%Y'),null,1,'1');

ALTER TABLE CHIEN
ADD CONSTRAINT FK_Chien_Refuge
FOREIGN KEY (ID_Refuge_Chien)
REFERENCES REFUGE(ID_Refuge);

ALTER TABLE CHIEN
ADD CONSTRAINT FK_Chien_Proprio
FOREIGN KEY (ID_Proprio_Chien)
REFERENCES PROPRIO(ID_Proprio);
-- --------------------------------------------------

-- CREATE VIEW VueChienRefugeProprio AS
-- SELECT CHIEN.Sex_Chien, CHIEN.Nom_Chien, REFUGE.Nom_Refuge, PROPRIO.Nom_Proprio
-- FROM CHIEN
-- INNER JOIN REFUGE ON CHIEN.ID_Refuge_Chien = REFUGE.ID_Refuge
-- INNER JOIN PROPRIO ON CHIEN.ID_Proprio_Chien = PROPRIO.ID_Proprio;
