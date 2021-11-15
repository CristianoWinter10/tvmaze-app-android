This project will be keep improving soon...

# TVmaze Android Application

An  Mobile Application Version that consumes TVmaze API 

## Instalation and how to run

Android Studio 4.+ 
The SDK target used to compile the Application is the version 31

## Arquitetura MVVM + Clean Architecture

The application uses MVVM Archtecture in order to provide a better communication between the layers of View, State and Data.

Also was applied the clea architecture providing a better separation of Views, Business Rules, Datasources, it provides us a lot of benefits, as maintainability, unit tests, a better way to apply SOLID Principals and so much more.

## Packages project strutucture

The project uses uses the following packages structure:

- ### Business
  In this package are the UseCases, these classes provide us the business logical and also are responsable to communicate with the repositories
  
- ### Common
  In this package are the some Helper Classes that are common the packages

- ### Datasource
  In this package are all repositories classes and its dependencies, here are the layers for local datasource and remote datasoure as well

- ### Domain
  In this package are the Models, Dtos and Entities classes

- ### Presentation
  This package contains all classes that represent the view, this package contains Acvities, Fragments, ViewModels

* Each package contains internal packages in order to separade by business content

## Libraries

- MVVM + Data binding
- Navigation Component
- ViewModel
- LiveData
- Flow
- Coil
- Coroutines
- Koin
- Mockito
- Retrofit


