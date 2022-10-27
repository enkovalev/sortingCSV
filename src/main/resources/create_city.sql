create table city
(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    code       integer not null,
    name      varchar(150) not null
);

CREATE INDEX city_names ON city (name NULLS LAST);
CREATE INDEX city_codes ON city (code NULLS LAST);