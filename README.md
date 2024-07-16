## Conexion a BD postgreSql

### Nombre de la base de datos
bibliarysv
### Nombre del usuario
* user: saquicelavilla
* contraseña: clave_123

### Data source
Para el archivo "standalone" del Wildfly se ha añadido lo siguiente (hacer clic en RAW que esta en la parte superior derecha para ver las etiquetas completas):

<datasource jta="true" jndi-name="java:jboss/datasources/bibliarysvDS" pool-name="bibliarysv" enabled="true" use-java-context="true" use-ccm="true">
           <connection-url>jdbc:postgresql://localhost:5432/bibliarysv</connection-url>
           <driver>postgresql-driver</driver>
           <security user-name="saquicelavilla" password="clave_123"/>
</datasource>
