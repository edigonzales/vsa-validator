# vsa-validator

## Todo
- IGSFunction.IGS_xxxxx() -> SOGISFunction.xxxxx() 
- SOGISFunction: separates Repo
- IGS_filter Implementierung (in "Gut")
- IGS_getLength / getArea / getDistance2 / isInsideSurface mit GeoemtryUtils mit allen möglichen Varianten.
- Versionen der Libs abstimmen. Am Ende des Tages muss es mit ilivalidator funktionieren.
- Test der XTF mit VSA-Checker und Vergleich
- In ilivalidator gibt es keine "Info"-Kategorie. Was tun? Warning?
- Klären (siehe E-Mail-Diskussion): Welche Typen haben die Argumente, z.B. POLYLINE vs OBJECTS OF ANYCLASS inkl. attrPath. Was liefert IoxPlugin in beiden Fällen? Wie ist der Umgang in beiden Varianten? Gleich? Komplett unterschiedlich?
- IGS_max mit Expression ist eine Blenderfunktion. Sie funktioniert genau nur für den Usecase im VSA-Check-Modell. Wenn überhaupt muss man das generisch in sauber lösen. Entweder mit der INTERLIS-Sprache selber oder z.B. mit CQL o.ä.
- IGS-Funktionen: auch Testdaten vereinfachen (nicht DSS mini)
- TEZG: 9203? Entsprechen dem Range, den der Wert gemäss Modell sein darf. Warum der Zusatz-Constraint?

## Requirements
- iox-ili >= 1.21.6-SNAPSHOT (see https://github.com/claeis/iox-ili/commit/7613518d82d7f1ac40e4b52d84150212c313e137)


## Resultierende ilivalidator-Bugs
- https://github.com/claeis/ilivalidator/issues/300 -> Im Validierungs-Ili fehlen diese Constraints
- https://github.com/claeis/ilivalidator/issues/301 (Workaround vorhanden) -> fixed
- https://github.com/claeis/ilivalidator/issues/304 (Workaround vorhanden) -> fixed
