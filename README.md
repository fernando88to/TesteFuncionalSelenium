### Testes funcionais

Testes funcionais com grails + selenium + gravação do testes

### Passo a passo

```
docker-compose up --build
docker exec -it application_container bash
./gradlew  -Dgeb.env=remote   test integrationTest
#Vai rodas os testes , para assitir tem que para o container da gravação


```


### Links

* https://github.com/SeleniumHQ/docker-selenium/blob/trunk/docker-compose-v3-video.yml
* https://www.youtube.com/watch?v=o6I3CBor3iw

### Endereço do hub

http://127.0.0.1:4444