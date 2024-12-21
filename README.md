# Comenzando

### Documentación de referencia

Para más referencia, por favor considera las siguientes secciones:

* [Documentación oficial de Apache Maven](https://maven.apache.org/guides/index.html)
* [Guía de referencia del plugin Maven de Spring Boot](https://docs.spring.io/spring-boot/3.4.1/maven-plugin)
* [Crear una imagen OCI](https://docs.spring.io/spring-boot/3.4.1/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.1/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.1/reference/using/devtools.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.1/reference/web/servlet.html)

### Guías

Las siguientes guías ilustran cómo utilizar algunas características de forma concreta:

* [Acceder a datos con JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Acceder a datos con MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Construir un servicio web RESTful](https://spring.io/guides/gs/rest-service/)
* [Servir contenido web con Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Construir servicios REST con Spring](https://spring.io/guides/tutorials/rest/)

### Sobrescritura del padre en Maven

Debido al diseño de Maven, los elementos se heredan del POM padre al POM del proyecto.
Aunque la mayoría de esta herencia está bien, también hereda elementos no deseados como `<license>` y `<developers>` del
padre.

En Maven, estos elementos no son "dependencias" propiamente dichas, sino más bien secciones de configuración del archivo pom.xml. 
A continuación, te explico brevemente la función de cada uno:
## 1. licenses y  license
Esta sección se utiliza para declarar la(s) licencia(s) bajo la cual se distribuye el proyecto. 
Esto es útil si tus usuarios o cualquier repositorio necesitan saber los términos de uso de tu proyecto.
### licenses:
Declara una lista de licencias.
### license: 
Representa una licencia específica dentro de <licenses>.
Finalidad: Es principalmente informativa, no funcional. 
Ayuda a los usuarios y herramientas automatizadas a identificar los términos legales del código.
Esta sección se usa para listar los desarrolladores que participan en el proyecto. Esto es solo una información descriptiva útil para los usuarios.
<developers>: Contiene una lista de los desarrolladores principales del proyecto.
<developer>: Representa un desarrollador individual.
Finalidad: Es descriptiva y da crédito a los participantes del proyecto.
3. scm (Source Control Management)
El elemento scm describe la configuración del control de versiones del proyecto. Sirve para indicar el repositorio
4. donde se encuentra el código fuente del proyecto, además de proporcionar información sobre cómo interactuar con el mismo.
### connection: 
La URL de acceso para la conexión de solo lectura al repositorio (usada por herramientas como Maven para obtener el código).
### developerConnection:
Similar a connection, pero con permisos adicionales (lectura/escritura), para que los desarrolladores puedan enviar cambios.
### tag>:
Especifica una etiqueta utilizada en el control de versiones para identificar una versión particular del código fuente, como v1.0.0.
## url>:
La URL general para acceder al repositorio (puede ser una página web, interfaz pública del repositorio, etc.).
