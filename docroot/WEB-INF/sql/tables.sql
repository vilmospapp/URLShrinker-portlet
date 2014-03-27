create table Url (
	uuid_ VARCHAR(75) null,
	urlId LONG not null primary key,
	userId LONG,
	companyId LONG,
	groupId LONG,
	hash VARCHAR(75) null,
	originalUrl VARCHAR(75) null,
	privateUrl BOOLEAN,
	protectedUrl BOOLEAN,
	password_ VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null,
	archived BOOLEAN,
	customUrl BOOLEAN,
	qrcode BOOLEAN,
	statistics BOOLEAN
);

create table UrlShrinker_Url (
	uuid_ VARCHAR(75) null,
	urlId LONG not null primary key,
	userId LONG,
	companyId LONG,
	groupId LONG,
	hash VARCHAR(75) null,
	originalUrl VARCHAR(75) null,
	privateUrl BOOLEAN,
	protectedUrl BOOLEAN,
	password_ VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null,
	archived BOOLEAN,
	customUrl BOOLEAN,
	qrcode BOOLEAN,
	statistics BOOLEAN
);