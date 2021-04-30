# vsa-validator

## Todo
- IGSFunction.IGS_xxxxx() -> SOGISFunction.xxxxx() 
- SOGISFunction: separates Repo und einfachere (generische) Testdaten
- IGS_filter Implementierung (in "Gut")
- IGS_getLength / getArea / getDistance2 / isInsideSurface mit GeoemtryUtils mit allen möglichen Varianten.
- Versionen der Libs abstimmen. Am Ende des Tages muss es mit ilivalidator funktionieren.
- Test der XTF mit VSA-Checker und Vergleich
- In ilivalidator gibt es keine "Info"-Kategorie. Was tun? Warning?
- Meine IGS_max mit Expression ist eine Blenderfunktion. Sie funktioniert genau nur für den Usecase im VSA-Check-Modell. Wenn überhaupt muss man das generisch in sauber lösen. Entweder mit der INTERLIS-Sprache selber oder z.B. mit CQL o.ä.
- TEZG: 9203? Entsprechen dem Range, den der Wert gemäss Modell sein darf. Warum der Zusatz-Constraint?

## Resultierende ilivalidator-Bugs
- https://github.com/claeis/ilivalidator/issues/300 -> Im Validierungs-Modell fehlen diese Constraints
- https://github.com/claeis/ilivalidator/issues/301 (Workaround vorhanden) -> fixed
- https://github.com/claeis/ilivalidator/issues/304 (Workaround vorhanden) -> fixed
- https://github.com/claeis/ilivalidator/issues/308 -> Disabled