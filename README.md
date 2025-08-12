# Internationalization in Quarkus with Property Files, PostgreSQL, and Locale Switching

-> https://www.the-main-thread.com/p/java-quarkus-i18n-multilingual-app
-> https://github.com/myfear/ejq_substack_articles/tree/main/i18n-demo

-> View: http://localhost:8080/greet/db-greet?lang=de  <br>
-> View: http://localhost:8080/?lang=de


In this tutorial, you’ll learn how to make your Quarkus application multilingual using both property files and dynamic messages stored 
in a PostgreSQL database. We’ll also give your users the power to switch languages with a simple dropdown or link in the UI. 
All of this without losing your sanity—or your startup time.

Before jumping into code, let’s clarify the fundamentals. Internationalization (often abbreviated as i18n) refers to the design and 
development of software so that it can be adapted to various languages and regions without engineering changes. Localization (l10n), 
on the other hand, is the process of adapting software for a specific region or language by translating text and adjusting formats for date, 
currency, etc.

In a Quarkus context, i18n means enabling your application to serve localized content based on the user's preferences. 
This is typically handled through message bundles (properties files) or dynamically from a database, depending on your use case. 
You can follow along or just take a look at the Github repository with the running example application.

## quarkus-rest
Adds support for building RESTful web services using JAX-RS with Quarkus’ reactive core. Enables you to expose endpoints using 
annotations like @Path, @GET, @POST, etc.

## quarkus-qute
Integrates the Qute templating engine into your application. Qute is a powerful, type-safe template engine used for generating 
dynamic HTML (or other text formats) with support for localization and reusable components.

## quarkus-hibernate-orm-panache
Adds Hibernate ORM with Panache, a developer-friendly API layer over JPA. It simplifies entity and repository code with conventions and 
utility methods, reducing boilerplate.

## quarkus-jdbc-postgresql
Provides the PostgreSQL JDBC driver and runtime integration. This allows your application to connect to a PostgreSQL 
database using traditional JDBC access patterns or ORM frameworks like Hibernate
