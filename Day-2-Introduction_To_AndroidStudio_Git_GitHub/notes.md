**Native Application -** a software program developed for use on a particular platform or device using its native programming languages & tools

**Cross platform Application -** designed to work on multiple OS & devices using a sinle codebase . Cross-paltform frameworks - Flutter | React Native | Xamarin

**Software engineering concepts -** 

**SRS (Software Requirements & Specification) -** Document that details what the application needs to do , the scope of the project, the timeline, & the required functionalities . It serves as blueprint for development process

**Proof of concept -** a small project to test if an idea or approach is feasible. Small scale implementation of a project to test its feasibility & validate the requirements.

**Key e-commerce app functionalities**

- User registration & login
- Product catalog
- cart management
- payment
- order tracking

**SDLC (Software Development Lifecycle)**

- a structured process for developing software
- includes : planning | design | implementation | testing | deployment

UI → User Interface → how the app looks

UX → User Experience → how the app feels & how easy it is to use

Note - 

- choosing a right development framework is crucial for efficiency & performance
- for simple apps, cross paltform development can save time & effort compared to native development

**UAT (User Acceptance Testing)**

- testing the app with a set of users to ensure that it meets their requirements
- this includes distributing the application to users, explaining the functionalities, users test the app functionalities to ensure they work as expected, gathering feedback
- after successful UAT , the application is ready for production deployment

Android apps are deployed on Google playstore , submit an .apk file that follows the guidelines

**Beta deployments -** involve releasing the app to a limited number of users for further testing & feedback

**Beta testers -** group  of users who test the app before its official release to find & fix issues

**Agile -** an iterative approach to development with frequent releases

**Scrum** - a framework within agile with defined roles, events, & artefacts

**Kanban -** a visual system for managing work as it moves through a process

**JIRA -** a tool to track the development tasks, bugs & progress

**QA (Quality Assurance) -** ensuring the application is of high quality by testing it htoroughly

**Story Point -** a unit of measure for estimating the effort required to complete a task in agile development

**Android Studio -** official IDE for Android development

**XCode -** IDE for iOS, macOS , watchOS, tvOS developmet

**Setting up project :-**

Download & install Android Studio → new project → choose “Empty Activity” → name your project → selct minimum SDK version → Kotlin DSL → finish setup

**Project Directory Structure :-**

When you create a new project in Android Studio with an empty activity, the IDE sets up a basic project directory structure. Below is the explanation of all the important files and directories in the default setup:

```
root/
├── build.gradle
├── settings.gradle
├── app/
│   ├── build.gradle
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── myapplication/
│   │   │   │               └── MainActivity.java (or MainActivity.kt)
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml
│   │   │   │   ├── mipmap/
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── styles.xml
├── gradle/
│   ├── wrapper/
│   │   └── gradle-wrapper.properties
├── gradle.properties
|
|
```

### Project Root Directory

1. **`build.gradle` (project level)**:
    - This file is the top-level build script where you can add configuration options common to all sub-projects/modules.
    - It includes things like classpaths for plugins and dependencies used across the entire project.
2. **`settings.gradle`**:
    - This file tells Gradle which modules to include in the build.
    - For a single-module project, it typically includes only the `app` module.

### `app` Module Directory

1. **`build.gradle` (app level)**:
    - This is the build script specific to the app module.
    - It contains configurations for compiling the app, including dependencies, default configurations, and build types (e.g., debug and release).
