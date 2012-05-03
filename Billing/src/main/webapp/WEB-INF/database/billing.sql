# billing - mysql

drop database if exists billing;
create database billing;
use billing;

drop table if exists invoice;
create table invoice
(
    invoiceNumber           int unsigned not null,
    invoiceDate			    date not null,
    terms			        enum('Net30', 'Net60', 'Net90', 'OnReceipt'),
    purpose			        varchar(20),
    purchaseOrderNum        varchar(100),
    exempt			        boolean,
    clientID			    int unsigned not null,
    clientBillingAddressID	int unsigned not null,
    datePrinted             date,
    dateCreated             date not null,
    userCreated             int unsigned not null,
    dateModified            date not null,
    userModified            int unsigned not null,
    primary key (invoiceNumber)
);

drop table if exists invoice_line_items;
create table invoice_line_items
(
    invoiceNumber           int unsigned not null,
    lineItemNumber          int unsigned not null,
    productID               varchar(200) not null,
    units                   decimal(9,2) not null,
    total                   decimal(9,2) not null,
    primary key (invoiceNumber, lineItemNumber)
);

drop table if exists product;
create table product
(
    productID               varchar(200) not null,
    parentProductID         int unsigned,
    productType             enum('Good', 'Service'),
    description             varchar(200) not null,
    price                   decimal(9,2) not null,
    taxable                 boolean,
    primary key (productID)
);

drop table if exists client;
create table client
(
       clientID             int unsigned not null,
       clientNumber         varchar(200),
       clientName           varchar(200) not null,
       creditLimit          decimal(9,2),
       billable             boolean,
       primary key (clientID)
);

drop table if exists address;
create table address
(
       addressID             int unsigned not null,
       clientID              int unsigned not null,
       address1              varchar(200),
       address2              varchar(200),
       address3              varchar(200),
       city                  varchar(200),
       state                 varchar(200),
       postalCode            varchar(10),
       country               varchar(20),
       addressType           enum('Mailing', 'Billing', 'Other'),
       primary key (addressID)
);

drop table if exists invoice_adj_amounts;
create table invoice_adj_amounts
(
    invoiceNumber           int unsigned not null,
    totalAmount             decimal(9,2),
    primary key (invoiceNumber)
);

#invoice_total_amounts
#invoice_adj_amounts

#on hand, levels, and discounts a,b,c part of inventory management system
#create table invoice_adjusted_amounts #overrideable
#(
# invoiceNumber
# lineItemAmount
#)

insert into invoice values (1525, '2005-08-19', 'Net30', '', '', 0, 0, 0, null, '2005-08-21', 0, '2005-08-21', 0);
insert into invoice values (1546, '2005-12-03', 'Net60', '', '', 0, 1, 1, null, '2005-08-21', 0, '2005-08-21', 0);

insert into invoice_line_items values (1525, 1, 'S100', 1, 15);
insert into invoice_line_items values (1525, 2, 'S101', 1, 15);
insert into invoice_line_items values (1525, 3, 'S102', 39, 780);
insert into invoice_line_items values (1525, 4, 'S103', 1, 15);

insert into invoice_line_items values (1546, 1, 'S100', 1, 15);
insert into invoice_line_items values (1546, 2, 'S101', 3, 45);

insert into invoice_adj_amounts values (1525, 825.00);
insert into invoice_adj_amounts values (1546, 60.00);

insert into product values ('S100', null, 'Service', 'Site Procurement and Hosting', 15.00, 0);
insert into product values ('S101', null, 'Service', 'Virtual Site Bannerless Hosting', 15.00, 0);
insert into product values ('S102', null, 'Service', 'Web Site Creation: General Development', 20.00, 0);
insert into product values ('S103', null, 'Service', 'Support', 15.00, 0);

insert into client values (0, '', 'Citizens for Weber', 5000.00, 1);
insert into client values (1, '', 'Friends of Kush', 5000.00, 1);
insert into client values (2, '', 'Ace Hardware, Inc.', 5000.00, 1);
insert into client values (3, '', 'SANYO Incorporated', 5000.00, 1);
insert into client values (4, '', 'Comcast Cable Corporation', 5000.00, 1);
insert into client values (5, '', 'FORD Motor Corporation', 5000.00, 1);
insert into client values (6, '', 'Scrabble Word Testers', 5000.00, 1);
insert into client values (7, '', 'Magnavox Vision Systems', 5000.00, 1);
insert into client values (8, '', 'Sun Microsystems, Inc.', 5000.00, 1);
insert into client values (9, '', 'EMS System Support', 5000.00, 1);
insert into client values (10, '', 'Motorola, Inc.', 5000.00, 1);
insert into client values (11, '', 'Microsoft, Inc.', 5000.00, 1);
insert into client values (12, '', 'Wegmans Food Markets', 5000.00, 1);
insert into client values (13, '', 'W. L. Gore', 5000.00, 1);
insert into client values (14, '', 'Republic Bancorp', 5000.00, 1);
insert into client values (15, '', 'Genentech', 5000.00, 1);
insert into client values (16, '', 'Xilinx', 5000.00, 1);
insert into client values (17, '', 'J. M. Smucker', 5000.00, 1);
insert into client values (18, '', 'S. C. Johnson & Son', 5000.00, 1);
insert into client values (19, '', 'Griffin Hospital', 5000.00, 1);
insert into client values (20, '', 'Alston & Bird', 5000.00, 1);
insert into client values (21, '', 'American Cast Iron Pipe Company', 5000.00, 1);
insert into client values (22, '', 'American Century Investments', 5000.00, 1);
insert into client values (23, '', 'Network Appliance', 5000.00, 1);
insert into client values (24, '', 'Bronson Healthcare Group', 5000.00, 1);
insert into client values (25, '', 'CDW Corporation', 5000.00, 1);
insert into client values (26, '', 'Timberland', 5000.00, 1);
insert into client values (27, '', 'Pella', 5000.00, 1);
insert into client values (28, '', 'Marriott International', 5000.00, 1);
insert into client values (29, '', 'St. Luke''s Episcopal Health System', 5000.00, 1);
insert into client values (30, '', 'Emmis Communications', 5000.00, 1);
insert into client values (31, '', 'Wm. Wrigley Jr.', 5000.00, 1);
insert into client values (32, '', 'Granite Construction', 5000.00, 1);
insert into client values (33, '', 'Medtronic', 5000.00, 1);
insert into client values (34, '', 'Vanguard Group', 5000.00, 1);
insert into client values (35, '', 'SEI Investments', 5000.00, 1);



insert into address values (0, 0, '1231 South Joliet St.', '', '', 'Joliet', 'Illinois', '60343', 'USA', 'Billing');
insert into address values (1, 0, '110 Arcadia Ave.', '', '', 'Romeoville', 'Illinois', '60441', 'USA', 'Billing');
insert into address values (2, 0, '543 Michigan Ave.', '', '', 'South Cart', 'Michigan', '55312', 'USA', 'Billing');
insert into address values (3, 1, '401 Dernst Court', '', '', 'Carnville', 'Indiana', '34343', 'USA', 'Billing');

commit;


 select count(clientID) from client where clientID >= 0

 select * from client order by clientname LIMIT 5, 5;

 select ROW_NUMBER(), * from client where  = 2

select i.invoiceNumber, i.invoiceDate, c.clientName, i.terms, a.totalAmount, i.datePrinted
from invoice i, client c, invoice_adj_amounts a
where i.clientID = c.clientID and i.invoiceNumber = a.invoiceNumber limit 0, 15
 
 
 SELECT f_name, l_name from
employee_data 

 select * from client

