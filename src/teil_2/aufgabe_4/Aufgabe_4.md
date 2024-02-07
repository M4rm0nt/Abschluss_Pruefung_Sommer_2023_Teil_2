```sql
CREATE TABLE Objekt (
    OID BIGINT PRIMARY KEY,
    Bezeichnung VARCHAR
);


CREATE TABLE Mitarbeiter (
    MID BIGINT PRIMARY KEY,
    Name VARCHAR,
    Vorname VARCHAR
);


CREATE TABLE Taetigkeit (
    TID BIGINT PRIMARY KEY,
    Bezeichnung VARCHAR
);

CREATE TABLE Pflegearbeit (
    PID BIGINT PRIMARY KEY,
    OID BIGINT,
    TID BIGINT,
    MID_SOLL BIGINT,
    MID_IST BIGINT,
    Datum_Soll DATE,
    Datum_Abschluss DATE,
    FOREIGN KEY (OID) REFERENCES Objekt(OID),
    FOREIGN KEY (TID) REFERENCES Taetigkeit(TID),
    FOREIGN KEY (MID_SOLL) REFERENCES Mitarbeiter(MID),
    FOREIGN KEY (MID_IST) REFERENCES Mitarbeiter(MID)
);

INSERT INTO Objekt (OID, Bezeichnung) VALUES (1, 'Rasenfläche Süd');
INSERT INTO Objekt (OID, Bezeichnung) VALUES (2, 'Rosengarten');
INSERT INTO Objekt (OID, Bezeichnung) VALUES (3, 'Tropenhaus');

select * from Objekt;

INSERT INTO Mitarbeiter (MID, Name, Vorname) VALUES (1, 'Rose', 'Ines');
INSERT INTO Mitarbeiter (MID, Name, Vorname) VALUES (2, 'Baum', 'Jürgen');
INSERT INTO Mitarbeiter (MID, Name, Vorname) VALUES (31, 'Holz', 'Walter');

select * from Mitarbeiter;

INSERT INTO Taetigkeit (TID, Bezeichnung) VALUES (1, 'Rosenschnitt');
INSERT INTO Taetigkeit (TID, Bezeichnung) VALUES (2, 'Rasen mähen');
INSERT INTO Taetigkeit (TID, Bezeichnung) VALUES (3, 'Unkraut jäten');

select * from Taetigkeit;

INSERT INTO Pflegearbeit (PID, OID, TID, MID_SOLL, MID_IST, Datum_Soll, Datum_Abschluss) VALUES (1, 1, 2, 31, 31, '2023-05-20', '2023-04-20');
INSERT INTO Pflegearbeit (PID, OID, TID, MID_SOLL, MID_IST, Datum_Soll, Datum_Abschluss) VALUES (2, 1, 2, 2, 2, '2023-05-11', NULL);
INSERT INTO Pflegearbeit (PID, OID, TID, MID_SOLL, MID_IST, Datum_Soll, Datum_Abschluss) VALUES (3, 2, 1, 1, 2, '2023-03-20', '2023-03-21');
INSERT INTO Pflegearbeit (PID, OID, TID, MID_SOLL, MID_IST, Datum_Soll, Datum_Abschluss) VALUES (4, 2, 1, 1, NULL, '2023-08-01', NULL);
INSERT INTO Pflegearbeit (PID, OID, TID, MID_SOLL, MID_IST, Datum_Soll, Datum_Abschluss) VALUES (5, 2, 3, 31, NULL, '2023-07-28', NULL);

select * from Pflegearbeit;
```

--------------------------------------------------------------

Aufgabe 1a)

```sql
SELECT COUNT(*)
FROM Pflegearbeit
WHERE EXTRACT(YEAR FROM Datum_Soll) = 2023
  AND (Datum_Abschluss IS NULL OR EXTRACT(YEAR FROM Datum_Abschluss) > 2023);
```

--------------------------------------------------------------









