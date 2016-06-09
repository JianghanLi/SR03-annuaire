use sr03p021;

create table annonce(
  id_annonce int AUTO_INCREMENT,
  categorie VARCHAR(40),
  nom VARCHAR(40),
  rue VARCHAR(255),
  ville VARCHAR(255),
  code_postale VARCHAR(12),
  telephone VARCHAR(40),
  text text,
  primary key(id_annonce)
);

insert into annonce(categorie, nom, rue, ville, code_postale, telephone, text) 
	values('emploi', 'Jianghan Li','21 rue du dépot', 'Margny-lès-Compiègne', 60280, '06 52 25 51 94', 'hello annonce');
insert into annonce(categorie, nom, rue, ville, code_postale, telephone, text) 
	values('emploi', 'Luxin ZHANG','21 rue du dépot', 'Margny-lès-Compiègne', 60280, '06 35 10 01 67 ', 'hello annonce2');
insert into annonce(categorie, nom, rue, ville, code_postale, telephone, text) 
	values('stages', 'Mengjia SUI','21 rue du dépot', 'Margny-lès-Compiègne', 60280, '06 18 54 02 26', 'hello annonce3');
insert into annonce(categorie, nom, rue, ville, code_postale, telephone, text) 
	values('auto', 'Zei ZHANG','21 rue du dépot', 'Margny-lès-Compiègne', 60280, '+8615810953708', 'hello annonce4');
insert into annonce(categorie, nom, rue, ville, code_postale, telephone, text) 
	values('immobilier', 'Zei SUI','Xibianmenwaidajie 6-3-303', 'Pékin', 100045, '+8615810953708', 'hello annonce5');

create table categorie(
  id_categorie int AUTO_INCREMENT,
  title VARCHAR(40),
  primary key(id_categorie)
);
insert into categorie(title) values('immobilier');
insert into categorie(title) values('auto');
insert into categorie(title) values('moto');
insert into categorie(title) values('emploi');
insert into categorie(title) values('stages');
insert into categorie(title) values('others');

Alter
