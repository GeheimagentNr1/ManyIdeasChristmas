# CLAUDE.md - ManyIdeas Christmas

## Projekt-Übersicht

**ManyIdeas Christmas** ist ein NeoForge Minecraft Mod.
- **Mod ID**: `manyideas_christmas`
- **Package**: `de.geheimagentnr1.manyideas_christmas`
- **Java Version**: 21 (`develop_26.1`/`develop_26.3`: 25, `jdk-25.0.4.7-hotspot`)
- **NeoForge Version**: je Branch, siehe Tabelle

| Branch | MC | Range | NeoForge (kompiliert gegen) | Core-Jar (`mic_minecraft_version`) | Hinweis |
|---|---|---|---|---|---|
| `develop_1.21.1` | 1.21.1 | `[1.21.1,1.21.10]` (Release 2.0.1, lädt nur auf 1.21.1) | `21.1.216` | 1.21.1 | Kein 2.0.2-Release nötig |
| `develop_1.21.2` | 1.21.2 - 1.21.4 | `[1.21.2,1.21.5)` | `21.2.1-beta` | 1.21.2 | Blöcke per Supplier + `RegistryHelper.withBlockId`, `InteractionResult`-Mapping, `updateShape`-Signatur, Chat-Meldung per `displayClientMessage`, Rezept-JSON, Client-Item-Definitionen, Ketten-Overlay, Keks-Textur im Block-Atlas |
| `develop_1.21.5` | 1.21.5 - 1.21.11 | `[1.21.5,1.21.12)` | `21.5.98` | 1.21.5 | Gleicher Code; eigenes Jar, weil `Level.playSound( Player, .. )` ab 1.21.5 `( Entity, .. )` ist (sonst `NoSuchMethodError`). Bytecode identisch mit Core 1.21.6/1.21.9/1.21.11 |
| `develop_26.1` | 26.1 - 26.2 | `[26.1,26.3)` | `26.1.0.19-beta` (Java 25) | 26.1 | 26.x-Tooling, Katzen-Schnurren über `SoundEvents.CAT_SOUNDS` (`CLASSIC`), `sendSystemMessage`, Kette direkt `iron_chain` |
| `develop_26.3` | 26.3 | `[26.3,27)` | `26.3.0.36-beta` (Java 25) | 26.3 | `Player.drop( .., Prediction.SERVER_ONLY )`, Loot in beiden Formaten (`match_block`, `set_count`, `explosion_decay`) |

