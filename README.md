
Entwickler: Jakob Merten - 587527
            Yann Ditengou - 587245 
Projektname: "1Share"
Projektbeschreibung: Onlineforum das Nutzern ermöglicht sich über verschidene musikalische
                     Genren auszutauschen
Vorgesehene Funktionen: Anmelden, Ausloggen, Forum wählen, Post ertstellen,
                        Post beantworten (extra: Dateien anängen um musikalische
                        Kollaborationen zwischen Künstlern zu ermöglichen)


Beschreibung des Backends: 

Das Backend von 1share nimmt Anfragen vom Frontend entgegen und managed die Kommunikation mit der Datenbank.
Daraufhin werden die Antworten aus der Datenbank, beispielsweise eine Liste von Posts an das Frontend gesendet.
Das Backend ist eine REST-API und es ist deployed auf: https://oneshare-backend.onrender.com
