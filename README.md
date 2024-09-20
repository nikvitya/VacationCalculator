# VacationCalculator

Приложение "Калькулятор отпускных".
Микросервис на SpringBoot + Java 11 c одним API:
GET "/calculacte"

Приложение принимает твою среднюю зарплату за 12 месяцев и количество дней отпуска - отвечает суммой отпускных, которые придут сотруднику.
Доп. задание: При запросе также можно указать точные дни ухода в отпуск, тогда должен проводиться рассчет отпускных с учётом праздников и выходных.
Желательно написание юнит-тестов, проверяющих расчет.

# Использованные технологии
[![Java](https://img.shields.io/badge/-Java%2011-F29111?style=for-the-badge&logo=java&logoColor=e38873)](https://www.oracle.com/java/)
[![Spring](https://img.shields.io/badge/-Spring%20Boot%202.7.10-6AAD3D?style=for-the-badge&logo=spring&logoColor=90fd87)](https://spring.io/projects/spring-framework)
[![Maven](https://img.shields.io/badge/-Maven-7D2675?style=for-the-badge&logo=apache&logoColor=e38873)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![JUnit](https://img.shields.io/badge/JUnit%205-6CA315?style=for-the-badge&logo=JUnit&logoColor=white)](https://junit.org/junit5/docs/current/user-guide/)
[![Mockito](https://img.shields.io/badge/-mockito%204.5.1-6CA315?style=for-the-badge&logo=mockito&logoColor=90fd87)](https://site.mockito.org/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)
[![RestAPI](https://img.shields.io/badge/-rest%20api-007EC0?style=for-the-badge&logo=restapi&logoColor=275ecf)](https://restfulapi.net/)

# Как начать разработку?

1. Сначала необходимо перейти по ссылке
```shell
https://github.com/nikvitya/VacationCalculator
```
2. На открвышемся сайте нужно склоинровать репозиторий в IntelliJ Idea
```shell
#URL
https://github.com/nikvitya/VacationCalculator.git
```
Для этого необходимо:
* При открытии приложения выбрать вкладку
```shell
VCS
```
* Во вкладку URL вставить URL репозитория:
```shell
#URL для VCS
https://github.com/nikvitya/VacationCalculator.git
```
* Нажмите "Clone"
* Ждём полного клонирования репозитория и установки всех необходимых зависимостей для проекта

# Как запустить и использовать
Для запуска установите и откройте программу [Docker Desktop](https://www.docker.com/products/docker-desktop/).

В командной строке перейдите в корень проекта. Далее
   ```
mvn clean package
   ```
   ```
docker-compose up
   ```
Приложение готово к использованию! Сервис доступен по андресу [http://localhost:8080](http://localhost:8080)

# Проверить работоспособность проекта
вы можете с помощью программы [Postman](https://www.postman.com/downloads/)
* Для этого необходимо:
1. File -> Import:
2. Запустите коллекция, нажав "Run".
