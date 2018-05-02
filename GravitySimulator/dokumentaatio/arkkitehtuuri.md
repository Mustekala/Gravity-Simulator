# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/arkkitehtuuri.png" width="160">

Pakkaus _gravitysimulator.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän _gravitysimulator.domain_ sovelluslogiikan ja _gravitysimulator.dao_ tallennustoiminnallisuudesta vastaavan koodin.

## Käyttöliittymä

Käyttöliittymä sisältää kaksi erilaista näkymää: valikon ja itse pelin. Valikko on toteutettu BorderPane-tyyppisenä, ja peli on toteutettu alisceneinä, jotka sisältävät pelin näkymän ja valikon.

## Tallennus

Sovellus tarjoaa yksinkertaisen, SQLitellä toimivan tallennuksen, jossa yhden järjestelmän voi tallentaa tietokantaan. Tallennettaessa uutta järjestelmää vanha katoaa. Useiden järjestelmien tallennus tulossa mahdollisesti myöhemmin.


## Pelin luokkakaavio
<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/luokkakaavio.png">
