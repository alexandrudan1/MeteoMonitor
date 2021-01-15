# Monitorizare Meteo

Aplicatie de monitorizare meteo
## Descriere

Aplicatia este utilizata cu scopul de a monitoriza vremea intr-un anumit oras ales de utilizator. Orasele sunt incarcate intr-un fisier de intrare, alaturi de anumite informatii despre acestea. Prin intermediul informatiilor din fisier aplicatia realizeaza cereri la API-ul  [OpenWeatherAPI](https://openweathermap.org/api), primind un raspuns in format JSON care contine informatiile despre vremea in orasul ales, acestea urmand a fi parsate si afisate in interfata grafica. Interfata grafica a fost realizata cu JavaFX iar rezolvarea dependintelor a fost realizata cu Maven.

## Utilizare
Aplicatia dispune utilizatorului doua liste unde poate alege tara si un anumit oras din tara aleasa. Alegerea orasului se efectueaza dupa alegerea tarii, lista cu orasele fiind afisata ulterior. In momentul alegerii unui oras pe interfata grafica vor aparea urmatoarele detalii despre vreme:

- Numele orasului ales si tara din care face parte
- Imagine reprezentativa care specifica vremea la momentul curent
- Ora si data curenta
- Temperatura
- Presiunea
- Coordonatele orasului
- Umiditatea
- Vizibilitatea
- Viteza vantului

Fisierul de intrare contine pe fiecare linie cate un oras cu urmatoarele detalii:  
**id oras nume latitudine longitudine tara**, separate prin spatii.
## Limbaj folosit
Java JDK 15

## Realizator
Dan Alexandru