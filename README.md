# Viikko 1: Tehtävälista-sovellus

Kotlinilla ja Jetpack Composella toteutettu yksinkertainen tehtävälista-sovellus. Harjoituksen painopisteenä on **Kotlinin perusteet** sekä **käyttöliittymä ilman XML-tiedostoja**.

## Esittely
- **Video:** [Linkki videoon tässä]

---

## Ominaisuudet
Sovellus näyttää listan tehtävistä, ja käyttäjä voi:
* **Lisätä** uusia tehtäviä listaan.
* **Vaihtaa** tehtävän suoritustilaa (Done/Todo).
* **Suodattaa** näkymää.
* **Järjestää** listan eräpäivän mukaan.

---

### Datamalli
Sovelluksen ytimenä on immutable `Task`-tietoluokka. Domain-paketti sisältää myös 5 mock-tehtävää testausta varten.

```kotlin
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: String,
    val dueDate: String,
    val done: Boolean
)
```
---

## Kotlin-funktiot

- `addTask(list, task)` – lisää uuden tehtävän listan loppuun  
- `toggleDone(list, id)` – vaihtaa yksittäisen tehtävän `done`-tilan  
- `filterByDone(list, done)` – näyttää vain tehtävät, jotka ovat `done`-tilassa  
- `sortByDueDate(list)` – lajittelee tehtävät eräpäivän mukaan 

---

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

---

## Kuinka käyttää
1. Avaa projekti **Android Studiossa**   
2. Käynnistä sovellus **Android Emulaattorilla** tai fyysisellä Android-laitteella  

Lisäksi **APK** on saatavilla suoraan asennusta varten.

---

