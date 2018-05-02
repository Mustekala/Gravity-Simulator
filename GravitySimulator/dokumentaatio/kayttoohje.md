# Käyttöohje

Lataa tiedosto [GravitySimulator-1.0-SNAPSHOT.jar](https://github.com/Mustekala/otm-harjoitustyo/releases/tag/v0.6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar GravitySimulator-1.0-SNAPSHOT.jar
```

## Käyttöliittymä

New game aloittaa uuden pelin. Load save lataa peliin tallennetun järjestelmän. Tällä hetkellä tuki vain yhden järjestelmän tallentamiseen. 
Load save-valinta ei toimi ennen kuin käyttäjä tallentaa järjestelmän.

### Peli

Pelin vasemmalla puolella on kenttiä, joilla voi luoda uuden kappaleen. Näkyvan alueen keskikohdan kordinaatit ovat x:500 y:400.
Nopeudet kertovat kappaleen liikkeen määrän pikseleinä kyseiseen suuntaan per iteraatio. Nopeudet kannataa pitää pieninä (<5), jos
haluaa näkyvän kiertoradan. Mass vaikuttaa kappaleen painovoiman voimakkuuteen,
size on kappaleen halkaisija pikseleinä. Priority määrittää, monenko iteraation välein kappaleen liikesuunta päivitetään.
Alhaalla on nappi Save current game, jolla järjestelmän voi tallentaa. Tallennetun järjestelmän voi ladata päävalikosta.
