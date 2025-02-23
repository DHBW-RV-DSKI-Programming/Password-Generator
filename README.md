# Aufgabenstellung: Passwort-Generator

## Ziel der Aufgabe

Implementiere eine Konsolenanwendung, die sichere Passwörter generiert. Der Benutzer kann verschiedene Kriterien für das
Passwort festlegen, z. B. Länge, verwendete Zeichenarten (Groß- und Kleinbuchstaben, Zahlen, Sonderzeichen) und
optionale Regeln (z. B. keine wiederholten Zeichen, keine aufeinanderfolgenden Zahlen).

## Anforderungen

1. **Benutzereingabe**
    - Der Benutzer gibt die gewünschte Länge des Passworts ein (mindestens 6 Zeichen).
    - Der Benutzer kann festlegen, welche Zeichenarten enthalten sein sollen:
        - Kleinbuchstaben (a–z)
        - Großbuchstaben (A–Z)
        - Zahlen (0–9)
        - Sonderzeichen (z. B. `!@#$%^&*`)
    - Optional kann der Benutzer wählen, ob bestimmte Regeln eingehalten werden sollen:
        - Keine wiederholten Zeichen
        - Keine aufeinanderfolgenden Zahlen (z. B. „1234“)

2. **Passwort-Generierung**
    - Das Passwort wird zufällig gemäß den gewählten Kriterien erstellt.
    - Falls keine Zeichenarten ausgewählt wurden, wird eine Fehlermeldung ausgegeben und der Benutzer muss eine erneute
      Eingabe tätigen.

3. **Ausgabe des Passworts**
    - Das generierte Passwort wird auf der Konsole ausgegeben.
    - Falls gewünscht, kann der Benutzer mehrere Passwörter generieren lassen.

## Erwartete Ein- und Ausgabe (Beispiel)

```
Willkommen zum Passwort-Generator!  
Bitte gib die gewünschte Passwortlänge ein: 12  
Welche Zeichenarten sollen enthalten sein? (j/n)  
- Kleinbuchstaben (a-z): j  
- Großbuchstaben (A-Z): j  
- Zahlen (0-9): j  
- Sonderzeichen (!@#$%^&*): j  

Soll das Passwort keine wiederholten Zeichen enthalten? (j/n): j  
Soll das Passwort keine aufeinanderfolgenden Zahlen enthalten? (j/n): n  

Generiertes Passwort: A$d8K!p3Qw2m  
```
