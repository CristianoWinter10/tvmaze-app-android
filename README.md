This project will be keep improving...

# TVmaze Android Application

A  Mobile Application Version that consumes TVmaze API 

## Installation and how to run

Android Studio 4.+ 
The SDK target used to compile the Application is the version 31

## Arquitetura MVVM + Clean Architecture

The application uses MVVM Architecture in order to provide a better communication between the layers of View, State and Data.

Also was applied the clean architecture providing a better separation of Views, Business Rules, Datasources, it provides us a lot of benefits, as maintainability, unit tests, a better way to apply SOLID Principals and so much more.

## Packages project structure

The project uses the following packages structure:

- ### Business
  In this package are the UseCases, these classes provide us the business logic and also are responsible to communicate with the repositories
  
- ### Common
  In this package are some of the Helper Classes that are common between the packages

- ### Datasource
  In this package are all repositories classes and its dependencies, here are the layers for local datasource and remote datasource as well

- ### Domain
  In this package are the Models, Dtos and Entities classes

- ### Presentation
  This package contains all classes that represent the view, this package contains Activities, Fragments, ViewModels

* Each package contains internal packages in order to separate by business content

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


