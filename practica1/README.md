# Práctica 1
### Semillero de Talento

José Ottoniel Sincal Guitzol

## Ejemplo de consumo del servicio

#### Servicio Normal

##### Endpoint

Este servicio consume las siguientes API's:
* https://itunes.apple.com/search?term=jack+johnson
* https://api.tvmaze.com/search/people?q=jack%20johnson

```
http://localhost:9119/rest/find/:name
```

> :name es obligatorio

![](https://i.imgur.com/g4grbhX.png)


#### Servicio Personalizado

##### Endpoint

Este servicio consume las siguientes API's:
* https://itunes.apple.com/search?term=jack+johnson&entity=musicVideo
* https://api.tvmaze.com/search/shows?q=girls

```
http://localhost:9119/rest/find/personalized/:name
```

> :name es obligatorio

![](https://i.imgur.com/rxgXx0P.png)
