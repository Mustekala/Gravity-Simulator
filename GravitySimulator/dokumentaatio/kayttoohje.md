# Käyttöohje

Lataa tiedosto [GravitySimulator-1.0-SNAPSHOT.jar](https://github.com/Mustekala/otm-harjoitustyo/releases/tag/v0.6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar GravitySimulator-1.0.jar
```

## Käyttöliittymä

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/menu.jpg" width="640">

New game aloittaa uuden pelin. Load save lataa peliin tallennetun järjestelmän. Tällä hetkellä tuki vain yhden järjestelmän tallentamiseen.
Jos tallennettua järjestelmää ei ole olemassa, avataan uusi järjestelmä. 

### Peli

<img src="https://raw.githubusercontent.com/Mustekala/otm-harjoitustyo/master/GravitySimulator/dokumentaatio/kuvat/game.jpg" width="640">

Pelin vasemmalla puolella on kenttiä, joilla voi luoda uuden kappaleen. Kaikki kentät on täytettävä.

Nopeudet kertovat kappaleen liikkeen määrän pikseleinä kyseiseen suuntaan per iteraatio. Nopeudet kannataa pitää pieninä (<5), jos
haluaa näkyvän kiertoradan.

Mass vaikuttaa kappaleen painovoiman voimakkuuteen, size on kappaleen halkaisija pikseleinä.

Priority määrittää, monenko iteraation välein kappaleen liikesuunta päivitetään.

Kun painaa "Add star / planet"-nappia, siirtyy luotu kappale hiiren kursorin kohdalle. Lisää kappale haluamaasi kohtaan hiirtä käyttäen, vasen painike lisää kappaleen.

Maailmassa voi liikkua hiiren avulla "vetämällä" maailmaa haluttuun suuntaan vasemmalla painikkeella. Klikkaamalla kappaletta voi valita sen, jolloin vasemmassa ruudussa näkyy kappaleen tietoja.
Tietoja voi myös päivittää kirjoittamalla haluamaansa kentään uuden arvon ja painamalla "Modify selected object"-nappia.

"Follow selected object"-nappi siirtää kameran seuraamaan valittua kappaletta. Uudelleen painettaessa kamera siirtyy taas hiirellä ohjattavaksi.

Alhaalla on nappi "Pause game", jolla pelin voi pysäyttää, sekä nappi "Save current game", jolla järjestelmän voi tallentaa. Tallennetun järjestelmän voi ladata päävalikosta.
