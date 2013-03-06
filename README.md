lein-artifact
=============

Leiningen plugin to build/install artifacts configured by project.clj.

Useful when using lein-ring, libs and parent-sub projects. A :artifact key in a
:ring map in project.clj can specify the artifact to build.

Defaults to lein install.

```clojure
(defproject core "0.1.0-SNAPSHOT"
  ...)
```

```clojure
(defproject app "0.1.0-SNAPSHOT"
  ...
  :ring {:handler ...
         :artifact :uberwar}
  ...)
```

```clojure
(defproject www "0.1.0-SNAPSHOT"
  ...
  :ring {:handler ...
         :artifact :war}
  ...)
```

```clojure
(defproject parent "0.1.0-SNAPSHOT"
  ...

  :sub ["core" "app" "www"]

  ...)
```

```bash
$ lein sub with-profile prod artifact

> Reading project from core
> Performing task 'artifact' with profile(s): 'prod'
> Created core/target/core-0.1.0-SNAPSHOT.jar
> Wrote core/pom.xml
> Installing core/target/core-0.1.0-SNAPSHOT.jar

> Reading project from app
> Performing task 'artifact' with profile(s): 'prod'
> Created app/target/app-0.1.0-SNAPSHOT-standalone.war

> Reading project from www
> Performing task 'artifact' with profile(s): 'prod'
> Created www/target/www-0.1.0-SNAPSHOT.war
```
