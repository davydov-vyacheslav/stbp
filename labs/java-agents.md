## [Java] Java-агенти
### Мета
Дослідити можливості java-агентів

### Індивідуальне завдання

**Зверніть увагу**. Для виконання цієї роботи Вам буде потрібен файл, що використовувався для дослідження у попередній роботі: https://github.com/davydov-vyacheslav/stbp/raw/master/assets/victim.jar.


**Завдання**. Використовуючи механізм java-агентів, виконати наступні дії:
- створити свою пару ключів
- зашифрувати фразу "I love polytec" своїм приватним ключем та зашифрований контент занести до messages.properties
- «підключитися» до додатку "жертви" до етапу завантаження класів, та на етапі формування публічного ключа (`new X509EncodedKeySpec(keyBytes)`)зробити підміну, що передає дані не оригінального публічного ключа, а згенерованого вами.
- вдосконалитись, що програма останньою строкою виводить ваше повідомлення.

Для створення пари ключів, що використовувалися для генерації фрази, використовувалися наступні команди:

```shell
        openssl genrsa -out private_key.pem 2048
        openssl pkcs8 -topk8 -inform PEM -outform DER -in private_key.pem -out private_key.der -nocrypt
        openssl rsa -in private_key.pem -pubout -outform DER -out public_key.der
```

## Література
- https://habr.com/ru/post/230239/
- https://www.codeflow.site/ru/article/java-instrumentation