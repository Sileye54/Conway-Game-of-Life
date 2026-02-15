# Jeu de la Vie de Conway - Conway's Game of Life

Implémentation en Java du célèbre automate cellulaire "Jeu de la Vie" créé par John Horton Conway en 1970.

## Description

Ce projet est un travail pratique (TP1) pour le cours **INF5153** à l'**UQAM**. Il implémente le Jeu de la Vie de Conway avec les éléments suivants :

- Simulation d'un automate cellulaire sur une grille 2D
- Gestion de l'état des cellules (vivantes/mortes)
- Application des règles classiques du jeu de la vie
- Support de fichiers de configuration pour les patterns initiaux
- Validation des arguments et des formats d'entrée

### Règles du Jeu de la Vie

Le jeu fonctionne sur une grille de cellules pouvant être soit vivantes (X), soit mortes (_). À chaque génération :

1. Toute cellule vivante avec 2 ou 3 voisins vivants survit
2. Toute cellule morte avec exactement 3 voisins vivants devient vivante
3. Toutes les autres cellules meurent ou restent mortes

## Démarrage Rapide

### Prérequis

- **Java** 13 ou supérieure
- **Maven** 3.6 ou supérieure

### Installation

```bash
git clone https://github.com/Sileye54/Conway-Game-of-Life.git
cd automne2025-inf5153-tp1
```

### Compilation

```bash
mvn clean compile
```

### Exécution

```bash
mvn exec:java
```

Ou avec un fichier de pattern spécifique :

```bash
mvn exec:java -Dexec.args="<fichier_de_config>"
```

## Structure du Projet

```
.
├── src/
│   ├── main/java/conway/          # Code source principal
│   │   ├── Main.java              # Point d'entrée
│   │   ├── Conway.java            # Orchestrateur du jeu
│   │   ├── ConwayBoard.java        # Gestion du plateau
│   │   ├── ConwayCell.java         # Cellule du jeu
│   │   ├── Board.java              # Interface générique du plateau
│   │   ├── Cell.java               # Interface générique de cellule
│   │   ├── CellState.java          # Énumération des états
│   │   ├── Position.java           # Représentation des coordonnées
│   │   ├── ConwayGameArguments.java # Parser des arguments
│   │   └── Exceptions/             # Exceptions personnalisées
│   └── test/java/                  # Tests unitaires
├── _examples/                       # Fichiers d'exemple de patterns
│   ├── beehive.txt                 # Ruche (statique)
│   ├── blinker.txt                 # Clignotant (période 2)
│   ├── block.txt                   # Bloc (statique)
│   ├── boat.txt                    # Bateau (statique)
│   ├── diehard.txt                 # Mourant (période 130)
│   ├── loaf.txt                    # Pain (statique)
│   └── toad.txt                    # Crapaud (période 2)
├── _models/                         # Diagrammes UML (PlantUML)
│   ├── class_diagram.puml
│   ├── object_diagram.puml
│   └── sequence_diagram.puml
├── pom.xml                          # Configuration Maven
├── Makefile                         # Build des diagrammes
└── README.md                        # C Ce fichier
```

## Format des Fichiers de Configuration

Les fichiers de patterns doivent respecter le format suivant :

```
<taille_grille>
<ligne_1>
<ligne_2>
...
<ligne_n>
```

### Exemple - Pattern "Blinker" (oscillateur)

```
5
_ _ _ _ _
_ _ _ _ _
_ X X X _
_ _ _ _ _
_ _ _ _ _
```

- Les cellules **X** sont vivantes
- Les cellules **_** sont mortes
- Les éléments sont séparés par des espaces


## Patterns Inclus

| Pattern | Fichier | Type | Description |
|---------|---------|------|-------------|
| Blinker | `blinker.txt` | Oscillateur | Période 2, alterne entre horizontal et vertical |
| Block | `block.txt` | Statique | Carré stable de 4 cellules |
| Beehive | `beehive.txt` | Statique | Ruche de 6 cellules |
| Boat | `boat.txt` | Statique | Bateau de 5 cellules |
| Toad | `toad.txt` | Oscillateur | Période 2 |
| Loaf | `loaf.txt` | Statique | Pain de 8 cellules |
| Diehard | `diehard.txt` | Méthuselah | Période 130 avant extinction |

## Architecture

Le projet suit une architecture orientée objet avec :

- **Interfaces** : `Board`, `Cell`, `GameArguments` pour l'extensibilité
- **Implémentations concrètes** : `ConwayBoard`, `ConwayCell`, `ConwayGameArguments`
- **Exceptions personnalisées** : Gestion fine des erreurs d'entrée
- **Séparation des responsabilités** : Parser, plateau, cellule, simulation

Consultez les diagrammes UML dans le dossier `_models/` pour plus de détails.

