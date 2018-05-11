# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/arkkitehtuuri.png" width="160">

Pakkaus _gravitysimulator.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän _gravitysimulator.domain_ sovelluslogiikan ja _gravitysimulator.dao_ tallennustoiminnallisuudesta vastaavan koodin.

## Käyttöliittymä

JavaFX:llä luotu käyttöliittymä sisältää kolme erilaista näkymää: valikon, credits-ruudun ja itse pelin. Valikko on toteutettu BorderPane-tyyppisenä, ja peli on toteutettu subsceneinä, jotka sisältävät pelin näkymän ja valikon.
Credits on myös subscene.

## Tallennus

Sovellus tarjoaa yksinkertaisen, SQLitellä toimivan tallennuksen, jossa yhden järjestelmän voi tallentaa tietokantaan. Tallennettaessa uutta järjestelmää vanha katoaa.

## Pelin luokkakaavio

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/luokkakaavio.png">

Sovelluksen loogisen mallin muodostavat luokat Game sekä CelestialObject. Game kuvaa peliä, ja CelestialObject pelin sisällä olevia kappaleita. 

##Ohjelman rakenteeseen jääneet heikkoudet

- Käyttöliittymän määrittely on hieman sekava, ja olisi paras järjestää selvemmin omiksi metodeikseen.

- Luokkien välinen kommunikaatio on turhan monimutkaista. Esimerkiksi sekvenssikaavion tekeminen alussa olisi kenties auttanut tähän.
Tässä vaiheessa sen tekeminen ei enää onnistunut.

- Game-luokka on liian suuri
