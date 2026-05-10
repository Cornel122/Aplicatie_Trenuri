    Am implemntat o aplicatie de ticketing pentru trenuri folosind 
    Java Spring Boot pentru backend ,React pentru interfata grafica si MySql pentru baza de date
    Aplicatia permite:
    1:autentificarea utilizatorilor
    2:rezervarea biletelor la tren si confirmarea prin email.
    3:cautarea rutelor intre statii
    4:administrarea trenurilor si rutelor
    5:notificarea clientilor prin email in cazul intarzierilor
    Am utilizat pentru partea de backend:
    1:Java
    2:Spring Boot
    3:Spring Data JPA
    4:MySQL
    5:JavaMailSender si pentru frontend:
    1:React
    2:Axios
    3:Vite
    Backendul este impartit pe pachete:
    Controllers
    Services
    Repositories
    Models
    DTO-uri
    si frontendul:
    pagina login/signup;
    pagina client;
    pagina administrator;
    componente separate pentru fiecare functionalitate.
    
Baza de date contine urmatoarele tabele:
 utilizatori
 trenuri
 statii
 rute
 rezervari

    Partea de login si signup a fost adaugata de mine ca sa pot separa lucrurile ce le face un client si ce le face administratorul:
    pagina Login/Signup realizata in React;
    utilizatorul introduce numele si parola;
    dupa autentificare utilizatorul este redirectionat automat:
    CLIENT -> pagina client;
    ADMIN -> pagina administrator.

    Backend:
    metoda POST /auth/signup:
    input:
    {
    "nume": "alex",
    "parola": "1234",
    "rol": "CLIENT"
    }
    output:
    Cont creat cu succes.
    metoda POST /auth/login:
    input:
    {
    "nume": "alex",
    "parola": "1234"
    }
    output:Login reusit

    Rezervarea biletelor:
    Frontend:
    utilizatorul selecteaza trenul 
    introduce email-ul;
    introduce numarul de bilete
    apasa butonul "Rezerva".

    Backend:

    metoda POST /rezervari:
    input:
    {
    "utilizatorId": 1,
    "trenId": 1,
    "emailClient": "client@gmail.com",
    "numarBilete": 2
    }
    output:
    Rezervarea a fost efectuata.
    sau in caz de eroare:Nu mai sunt suficiente locuri disponibile.

    Sistemul:

    verifica locurile disponibile;
    previne overbooking-ul;
    trimite email de confirmare.

    Cautarea rutelor:
    Utilizatorii pot cauta rute intre doua statii.
    Frontend:
    selectarea statiei de plecare
    selectarea statiei de sosire
    apasarea butonului "Cauta ruta".

    Backend:

    metoda POST /rute/cauta:
    input:{
    "statiePlecareId": 1,
    "statieSosireId": 3
    }
    output:
    Ruta directa gasita:
    Tren IR123
    Bucuresti -> Cluj
    08:00 -> 12:00
    sau
    Ruta cu schimbare:
    Tren IR123:
    Bucuresti -> Brasov
    Tren IR456:
    Brasov -> Cluj
    eroare:
    Nu exista ruta disponibila.

    Sistemul:

    cauta ruta directa
    cauta ruta cu schimbare de tren
    afiseaza mesaj daca nu exista ruta.

    Pentru partea de administrator:
    Administratorul poate:

    adauga trenuri;
    modifica trenuri;
    sterge trenuri.

    Frontend:
    selectarea trenurilor existente
    butoane pentru CRUD.

    Backend:
    POST /admin/trenuri:
    input:
    {
    "numarTren": "IR500",
    "capacitate": 120,
    "intarziere": 0
    }
    output:
    Tren adaugat
    PUT /admin/trenuri/{id}
    input:{
    "numarTren": "IR500_MODIFICAT",
    "capacitate": 150,
    "intarziere": 10
    }

    output:Tren modificat
    DELETE /admin/trenuri/{id}
    input:id = 1

    output:Tren sters

    Partea de  rute:
    Administratorul poate:
    adauga rute
    modifica rute
    sterge rute.

    Frontend:
    selectarea trenului;
    selectarea statiilor;
    introducerea orelor.

    Backend:
    POST /admin/rute
    input:
    {
    "tren": {
        "id": 1
    },
    "statiePlecare": {
        "id": 1
    },
    "statieSosire": {
        "id": 2
    },
    "oraPlecare": "08:00",
    "oraSosire": "10:00"
    }
    output:
    Ruta adaugata
    PUT /admin/rute/{id}
    input:{
    "tren": {
        "id": 1
    },
    "statiePlecare": {
        "id": 1
    },
    "statieSosire": {
        "id": 3
    },
    "oraPlecare": "09:00",
    "oraSosire": "12:00"
    }

    output:Ruta modificata
    DELETE /admin/rute/{id}
    input:id = 1

    output:
    Ruta stearsa
    Vizualizare rezervari pentru un tren:
    Administratorul poate vedea toate rezervarile unui tren.

    Frontend:

    selectarea trenului din dropdown;
    afisarea rezervarilor.

    Backend:

    GET /admin/trenuri/{trenId}/rezervari:
    input:nimic

    output:client@gmail.com - 2 bilete
    alex@gmail.com - 1 bilet

    Adaugare intarziere trenuri:
    Administratorul poate introduce intarzieri pentru trenuri.

    Frontend:
    selectarea trenului;
    introducerea numarului de minute;
    salvarea intarzierii.

    Backend:
    PUT /admin/trenuri/{trenId}/intarziere
    input:
    trenId = 1
    minute = 30
    output:Intarzierea a fost adaugata si clientii au fost notificati.
    Cand un tren are intarziere:
    clientii primesc email automat.

