# Contributing to ZZZ Archive

Thank you for your interest in contributing to ZZZ Archive! This document provides guidelines and
instructions for contributing to this Kotlin Multiplatform project.

## Table of Contents

- [Getting Started](#getting-started)
- [Development Environment](#development-environment)
- [Code Quality Standards](#code-quality-standards)
- [Pull Request Process](#pull-request-process)
- [Project Structure](#project-structure)
- [Architecture Guidelines](#architecture-guidelines)
- [Testing](#testing)
- [Commit Guidelines](#commit-guidelines)

## Getting Started

### Prerequisites

- **Android Studio** - Recommended IDE with Kotlin Multiplatform support
- **XCode** - Recommended IDE with Kotlin Multiplatform support
- **Git** - Version control

### Fork and Clone

1. Fork the repository on GitHub
2. Clone your fork locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/ZZZ-Archive.git
   cd ZZZ-Archive
   ```
3. Add the upstream repository:
   ```bash
   git remote add upstream https://github.com/mrfatworm/ZZZ-Archive.git
   ```

## Development Environment

### Local Setup

1. **Build the project**:
   ```bash
   ./gradlew build
   ```

2. **Run on Desktop**:
   ```bash
   # Regular run
   ./gradlew run
   
   # Hot reload development
   ./gradlew runHot
   ```

## Code Quality Standards

### Kotlin Code Style Check

This project uses [kotlinter](https://github.com/jeremymailen/kotlinter-gradle) for Kotlin code
style enforcement. Before submitting a PR, ensure your code passes the style checks:

#### Check Code Style

```bash
./gradlew lintKotlin
```

#### Auto-fix Code Style Issues

```bash
./gradlew formatKotlin
```

### Code Style Guidelines

- **Kotlin**: Follow official Kotlin coding conventions
- **Compose**: Use Material 3 design system
- **Architecture**: Follow MVI (Model-View-Intent) pattern
- **Naming**: Use descriptive names for classes, functions, and variables
- **Comments**: Document complex business logic and platform-specific code

## Pull Request Process

### Before Submitting a PR

1. **Create a feature branch**:
   ```bash
   # Base on "dev" branch
   git checkout -b f/your-feature-name
   ```

2. **Make your changes** following the project's architecture and coding standards

3. **Run code quality checks**:
   ```bash
   # Check Kotlin style
   ./gradlew lintKotlin
   
   # Auto-fix style issues
   ./gradlew formatKotlin
   
   # Run tests
   ./gradlew test
   ```

4. **Test on multiple platforms**:
    - Android (if applicable)
    - Desktop
    - iOS (if applicable)

5. **Commit your changes**:
   ```bash
   git add .
   git commit -m "feat: your feature description"
   ```

6. **Push to your fork**:
   ```bash
   git push origin feature/your-feature-name
   ```

### CI Checks

The CI workflow will automatically run:

- `test` - Unit test
- `lintKotlin` - Kotlin code style checks

Only PRs that pass all checks will be considered for merging.

## Project Structure

```
composeApp/src/
├── commonMain/          # Shared code for all platforms
│   ├── kotlin/
│   │   ├── di/         # Dependency injection modules
│   │   ├── feature/    # Feature modules (MVI architecture)
│   │   ├── database/   # Room database setup
│   │   ├── datastore/  # DataStore preferences
│   │   ├── network/    # Ktor networking
│   │   ├── ui/         # Shared UI components
│   │   └── utils/      # Common utilities
├── androidMain/         # Android-specific code
├── iosMain/            # iOS-specific code
├── desktopMain/        # Desktop-specific code
└── main/               # Main entry point
```

## Architecture Guidelines

### MVI (Model-View-Intent) Architecture

Each feature should follow the MVI pattern:

```kotlin
// Model - State classes
data class FeatureState(
    val data: List<Item> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

// Intent - Action classes
sealed interface FeatureAction {
    data class ClickItem(val id: Int) : FeatureAction
    data object Refresh : FeatureAction
}

// ViewModel - Business logic
class FeatureViewModel(
    private val useCase: FeatureUseCase
) : ViewModel() {
    private var _uiState = MutableStateFlow(FeatureState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: FeatureAction) {
        when (action) {
            // Handle actions
        }
    }
}
```

### Feature Module Structure

```
feature/
├── feature_name/
│   ├── components/     # Shared UI Components
│   ├── data/           # Data layer (Repository, Database, Network)
│   ├── domain/         # Business logic (Use Cases)
│   ├── presentation/   # UI layer (ViewModel, Screen)
│   └── model/          # Data models and state
```

### Dependency Injection with Koin

- Use `koinViewModel()` for ViewModels in Compose
- Define modules in `di/Modules.kt`
- Platform-specific modules for each target

## Testing

### Unit Tests

```bash
./gradlew :composeApp:testDevDebugUnitTest
```

### Test Guidelines

- Write unit tests for ViewModels
- Use MockK or Fake Class for mocking dependencies
- Test MVI state transitions
- Test error handling scenarios

## Commit Guidelines

We follow [Conventional Commits](https://www.conventionalcommits.org/) specification:

### Format

```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```

### Types

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

### Examples

```bash
git commit -m "feat: Add agent detail screen"
git commit -m "fix: Resolve navigation issue in main screen"
git commit -m "docs: Update contributing guidelines"
```

## Getting Help

- **Issues**: Check existing issues or create a new one
- **Discussions**: Use GitHub Discussions for questions
- **Documentation**: Refer to project documentation and comments

## Code Review Process

1. **Automated Checks**: CI must pass all checks
2. **Code Review**: At least one maintainer must approve
3. **Testing**: Changes must be tested on relevant platforms
4. **Documentation**: Update docs if needed

## License

By contributing to ZZZ Archive, you agree that your contributions will be licensed under the same
license as the project.

---

Thank you for contributing to ZZZ Archive! 🎮
