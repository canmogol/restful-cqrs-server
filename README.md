# restful-cqrs-server
Restful WS java CQRS(Command Query Responsibility Segregation) server sample

### Query
Query implemented as a package in the same project, but it should be considered as an independent project since it does not share anything with Command package/project.

Please check the [QueryDAO](https://github.com/canmogol/restful-cqrs-server/blob/master/src/main/java/com/fererlab/query/core/dao/QueryDAO.java) class at query side, for query methods.

[AbstractQueryDAO](https://github.com/canmogol/restful-cqrs-server/blob/master/src/main/java/com/fererlab/query/core/dao/AbstractQueryDAO.java) gets its entity manager with unitName <b>QueryPersistenceUnit</b> as below
```java
@PersistenceUnit(unitName = "QueryPersistenceUnit")
private EntityManagerFactory entityManagerFactory;
```

"QueryPersistenceUnit" defined in [persistence.xml](https://github.com/canmogol/restful-cqrs-server/blob/master/src/main/resources/META-INF/persistence.xml) which its user has read only rights and can only execute select queries.
```xml
<persistence-unit name="QueryPersistenceUnit" transaction-type="JTA">
    <!-- PostgresqlQueryDS data source and its user is read only, can only execute select queries -->
    <!--
    do not forget to let the query db user to connect and execute select queries on public schema
    GRANT CONNECT ON DATABASE jpa TO QUERY_PU_USER_NAME;
    GRANT USAGE ON SCHEMA public TO QUERY_PU_USER_NAME;
    GRANT SELECT ON ALL TABLES IN SCHEMA public TO QUERY_PU_USER_NAME;
    -->
    <jta-data-source>java:/PostgresqlQueryDS</jta-data-source>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <properties>
        <property name="hibernate.show_sql" value="true"/>
        <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQL9Dialect"/>
        <property name="hibernate.enable_lazy_load_no_trans" value="true"/>
        <property name="hibernate.archive.autodetection" value="class, hbm"/>
        <property name="hibernate.format_sql" value="true"/>
        <property name="hibernate.temp.use_jdbc_metadata_defaults" value="false"/>
        <property name="hibernate.default_schema" value="public"/>
    </properties>
</persistence-unit>
```


### Command
Command implemented as a package in the same project, but it also should be considered as an independent project since it does not share anything with Query package/project.

Please check the [CommandDAO](https://github.com/canmogol/restful-cqrs-server/blob/master/src/main/java/com/fererlab/command/core/dao/CommandDAO.java) class at command side, for command methods.

[AbstractCommandDAO](https://github.com/canmogol/restful-cqrs-server/blob/master/src/main/java/com/fererlab/command/core/dao/AbstractCommandDAO.java) gets its entity manager with unitName <b>CommandPersistenceUnit</b> as below
```java
@PersistenceUnit(unitName = "CommandPersistenceUnit")
private EntityManagerFactory entityManagerFactory;
```

"CommandPersistenceUnit" defined in [persistence.xml](https://github.com/canmogol/restful-cqrs-server/blob/master/src/main/resources/META-INF/persistence.xml) which its user has all the rights and can execute any query.
```xml
<persistence-unit name="CommandPersistenceUnit" transaction-type="JTA">
    <jta-data-source>java:/PostgresqlDS</jta-data-source>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <properties>
        <property name="hibernate.hbm2ddl.auto" value="update"/>
        <property name="hibernate.show_sql" value="true"/>
        <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQL9Dialect"/>
        <property name="hibernate.enable_lazy_load_no_trans" value="true"/>
        <property name="hibernate.archive.autodetection" value="class, hbm"/>
        <property name="hibernate.format_sql" value="true"/>
        <property name="hibernate.temp.use_jdbc_metadata_defaults" value="false"/>
        <property name="hibernate.default_schema" value="public"/>
    </properties>
</persistence-unit>
```
