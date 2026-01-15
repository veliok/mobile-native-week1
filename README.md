# Viikko 1: Tehtävälista-sovellus

Kotlinilla ja Jetpack Composella toteutettu yksinkertainen tehtävälista-sovellus.

## Esittely
- **Video:** <https://youtu.be/ZrF9A4_nkIA>


### Datamalli
Sovellus käyttää `Task`-tietoluokka, joka määrittelee tehtävien rakenteen. Domain-paketin MockData.kt-tiedosto sisältää 5 ennalta määritettyä tehtävää testausta varten.

`Task`-tietoluokan rakenne:
```kotlin
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    val dueDate: String,
    val done: Boolean
)
```

## Funktiot

- `addTask(list, task)` – lisää uuden tehtävän listan loppuun  
- `toggleDone(list, id)` – vaihtaa yksittäisen tehtävän `done`-tilan  
- `filterByDone(list, done)` – näyttää vain tehtävät, jotka ovat `done`-tilassa  
- `sortByDueDate(list)` – lajittelee tehtävät eräpäivän mukaan 


## Käyttöliittymä (UI)
**HomeScreen** on toteutettu Jetpack Composella ja sisältää:

- listan tehtävistä
- napit:
  - lisää tehtävä
  - toggle jokaiselle riville
  - show done / show all (yksi nappi)
  - lajittelu eräpäivän mukaan  
- toggle-nappi vaihtaa väriä ja tekstiä riippuen tehtävän tilasta  
- UI käyttää Compose-layoutteja:
  - **Column**
  - **Row**
  - **Modifier**
  - **Button**
  - **Divider**

## Kuinka käytät
1. Avaa projekti **Android Studiossa**   
2. Käynnistä sovellus **Android Emulaattorilla** tai fyysisellä Android-laitteella

Tai asenna saatavilla oleva **APK** suoraan laitteeseesi.