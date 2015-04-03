## Was sind dynamische Typen? ##

Verschiedene Objekte haben verschiedene Attribute: Notebooks, Räume und Fahrzeuge haben ihre eigenen
Charakteristika, Vorlesungen haben andere Attribute als Meetings oder Konferenzen.
Sie können Rapla auf Ihre Bedürfnisse anpassen, indem Sie einfach Resourcen- Personen oder Veranstaltungstypen erzeugen oder ändern.

Wenn Sie Räume verwalten, können Sie einen Ressourcentyp "Raum" erzeugen und Attribute wie "Anzahl Stühle", "Fachbereich" oder "hat Tafel" hinzufügen.

Wenn Sie Veranstaltungen verwalten erstellen Sie einen Veranstaltungstyp "Veranstaltung" mit den Attributen "Jahr" und "Teilnehmender Kurs".

Weil Sie solche Attribute zur Laufzeit anlegen und ändern können, werden diese Typen Dynamische Typen genannt.


## Beispiel: Erzeugen eines Ressourcentyps "Raum" ##

Klicken Sie auf das 'Ressourcen und Personen'-Icon im linken Menü, wählen Sie 'Ressourcentypen', klicken Sie auf 'neuer Ressourcentyp' und geben Sie "Raum" in das Feld 'Name des Typs' ein.

Fügen Sie nun ein Attribut mit dem Namen "Anzahl Stühle" ein und wählen Sie als Typ "ganze Zahl". Speichern Sie durch klick auf "speichern".

Um Räume anzulegen, wechseln Sie zum Kalender, rechtsklicken Sie in der Liste und wählen Sie "Raum" in der Combobox in der oberen linken Ecke. Sie können nun den Namen des Raums und die "Anzahl der Stühle" eingeben.

## Hinzufügen eines Kategorie-Attributs an den Ressourcentyp "Raum" ##

Wir möchten die Räume jetzt dem Fachbereich, der sie angehören, zuweisen. Wir tun dies, indem wir ein Attribut der Typ "Kategorie" hinzufügen. Davor müssen wir unsere Fachbereiche in [der Kategorieansicht](KategorienDialog.md) anlegen. Erzeugen Sie eine neue Kategorie mit dem Namen "Fachbereiche" und fügen Sie drei Unterkategorien ein: "Fachbereich A", "Fachbereich B" und "Fachbereich C".

Speichern Sie die Kategorien und wechseln Sie zur Bearbeitungsansicht des Ressourcentyps "Raum". Fügen Sie ein drittes Attribut mit dem Namen "Fachbereich" ein, wählen Sie als Datentyp 'Kategorie' und klicken Sie auf das 'Wurzel'-Icon. Nun können Sie eine Kategorie auswählen, die die möglichen Auswahlwerte dieses Attributs bestimmt. Wählen Sie "Fachbereiche" als Wurzel. Speichern Sie den geänderten Ressourcentyp und legen Sie einen neuen Raum an. Sie sollten jetzt einen Fachbereich für den Raum auswählen können.

## Attribute zum Filtern verwenden ##

Dynamische Attribute haben hauptsächlich informativen Charakter, können aber auch zum [filtern|Filter] verwendet werden:

```
Zeige mir nur die Räume des Fachbereichs A im ersten Stock.
```
oder

```
Zeige mir Einführungsvorlesungen und Vorlesungen des Fachbereichs Informatik.
```