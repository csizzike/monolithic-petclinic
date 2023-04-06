DROP TABLE visits_statistics IF EXISTS;

CREATE TABLE visits_statistics (
                                   id          INTEGER IDENTITY PRIMARY KEY,
                                   visit_date  DATE,
                                   cost        INTEGER NOT NULL
);
