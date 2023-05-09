# Megjegyzés: 
Megírtam a PostgreSQL és Docker részét, működik minden.
Majd visszaalakítottam a H2-es megoldásra, hogy a tesztek gond nélkül fussanak és local gépen lehessen futtatni a Postman-es teszteléshez.
PostgreSQL és Docker teszthez az application.properties-ben található kikommentelt sorokat kell visszahozni.
#
#
#
#



Innentől lefelé a feladat követelményei találhatóak!

# Vizsgaremek

A feladatod egy backend API projekt készítése.


## Követelmények
- Maven vagy Gradle projekt
- Spring Boot alkalmazás
- SQL backend (pl. MySQL, MariaDB, Postgresql)
- Flyway sémamigráció, SQL táblalétrehozás, adatbetöltés
- REST API, Swagger, OpenAPI dokumentációval
- Hibakezelés, validálás
- Spring Data JPA repository
- Integrációs tesztek

## Feladat nagysága

- Legalább két:
    - 1-n kapcsolatban lévő tábla
    - SQL migráció
    - entitás
    - service
    - controller

- Minden bemenő paraméter validálása
- Legalább egy property beolvasása
- Minden HTTP metódusra legalább egy végpont (GET, POST, PUT, DELETE)
- Legalább 60%-os tesztlefedettség, amely tartalmaz egység és integrációs teszteket is
- Egy Dockerfile/docker-compose fájl


## Témaötletek

Az alábbi ötletekből szemezhettek, de jó lenne, ha saját, valós problémát próbálnátok megoldani:

- oltópont
- webshop
- idősek otthona (gyógyszerek ételek időpontok)
- vállalatirányítási rendszer (számlák rendelések)
- munkaidő-nyilvántartó rendszer
- munkaerő-nyilvántartó rendszer
- kutatások nyilvántartása
- flottakezelő rendszer
- autókereskedés
- filmes adatbázis
- állatkereskedés
- menhelyi nyilvántartó
- eszközleltár
- biztosítási rendszer (szerződések káresemény biztosítási összeg biztosítás fajtája)
- foglalási rendszer
- utazási iroda
- építőipari projekt rendszere
- könyvtári nyilvántartó
- egyéni költségeket nyilvántartó rendszer
- valutaváltó
- vonatjegy applikáció
- ételrendelő applikáció
- szolgáltatásrendelő (fodrászat időpontkezelés szolgáltatások)
- mesterember app (kit mikor lehet hívni)
- tanulónyilvántartó rendszer (NEPTUN)
- kedvezményes kuponokat gyűjtő app (milyen termék milyen kedvezmény)
- ticketing (hibabejelentő rendszer)
- online kurzusok (e-learning menedzsment rendszer LMS)
- telefonflotta nyilvántartása
- elektromos művek ügyfélnyilvántartója
- nyelvtanár-nyilvántartó
- ételkiszállítás/ételfutár app (Teletál, Netpincér)
- konferencia-nyilvántartó
- receptgyűjtemény