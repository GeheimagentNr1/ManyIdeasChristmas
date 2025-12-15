# AGENTS.md - ManyIdeas Christmas

## Projekt-Übersicht

**ManyIdeas Christmas** ist ein NeoForge Minecraft Mod für Minecraft 1.21.1.
- **Mod ID**: `manyideas_christmas`
- **Package**: `de.geheimagentnr1.manyideas_christmas`
- **Java Version**: 21
- **NeoForge Version**: 21.1.x

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
