# Play Angular

### frontend
install node modules
```
$ npm install
```

install webpack loaders

```
$ npm install ng-router-loader awesome-typescript-loader angular2-template-loader --save-dev 
$ npm install to-string-loader style-loader css-loader --save-dev
$ npm install lodash moment include-media bootstrap --save
```

test
```
npm run start:withProxy
```

### backend

test
```
$ sbt dist
```

Running (Prod)
```
$ play-slick-example-1.0-SNAPSHOT/bin/play-slick-example
```

Clean
```
$ sbt clean
```

### Docker-compose

add the following to `project/plugins.sbt`
```
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.2.0-M8")
```

create sbt docker image
```
$ sbt docker:publishLocal
```

Start docker-compose (where the docker-compose.yml file is located)
```
$ docker-compse up -d
```
