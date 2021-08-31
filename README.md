# README

### GIT Strategie (GIT-Flow Richtlinien):

  * Der main Branch stellt das Live Server Abbild dar.
  * Der develop Branch wird als Review App deployt und dient als Sammelbecken der Features die zum Projekt (main) kommen.
  * in main und develop wird nicht gearbeitet.
  * Features dürfen erst geschlossen werden, wenn der Release Branch, welche das Feature enthält, deployed wurde
  * Direkt im Release-Branch wird nicht gearbeitet, sondern nur Features hinein gemerged
  * In den Release-Branch werden nur fertige Features gemerged
  * Neue Features werden vom develop Branch abgezweigt.
  * Für jedes JIRA Ticket wird ein Feature Branch mit geprefixter Ticketnummer angelegt.
  * Jede Commit Message innerhalb  des Features wird ebenfalls mit Ticketnummer geprefixt.


| Branch        | Beschreibung           | 
| ------------- |:-------------:| 
| Feature      | Für jede Anpassung oder Erweiterung am System | 
| develop      | Bildet nach Git Flow den aktuellen Entwicklungsstand ab      |   
| release | Wird erstellt, um ein fertiges Featureset für einen Deploy zu kapseln      |   
| main | Bildet den Livestand eines Projekts ab      |    





