# CLAUDE.md - ManyIdeas Christmas

10 festliche Weihnachts-Dekorationsblöcke: Weihnachtsbaum, goldener Stern, Girlande, Kranz (auch mit Kerze), Kamine (je Holzart), Schalen mit Inhalt (je Holzart), Geschenk, heiße Schokolade, Plüschkatze. Mod-ID `manyideas_christmas`, Package `de.geheimagentnr1.manyideas_christmas`, Client+Server. Baut auf ManyIdeasCore auf.

Diese Datei ist auf allen `develop_*`-Branches identisch; Quelle: `../Docs/mod-claude/ManyIdeasChristmas.md` (Änderungen dort, dann `Docs/tools/sync_mod_claude_md.sh`). Versionsstand: [`../Docs/VERSIONEN.md`](../Docs/VERSIONEN.md).

## Versionen

- Jars, Branches, Ranges und Tags: [`../Docs/VERSIONEN.md`](../Docs/VERSIONEN.md). NeoForge ab `develop_1.21.1`, Forge `develop_1.18.1` - `develop_1.21` plus `develop_1.21.1_forge`.
- Abhängigkeiten werden in `custom.gradle` als Maven-Jars aus `ModdingMavenRepositories` gebunden: `ManyIdeasCore-<mc>:${mic_version}` und `RecipesLibrary-<mc>:${rl_version}`. Bis 1.21.1 (auch Forge) ist `<mc>` = `${minecraft_version}`; ab 1.21.2 `${mic_minecraft_version}`/`${rl_minecraft_version}`, bewusst getrennt von `minecraft_version`, damit ein Christmas-Jar gegen das Core-/RecipesLibrary-Jar der niedrigsten Version kompiliert und mehrere davon abdecken kann.
- Jar-Grenzen hängen hier vor allem an Vanilla-Änderungen (z. B. eigenes Jar ab 1.21.5 wegen `Level.playSound( Player, .. )` → `( Entity, .. )`), nicht nur an Core.
- CurseForge-Projekt `736753`, Modrinth `9P4EZygx`.

## Abhängigkeiten

- **ManyIdeasCore** (`manyideas_core`, required) - `AbstractMod`, Registrierung, Tischsägen-Rezepttyp, Rezept-Zutat `manyideas_core:rainbow_stained_glass_block`.
- **RecipesLibrary** (`recipes_lib`, required ab 1.20.6) - nur JSON: Rezept der heißen Schokolade mit `recipes_lib:components` (Wasserflasche über `potion_contents`).
- Forge 1.20 - 1.21.1-Forge zusätzlich MinecraftForgeAPI ([`../Docs/forge/README.md`](../Docs/forge/README.md)).

## Architektur

- `ManyIdeasChristmas` erweitert Core-`AbstractMod` (Forge 1.20+: aus MinecraftForgeAPI), registriert `ModBlocksRegisterFactory` + `ModCreativeModeTabRegisterFactory`.
- `elements/blocks/christmas/` - `ChristmasTree`, `GoldenStar`, `Garland`, `Present`, `HotChocolate`, `PlushiCat`, `bowls/` (`Bowl` + Holzarten), `fireplaces/` (`Fireplace` + Holzarten), `wreaths/`.
- `elements/block_state_properties/` - `BowlContent`, `Connected`, `DecorationType`, `ModBlockStateProperties`.
- `helpers/DecorateableBlockHelper` (Dekoration per Rechtsklick mit Goldbarren, Süßbeeren, Glowstone-Staub ..), `helpers/FlameHelper` (Flammen-Partikel für Kerzen und Stern); `WreathCandle` wird mit dem Feuerzeug angezündet.
- Ressourcen: Rezepte überwiegend `manyideas_core:table_sawing_stone`; `assets/minecraft/atlases/blocks.json` lädt die Keks-Textur in den Block-Atlas.

## Funktionen, Befehle, Konfiguration

Keine Befehle, keine Config. Blöcke werden per Rechtsklick dekoriert, befüllt oder angezündet; Schalen und Geschenke droppen ihren Inhalt über Loot-Funktionen (`set_count`).

## Fallstricke

- **Registrierung ab 1.21.2:** `RegistryEntry.create( name, () -> new X() )`, Blöcke, die direkt Vanilla-Klassen erweitern, setzen die ID mit `RegistryHelper.withBlockId(..)` (siehe Core).
- **Client-Chat-Meldung** im Client-Zweig von `useItemOn`: ab 1.21.2 `player.displayClientMessage( c, false )`, ab 26.1 wieder `sendSystemMessage( c )`.
- **`getSlotForHand`** fehlt ab 1.21.9 → Hand-Mapping `MAIN_HAND ? MAINHAND : OFFHAND` (alle Versionen).
- **Katzen-Schnurren ab 26.1:** `SoundEvents.CAT_PURR` entfernt → `SoundEvents.CAT_SOUNDS.get( CatSoundVariants.SoundSet.CLASSIC )...purrSound()`.
- **26.3:** `Player.drop( .., Prediction )`; Loot-Tabellen in beiden Formaten, auch `set_count`/`explosion_decay` als `modifier` - alte `functions` werden still ignoriert (Schalen/Geschenke droppen dann ohne Inhalt).
- **Keks-Füllung (ab 1.21.11 Pflicht):** Block-Modelle dürfen nur Block-Atlas-Texturen nutzen → `manyideas_christmas:block/cookie` per `atlases/blocks.json` aus `minecraft:item/cookie` (funktioniert auch auf älteren Versionen).
- **Kette (goldener Stern, Girlanden):** Basis-Modelle mit `block/iron_chain`, für 1.21.2 - 1.21.8 Overlay `mc_1_21_2` mit `formats` **und** `min_format`/`max_format` `[34,64]` und `block/chain`; ein Overlay ab Format 65 mit `formats` verwirft der 1.21.9+-Client komplett (nur Client-Log). 26.x-Branches ohne Overlay.
- **Creative-Tab:** `getDisplayItems()` leer lassen, sonst doppelte Stacks (Absturz ab NeoForge 26.2.0.88).
- bincheck mit gekoppeltem Core-Jar laufen lassen, sonst bleiben Core-API-Unterschiede unsichtbar ([`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 4i).

## Testen

- Allgemein: [`../Docs/testing/README.md`](../Docs/testing/README.md). Mit passendem Core- und RecipesLibrary-Jar in Server-Pack und Client-Instanz.
- Prüfpunkte: alle Blöcke sichtbar (Kette, Kekse - Client-Log auf lila-schwarze Modelle prüfen), Schalen befüllen und abbauen (Inhalt droppt), Geschenk, Kerzenkranz anzünden (Feuerzeug nutzt sich ab, Haupt- und Nebenhand), Plüschkatze schnurrt, Rezept heiße Schokolade (Wasserflasche) und Tischsägen-Rezepte, Kreativinventar öffnen.

## Links

- Wiki: https://github.com/GeheimagentNr1/ManyIdeasChristmas/wiki
- CurseForge: https://www.curseforge.com/minecraft/mc-mods/manyideas-christmas, Modrinth: https://modrinth.com/mod/9P4EZygx
- [`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 4i, [`../Docs/migrations/1.21.11-to-26.1.md`](../Docs/migrations/1.21.11-to-26.1.md), [`../Docs/migrations/BREAKING_CHANGES.md`](../Docs/migrations/BREAKING_CHANGES.md)