2.0.2 released 2026-10-04 (ingame getestet auf 1.21.2, 1.21.4, 1.21.5, 1.21.8, 1.21.9, 1.21.11, 26.1, 26.2, 26.3), abhängig von ManyIdeasCore `[3.0.2,)` und RecipesLibrary `[4.0.1,)` (`rl_minecraft_version`). Details: [`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 4i, [`../Docs/migrations/1.21.11-to-26.1.md`](../Docs/migrations/1.21.11-to-26.1.md).

**Ressourcen:** Kette (goldener Stern, Girlanden) wie ManyIdeasHalloween: Basis-Modelle mit `minecraft:block/iron_chain`, Overlay `mc_1_21_2` (`formats` + `min_format`/`max_format` `[34,64]`) mit `block/chain` für 1.21.2 - 1.21.8; in den 26.x-Branches kein Overlay. Die Keks-Füllung der Schalen nutzt `manyideas_christmas:block/cookie`, geladen per `assets/minecraft/atlases/blocks.json` aus `minecraft:item/cookie` (Block-Modelle dürfen ab 1.21.11 nur Block-Atlas-Texturen nutzen).

Bietet 10 niedliche und festliche Weihnachts-Dekorationsblöcke.

## Abhängigkeiten

- **ManyIdeas Core** (`manyideas_core`) - Required
- **Recipes Library** (`recipes_lib`) - Required

## Projektstruktur

```
src/main/java/de/geheimagentnr1/manyideas_christmas/
├── ManyIdeasChristmas.java                # Haupt-Mod-Klasse (erweitert AbstractMod)
├── elements/
│   ├── block_state_properties/            # Custom BlockState Properties
│   │   ├── BowlContent.java               # Enum für Schüssel-Inhalte
│   │   ├── Connected.java                 # Verbindungs-States
│   │   ├── DecorationType.java            # Dekorations-Typen
│   │   └── ModBlockStateProperties.java   # Property-Definitionen
│   ├── blocks/                            # Block-Definitionen
│   │   └── ModBlocksRegisterFactory.java
│   └── creative_mod_tabs/                 # Creative-Tab Registration
└── helpers/
    ├── DecorateableBlockHelper.java       # Helper für dekorierbare Blöcke
    └── FlameHelper.java                   # Helper für Flammen-Effekte
```

## Architektur

Dieser Mod erweitert `AbstractMod` aus ManyIdeas Core:
```java
@Mod( ManyIdeasChristmas.MODID )
public class ManyIdeasChristmas extends AbstractMod {
    @Override
    protected void initMod() {
        ModBlocksRegisterFactory modBlocksRegisterFactory = registerEventHandler( new ModBlocksRegisterFactory() );
        registerEventHandler( new ModCreativeModeTabRegisterFactory( modBlocksRegisterFactory ) );
    }
}
```

## Besonderheiten

- **Custom BlockState Properties**: Eigene Enums für Block-Zustände (BowlContent, Connected, DecorationType)
- **Helper-Klassen**: Wiederverwendbare Logik für Dekorationen und Flammen

## Code-Stil

- **Annotations**: `@NotNull` aus `org.jetbrains.annotations`
- **Lombok**: Projekt nutzt Lombok
- **Formatierung**: Leerzeichen nach `(` und vor `)` bei Methodenaufrufen

## Build & Test

```bash
./gradlew build
./gradlew runClient
./gradlew runServer
```

## Deployment

- **CurseForge**: `./gradlew curseforge`
- **Modrinth**: `./gradlew modrinth`

## Testing

### Java-Versionen

Verschiedene Java-Versionen sind unter `C:\Program Files\Eclipse Adoptium` installiert. Für einen Gradle-Build muss die passende Java-Version gewählt werden:

```powershell
# Java 21 für MC 1.20.5+ (NeoForge)
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.12.8-hotspot"
./gradlew build
```

### Unit Tests (JUnit 5)

Für reine Logik-Tests ohne Minecraft-Abhängigkeiten:

```bash
./gradlew test
```

Tests liegen unter `src/test/java/`. Ergebnisse: `build/reports/tests/test/index.html`

### NeoForge GameTest Framework

Für Integration Tests in einer echten Minecraft-Umgebung:

```bash
./gradlew runGameTestServer
```

Der triviale GameTest wurde beim 1.21.2-Port entfernt (annotationsbasierte GameTests gibt es ab 1.21.5 nicht mehr; im 1.21.1-Branch noch vorhanden).

### CI/CD (GitHub Actions)

Der Workflow `.github/workflows/build-and-test.yml` führt automatisch aus:
1. **Build**: Kompiliert den Mod
2. **Unit Tests**: Führt JUnit Tests aus
3. **GameTests**: Startet GameTestServer (optional)

### Was kann automatisiert getestet werden?

| Aspekt | Automatisiert? | Methode |
|--------|----------------|---------|
| Utility-Klassen | ✅ | JUnit |
| Config-Parsing | ✅ | JUnit |
| Commands | ✅ | GameTest |
| Block/Item-Verhalten | ✅ | GameTest |
| Multi-MC-Version | ⚠️ Pro Branch | CI Matrix |

## Referenzen

- [NeoForge Migration Primer](https://docs.neoforged.net/primer/docs/) — Dokumentiert API-Aenderungen zwischen Minecraft/NeoForge-Versionen; nuetzlich fuer die Pruefung von Breaking Changes beim Upgrade auf neue Versionen

---

## Wissensdatenbank

Versionsübergreifende Migrations- und Entwicklungs-Erkenntnisse (Breaking Changes, Fixes, Testumgebungs-Patterns) werden zentral in [`../Docs/`](../Docs/) gepflegt. Bei neuen relevanten Erkenntnissen dort ergänzen, nicht nur hier.
