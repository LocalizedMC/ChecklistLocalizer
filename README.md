<img height="120" src="src/main/resources/icon.png" width="120"/>

# Checklist Localizer
<a href="https://www.curseforge.com/minecraft/mc-mods/checklist-localizer">
<img alt="curseforge" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/curseforge_vector.svg">
</a>

Make [Checklist](https://www.curseforge.com/minecraft/mc-mods/checklist) Mod support task localization!

### You can localize it in the following ways:

TLDR: See [example](example)

First, create a new language file (e.g. `en_us.json`).

Then you can use the text contents of `config/checklist/tasks.txt` as a translation key to write the language file. As shown below:
```json
{
  "Example Title": "Localized Title",
  "Task 1": "Localized Task 1",
  "Task 2": "Localized Task 2"
}
```

Finally you'll be able to load it into the resource pack and load the resource pack in the game.