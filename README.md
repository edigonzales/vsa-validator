# vsa-validator

## Todo
- IGS_filter Implementierung (in "Gut")
- IGS_getLength / getArea / getDistance2 / isInsideSurface mit GeoemtryUtils mit allen möglichen Varianten.
- Versionen der Libs abstimmen. Am Ende des Tages muss es mit ilivalidator funktionieren.
- Test der XTF mit VSA-Checker und Vergleich
- Unschön: Math.add() funktioniert nicht mit IGS_getYear(). Wahrscheinlich wegen Rückgabewert NUMERIC von getYear und führt zu "inkompatiblen Values" Fehlern. Eine eigens geschriebene IGS_add()-Funktion, funktioniert auch nur mit Zusatzaufwand, indem man nicht getValue() verwendet, sondern getNumeric() (resp. if/else...). -> Ticket ist erstellt.
- In ilivalidator gibt es keine "Info"-Kategorie. Was tun? Warning?
- skipEvaluation auch für weitere Argumente (Was ist das überhaupt? -> nachgefragt per E-Mail)
- Klären (siehe E-Mail-Diskussion): Welche Typen haben die Argumente, z.B. POLYLINE vs OBJECTS OF ANYCLASS inkl. attrPath. Was liefert IoxPlugin in beiden Fällen? Wie ist der Umgang in beiden Varianten? Gleich? Komplett unterschiedlich?
- Tests:
  - sub
  - pow
  - abs
  - sqrt
  - div
  - ...
- IGS_max mit Expression ist eine Blenderfunktion. Sie funktioniert genau nur für den Usecase im VSA-Check-Modell. Wenn überhaupt muss man das generisch in sauber lösen. Entweder mit der INTERLIS-Sprache selber oder z.B. mit CQL o.ä.
- IGS-Funktionen: auch Testdaten vereinfachen (nicht DSS mini)
- TEZG: 9203? Entsprechen dem Range, den der Wert gemäss Modell sein darf. Warum der Zusatz-Constraint?

## Requirements
- iox-ili >= 1.21.6-SNAPSHOT (see https://github.com/claeis/iox-ili/commit/7613518d82d7f1ac40e4b52d84150212c313e137)


## VSADSSMINI_2020_LV95_CHECK_FP

- Knoten: Einige Funktionstests funktionieren noch nicht. Siehe https://github.com/claeis/ilivalidator/issues/300