In cadrul aplicatiei am utilizat arhitectura REST pentru comunicarea dintre frontend si backend.
Datele sunt transferate folosind DTO-uri pentru o separare mai buna intre modelele aplicatiei si datele trimise catre client.
Pentru accesul la baza de date am utilizat Spring Data JPA si Repository-uri dedicate fiecarei entitati.
Interfata React a fost realizata folosind componente reutilizabile si comunicare HTTP prin Axios, utilizatorii nu trebuie sa introduca manual ID-uri, selectarea trenurilor si statiilor fiind realizata prin dropdown-uri generate automat din baza de date.
Aplicatia gestioneaza situatiile de eroare.
Aplicatia a fost dezvoltata respectand principiul separarii responsabilitatilor:
Controller -> gestionarea request-urilor HTTP
 Service -> logica aplicatiei
 Repository -> accesul la baza de date
 Model -> entitatile aplicatiei
 Pornirea aplicatiei :
 backend: mvn spring-boot:run 
 frontend:npm run dev   
 frontend portul:5173
 backend:8080

 Pentru problema 2, care este optionala, am adaugat o functionalitate suplimentara pentru aplicatia de ticketing ce consta in recomandarea automata a celei mai bune rute disponibile intre doua statii.
Frontend:
utilizatorul selecteaza statia de plecare;
selecteaza statia de sosire;
apasa butonul "Recomanda tren".
Backend:
metoda POST /recomandare
input:{
  "statiePlecareId": 1,
  "statieSosireId": 3
}
output:
Cea mai buna ruta:
Tren: IR123
Plecare: Bucuresti
Sosire: Cluj
Ora plecare: 08:00
Ora sosire: 12:00
Intarziere: 0 minute

Aplicatia analizeaza toate rutele disponibile intre cele doua statii si calculeaza automat cea mai buna varianta pe baza urmatoarelor criterii:
numarul de locuri disponibile;
intarzierea trenului;
disponibilitatea trenului.
Pentru fiecare ruta este calculat un scor, iar ruta cu cel mai bun scor este recomandata utilizatorului.