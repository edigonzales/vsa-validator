# vsa-validator

## Todo
- clean repo
- Im Sinne von Unit-Tests sollten die Tests im Code nicht die kombinierten Constraints prüfen, sondern nur die Funktion selber. Die VSA-Constraints werden in den Funktionstests geprüft. (MINI_Knoten_Leitungen und MINI_Knoten_Leitungen_wegfuehrend)
- Subprojekt mit functional tests, d.h. sämtliche Tests auch solche, die keinen Code benötigen.
- Versionen der Libs abstimmen. Am Ende des Tages muss es mit ilivalidator funktionieren.
- Test der XTF mit VSA-Checker

## Requirements
- iox-ili >= 1.21.6-SNAPSHOT (see https://github.com/claeis/iox-ili/commit/7613518d82d7f1ac40e4b52d84150212c313e137)


## VSADSSMINI_2020_LV95_CHECK_FP

| cid | Bemerkungen | Status |
| ----|-------------|--------|
| 1020 | Text.matches() | [x] |
| 1021 | core ilivalidator | [x] |
| 2010 | needs coding | [ ] |
| 2020 | needs coding. Prüfung geometrisch oder "bloss" mittels Assoziation? | [x] |
| 2030 | needs coding | [ ] |
| 2040 | needs coding | [ ] |
| 2050 | needs coding. IGS_filter? | [ ] |
| 2110 | needs coding. Es gibt Math.min(). Funktionsweise noch zu verstehen. | [ ] |
| ... | ... | [ ] |

