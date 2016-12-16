create table SAMPLE_Address (
	addressId LONG not null,
	employeeId LONG not null,
	address VARCHAR(75) null,
	contactNo INTEGER,
	primary key (addressId, employeeId)
);

create table SAMPLE_Employee (
	employeeId LONG not null primary key,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	age INTEGER
);