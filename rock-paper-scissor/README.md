# Rock-Paper-Scissors Console Game

A clean, production-style Java console implementation of Rock–Paper–Scissors Game.

## Features

- Hand signal translator for input (FIST, OPEN_HAND, INM_FINGERS → Rock, Paper, Scissors)
- Extensible `Move` interface for Rock, Paper, Scissors
- Scoreboard tracking wins, losses, and draws
- Clear separation of packages: `model`, `service`, `utils`, `ui`
- Comprehensive testing with JUnit 5

## Requirements

- Java 17 or higher
- Maven 3.8 or higher

## Package Structure

    com.example.rps
    |── model   →  Domain objects and enums (Move, Rock, Paper, Scissors, Result)
    |── service →  Business logic (GameService, GameServiceImpl, MoveFactory, Scoreboard)
    |── utils   →  Helper classes and utilities (HandSignalTranslator)
    |── ui      →  Console UI (GameRunner)

## Running the Game

```bash
./run.sh
```

Or, running from an IDE:

You can also run the game directly from an IDE (e.g., IntelliJ, Eclipse) by executing the `com.kvvssut.rps.Main` class.

## Running Tests

```bash
./test.sh
```

## Design Patterns Used

- **Strategy Pattern** → Each move (`Rock`, `Paper`, `Scissors`) implements `Move` interface
- **Factory Pattern** → `MoveFactory` generates random computer moves
- **Translator** → `HandSignalTranslator` converts hand signals to moves
- **Separation of Concerns** → Clear separation between domain, service, utilities, and UI

---
