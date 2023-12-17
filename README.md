# DoomaykaCheckStyleCriticPlugin (Плагин gradle для оценки качества кода на основе отчётов CheckStyle)

## Возможности

Данная утилита имеет следующие возможности:

- Автоматический поиск и чтение отчёта CheckStyle.
- Конфигурация поиска отчёта.
- Конфигурация системы подсчёта качества кода.
- Конфигурация выводимых сообщений с результатами оценки.
- Интеграция с gradle
- Полуавтоматическая установка

## Как запустить?

### Зависимости

- JDK 8 и выше
- Gradle 8.0.1 и выше
- Make 5.2 и выше

### Запуск плагина (способ 1)

Для использования плагина необходимо скачать файл (папка example):

- Makefile

Затем данный файл необходимо поместить в директорию приложения.
Пример директории для размещения скриптов:

```bash
MyProject/app
```

Необходимо изменить содержимое своего build.gradle скрипта:

```groovy
buildscript {
    repositories {
        flatDir { dirs 'build/tmp' }
        mavenCentral()
    }

    dependencies {
        classpath "de.undercouch:gradle-download-task:3.4.3"
        classpath "org.eclipse.persistence:org.eclipse.persistence.moxy:3.0.0"
        classpath 'jakarta.xml.bind:jakarta.xml.bind-api:3.0.0'
        classpath 'doomaykacheckstylecriticplugin:parseReport:1.0.0'
    }
}

// ...плагины приложения

apply plugin: 'doomaykacheckstylecriticplugin.parseReport'

//...скрипт пользователя
```

Затем необходимо запустить установку плагина.
Для этого нужно выполнить команду:

```bash
make install
```

Для запуска нужно выполнить команду:

```bash
make checkApp
```

После очистки сборки проекта плагин нужно будет устанавливать заново.

Для получения справки по Make файлу нужно выполнить команду:

```bash
make help
```

### Запуск плагина (способ 2)

Для использования плагина необходимо изменить содержимое своего build.gradle скрипта:

```groovy
buildscript {
    repositories {
        mavenCentral()
		maven { url 'https://jitpack.io' }
    }

    dependencies {
        classpath "org.eclipse.persistence:org.eclipse.persistence.moxy:3.0.0"
        classpath 'jakarta.xml.bind:jakarta.xml.bind-api:3.0.0'
        //classpath 'doomaykacheckstylecriticplugin:parseReport:1.0.0'
		
		classpath 'com.github.Doomaykaka:DoomaykaCheckStyleCriticPlugin:1.0.5'
    }
}

// ...плагины приложения

apply plugin: 'doomaykacheckstylecriticplugin.parseReport'

//...скрипт пользователя
```

Для запуска нужно выполнить команду:

```bash
gradle parseReport
```

## Конфигурация

Для настройки плагина в скрипте build.gradle можно создать блок CheckStyleCritic.
Размещать данный блок необходимо после подключения плагина.

Конфигурационный блок может содержать ряд параметров:

- Параметр errorMultiplier отвечает за множитель оценки ошибок (принимает число).
- Параметр warningMultiplier отвечает за множитель оценки предупреждений (принимает число).
- Параметр refactorMultiplier отвечает за множитель оценки ошибок оформления кода (принимает число).
- Параметр conventionMultiplier отвечает за множитель оценки ошибок стандартов кода (принимает число).
- Параметр XMLpath отвечает за путь к папке с XML файлами отчётов CheckStyle (принимает строку).
- Параметр XMLname отвечает за имя XML файла отчёта CheckStyle (принимает строку).
- Параметр errorMessages отвечает за виды ошибок, которые будут учитываться при получении оценки
  (принимает массив строк).
- Параметр warningMessages отвечает за виды предупреждений, которые будут учитываться при получении оценки
  (принимает массив строк).
- Параметр refactorMessages отвечает за виды ошибок оформления кода, которые будут учитываться при получении оценки
  (принимает массив строк).
- Параметр conventionMessages отвечает за виды ошибок стандартов кода, которые будут учитываться при получении оценки
  (принимает массив строк).
- Параметр messages отвечает за выводимые в консоль сообщения (принимает массив строк).

В сообщениях консоли можно использовать метки для рассчитанных значений:

- %lc (число обработанных строк)
- %emp (множитель оценки ошибок)
- %wmp (множитель оценки предупреждений)
- %rmp (множитель оценки ошибок оформления кода)
- %cmp (множитель оценки ошибок стандартов кода)
- %ect (количество ошибок)
- %wct (количество предупреждений)
- %rct (количество ошибок оформления кода)
- %cct (количество ошибок стандартов кода)
- %r (оценка)

Пример конфигурационного блока:

```groovy
apply plugin: 'doomaykacheckstylecriticplugin.parseReport'

CheckStyleCritic{
    messages = [
        "\\\\Doomayka CheckStyle critic//",
        "Lines prepared: %lc",
        "By expression: 10-((%emp*%ect+%wmp*%wct+%rmp*%rct+%cmp*%cct)/%lc)*10",
        "V01d result: %r"
    ] as String[]

    conventionMultiplier = 1
}
```
