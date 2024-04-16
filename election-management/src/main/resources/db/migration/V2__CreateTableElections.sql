CREATE TABLE elections (
    id VARCHAR(40) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE election_candidate (
    election_id VARCHAR(40) NOT NULL,
    candidate_id VARCHAR(40) NOT NULL,
    votes INTEGER DEFAULT 0,
    PRIMARY KEY(election_id, candidate_id)
);

insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('1', 'http://dummyimage.com/141x100.png/ff4444/ffffff', 'Sammie', 'Whitby', 'swhitby0@technorati.com', '667-846-6751', 'Professor');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('2', 'http://dummyimage.com/111x100.png/5fa2dd/ffffff', 'Brinna', 'Sainsbury', 'bsainsbury1@example.com', '338-328-4179', 'Community Outreach Specialist');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('3', 'http://dummyimage.com/203x100.png/dddddd/000000', 'Murdoch', 'Norcutt', 'mnorcutt2@over-blog.com', '642-319-8328', 'Graphic Designer');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('4', 'http://dummyimage.com/233x100.png/5fa2dd/ffffff', 'Vito', 'Mowbray', 'vmowbray3@t-online.de', '847-411-9929', 'Administrative Assistant IV');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('5', 'http://dummyimage.com/161x100.png/ff4444/ffffff', 'Gib', 'Stallworth', 'gstallworth4@walmart.com', '213-605-2145', 'Analog Circuit Design manager');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('6', 'http://dummyimage.com/136x100.png/cc0000/ffffff', 'Pace', 'Ziems', 'pziems5@lulu.com', '579-668-1861', 'Physical Therapy Assistant');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('7', 'http://dummyimage.com/109x100.png/5fa2dd/ffffff', 'Aimee', 'O''Luby', 'aoluby6@wordpress.com', '582-318-5672', 'Programmer II');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('8', 'http://dummyimage.com/195x100.png/cc0000/ffffff', 'Netta', 'Milkins', 'nmilkins7@boston.com', '265-444-5245', 'Editor');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('9', 'http://dummyimage.com/152x100.png/cc0000/ffffff', 'Janean', 'Cotterill', 'jcotterill8@nytimes.com', '209-247-8796', 'Research Assistant III');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('10', 'http://dummyimage.com/235x100.png/dddddd/000000', 'Henri', 'Cranmere', 'hcranmere9@biblegateway.com', '513-387-4860', 'VP Accounting');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('11', 'http://dummyimage.com/116x100.png/cc0000/ffffff', 'Norrie', 'Fairlie', 'nfairliea@hostgator.com', '887-789-5434', 'Food Chemist');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('12', 'http://dummyimage.com/105x100.png/dddddd/000000', 'Jonis', 'Pawden', 'jpawdenb@amazon.com', '853-883-2415', 'Human Resources Manager');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('13', 'http://dummyimage.com/144x100.png/5fa2dd/ffffff', 'Nollie', 'Foxten', 'nfoxtenc@prnewswire.com', '778-925-0104', 'Structural Engineer');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('14', 'http://dummyimage.com/121x100.png/cc0000/ffffff', 'Mar', 'Joanaud', 'mjoanaudd@mozilla.com', '813-214-7023', 'Nuclear Power Engineer');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('15', 'http://dummyimage.com/115x100.png/dddddd/000000', 'Clayborn', 'Minter', 'cmintere@odnoklassniki.ru', '576-205-1460', 'Project Manager');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('16', 'http://dummyimage.com/184x100.png/cc0000/ffffff', 'Keith', 'Vance', 'kvancef@utexas.edu', '902-319-6053', 'Teacher');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('17', 'http://dummyimage.com/214x100.png/5fa2dd/ffffff', 'Issy', 'Cawdell', 'icawdellg@plala.or.jp', '816-284-6874', 'Design Engineer');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('18', 'http://dummyimage.com/144x100.png/ff4444/ffffff', 'Guendolen', 'Titchard', 'gtitchardh@instagram.com', '770-330-4464', 'VP Accounting');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('19', 'http://dummyimage.com/139x100.png/5fa2dd/ffffff', 'Veronique', 'Wetherick', 'vwethericki@ft.com', '612-644-4817', 'Paralegal');
insert into candidates (id, photo, given_name, family_name, email, phone, job_title) values ('20', 'http://dummyimage.com/204x100.png/cc0000/ffffff', 'Mandi', 'Astill', 'mastillj@umich.edu', '696-303-9977', 'VP Marketing');
