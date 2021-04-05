# vsa-validator

## Todo
- Trennen der Funktionstest: Ok und Fail je Test. Sonst testet man nicht wirklich alles.
- IGS_filter Implementierung (in "Gut")
- clean repo
- Versionen der Libs abstimmen. Am Ende des Tages muss es mit ilivalidator funktionieren.
- Test der XTF mit VSA-Checker und Vergleich
- Unschön: Math.add() funktioniert nicht mit IGS_getYear(). Wahrscheinlich wegen Rückgabewert NUMERIC von getYear und führt zu "inkompatiblen Values" Fehlern. Eine eigens geschriebene IGS_add()-Funktion, funktioniert auch nur mit Zusatzaufwand, indem man nicht getValue() verwendet, sondern getNumeric() (resp. if/else...). -> Ticket noch nicht erstellt.
- In ilivalidator gibt es keine "Info"-Kategorie. Was tun? Warning?

## Requirements
- iox-ili >= 1.21.6-SNAPSHOT (see https://github.com/claeis/iox-ili/commit/7613518d82d7f1ac40e4b52d84150212c313e137)


## VSADSSMINI_2020_LV95_CHECK_FP

- Knoten: Zwei Funktionstests funktionieren noch nicht. Siehe https://github.com/claeis/ilivalidator/issues/300



