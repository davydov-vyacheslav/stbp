## Захист від зміни бінарного файлу
### Мета
Навчитися підписувати виконувані файли.

### Завдання

- створити сертифікат
- проінсталювати його в систему, щоб він був "довіреним"
- використовуючи проект будь-якої попередньої роботи, виконати підпис виконуваного файлу за допомогою утиліти SignTool (або JarSigner)
- виконати верифікацію підпису (бажано на рівні самого кода при завантаженні додатка): 
   - чи є підписаний сертифікат валідним
   - чи не було (бінарної) зміни файлу та його код цілісний


P.S. Лабораторна робота розрахована для windows-виконуючих файлів або java файлів. Але якщо робота будет зроблена для Linux/Macos виконуючих балів - це вам плюс до карми та можливість отримати додаткові бали.

### Література

- [Wiki: X.509](https://en.wikipedia.org/wiki/X.509).
- [PKCS #5: Password-Based Cryptography Specification](http://www.ietf.org/rfc/rfc2898.txt).
- [Wiki: PKCS #12](https://en.wikipedia.org/wiki/PKCS_12).
- [JarSigner sample](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/jarsigner-digitially-sign-JARs-Java-keytool-certificates)