2. **`src/main`**:
    - **`AndroidManifest.xml`**:
        - This file declares the application components, permissions, and other essential app metadata.
        - It is required for every Android application.
    - **`java/`**:
        - This directory contains the Java (or Kotlin) source files for the application. The default package structure usually mirrors the application ID specified in the `build.gradle` file.
        - **`MainActivity.java` (or `MainActivity.kt`)**:
            - This is the main activity file generated by default.
            - It contains the code for the main entry point of the app when it launches.
    - **`res/`**:
        - This directory contains all the non-code resources, such as layout files, drawable files (images), and values (strings, colors, and styles).
        - **`drawable/`**:
            - Directory for drawable resources (e.g., PNG, JPEG files).
        - **`layout/`**:
            - Directory for XML layout files.
            - **`activity_main.xml`**:
                - The default layout file for the main activity.
        - **`mipmap/`**:
            - Directory for launcher icons. It contains different resolution versions of the app icon.
        - **`values/`**:
            - Directory for XML files that define various resources.
            - **`strings.xml`**:
                - Contains string resources used in the app.
            - **`colors.xml`**:
                - Defines color resources.
            - **`styles.xml`**:
                - Defines style and theme resources.

### Gradle Wrapper

1. **`gradle/`**:
    - **`wrapper/`**:
        - Contains the Gradle Wrapper files, which allow the project to be built with a specific version of Gradle regardless of whether that version is installed on the build machine.
        - **`gradle-wrapper.properties`**:
            - Specifies the version of Gradle to use and the URL to download it if it's not already available.
2. **`gradle.properties`**:
    - Optional file to configure properties for the Gradle build system. It can include settings like JVM arguments.

**Jetpack Compose -** modern toolkit for building native UI in Android

**Emulator -** virtual device to test your app

**Logcat -** tool to view logs & debug your app

---

**Version Control System (VCS)**

- helps developers manage changes to source code over time
- allows people to collaborate on a project
- keeps a history of changes
- facilitate tracking & merging different versions of codebase

**Git**

- distributed VCS that allows multiple developers to work on a project simultaneously without overwriting each others changes
- provides tools for tracking changes, branching, merging & maintaining the history of a project

**Github -** web based platform that provides hosting for git repositories along with additional collaboration and project management tools

**Repository -** a directory containing the project files, a staging area , & the Git directory with metadata & history

**Branch -** Parallel version of the repository, allowing multiple lines of development

**Commit -** saving changes to the repository, creating a snapshot of the current state

**Merge -** combining changes from different branches

**Pull -** fetching changes from a remote repository & merging them into local repository

**Push -** uploading local changes / sending local commits to a remote repository

**Clone -** making a copy of a repository

- **`git init`**:
    - Initializes a new Git repository in the current directory. It creates a `.git` subdirectory where all the metadata and object store for the repository are kept.
    - Example usage: `git init`
- **`git clone <url>`**:
    - Creates a copy of an existing Git repository from a specified URL (typically from a remote server like GitHub, GitLab, or Bitbucket) to your local machine.
    - Example usage: `git clone https://github.com/user/repo.git`
- **`git status`**:
    - Displays the state of the working directory and the staging area. It shows which changes have been staged, which haven’t, and which files aren’t being tracked by Git.
    - Example usage: `git status`
- **`git add .`**:
    - Adds all changes in the current directory (including new files, modifications, and deletions) to the staging area, preparing them to be included in the next commit.
    - Example usage: `git add .`
- **`git commit -m "<commit message>"`**:
    - Records the changes in the staging area to the repository with a descriptive message explaining what the changes do.
    - Example usage: `git commit -m "Add new feature"`
- **`git push origin <branch_name>`**:
    - Sends the committed changes from your local repository to the remote repository, specifically to the specified branch.
    - Example usage: `git push origin main`
- **`git pull origin <branch_name>`**:
    - Fetches changes from the specified branch on the remote repository and merges them into your current local branch. This is a combination of `git fetch` followed by `git merge`.
    - Example usage: `git pull origin main`
- **`git branch <branch_name>`**:
    - Creates a new branch with the specified name. This branch is a copy of the current branch at the time of creation.
    - Example usage: `git branch new-feature`
- **`git checkout <branch_name>`**:
    - Switches to the specified branch, updating the working directory to match the state of that branch.
    - Example usage: `git checkout new-feature`