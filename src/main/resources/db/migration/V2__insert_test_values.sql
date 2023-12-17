SET search_path TO panda;

insert into users(user_id)
values ('1d5fcfd1-afc2-483d-8bd9-0c218e774bca');

insert into mails(user_id, event_name, date, description)
values (1, 'Wedding', current_timestamp, 'description');

insert into accounts(user_id, name, account, password, link, description, mail, type)
values (1,'steam', 'Apostality', 'temp_pass', 'some_link', 'some_descr', 'some_mail', 'GAMES');



    id          SERIAL PRIMARY KEY,
    user_id     INTEGER      not null,
    name        VARCHAR(90) NOT NULL,
    account     VARCHAR(50),
    password    VARCHAR(30) NOT NULL UNIQUE,
    link        text,
    description text,
    mail        integer     NOT NULL,
    type        VARCHAR(10) NOT NULL DEFAULT 'TEMP'




