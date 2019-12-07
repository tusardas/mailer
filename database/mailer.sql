create table if not exists users(
	id int(10) not null auto_increment,
	userId int(25) not null unique,
	userCategory varchar(255) not null,
	email varchar(255) not null unique,
	password varchar(500) not null,
	primary key (id, userId, email)
);

create table if not exists sender_profile (
	id int(10) not null auto_increment,
	senderId int(25) not null REFERENCES users(userId),
	host varchar(255) not null,
	username varchar(255) not null,
	password varchar(255) not null,
	port varchar(10) not null,
	protocol varchar(10) not null,
	preferredName varchar(255),
	primary key (id, senderId)
);
	
create table if not exists contacts(
	id int(10) not null auto_increment,
	contactId int(25) not null unique,
	uploadedBy int(25) not null REFERENCES users(userId),
	emailAddress varchar(255) not null,
	firstName varchar(255),
	lastName varchar(255),
	gender varchar(255),
	primary key (id, contactId)
);
	
create table if not exists campaigns(
	id int(10) not null auto_increment,
	campaignId int(25) not null unique,
	createdBy int(25) not null REFERENCES users(userId),
	campaignName varchar(255) not null,
	subject varchar(500),
	body text,
	modifiedOn TIMESTAMP,
	triggeredOn date,
	numberOfTargets int(10),
	primary key (id, campaignId)
);

insert into users(userId, userCategory, email, password) values(
	0,
	'o',
	'admin@mailer.org',
	'-41-11-1098527-2536-54-88-6037-81-5-942818'
);