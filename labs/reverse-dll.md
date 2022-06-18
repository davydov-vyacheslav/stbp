## [Windows] Дослідження динамічних бібліотек

### Мета
Отримати навички основ реверс-інженірингу "на практиці"

### Завдання

Використовуючи [бібліотеку зовнішнього вендора](https://github.com/davydov-vyacheslav/stbp/raw/master/assets/n3k_comm.dll), виконати наступні дії:

1. Визначити мову програмування, на якої була написана бібліотека (`C/C++`, `C#`, `Deplhi`, `Java`). Визначення мови програмування дозволить найбільш ефективно використовувати "декомпілятор". При цьому, рекомендуються наступні декомпілятори:
   - для `Java` - jdgui, або нативний декомпілятор від Intellij IDEA
   - для `C#` - dotPeek
   - для `Delphi` - DeDe
   - для `C/C++` -  Ghidra, IDA Pro
2. Визначити функції та їх прототипи, з яких складається динамічна бібліотека.
3. Створити додаток, що підключає дану бібліотеку та визначити, що роблять функції `getIV`,`getK`.
4. Декомпілювати функцію `CRC_16_IBM`. Судячи з її назви Вам буде не важко це зробити (бо її алгоритм завідомо відомий), але треба бути підібрати кректні коефіцієнти. Необхідно довести коректність реалізованого алгоритму через порівняння результатів з результатами роботи функції динамічної бібліотеки.
5. Декомпілювати та  переписати функції `dec` та ` enc`. Який алгоритм вони використовують? Підсказка - це скорочення від encode, decode. Більшість алгоритмів шифрування використовують табличні дані, на базі яких використовується кодування. Знавши це - найбільш швидкий для вас варіант - визначити таблицю, що використовується, та знайти алгоритм, що її використовує. Реалізувати алгоритм на мові високого рівня, та довести коректність реалізованого алгоритму через порівняння результатів з результатами роботи функції динамічної бібліотеки. 

### Посилання
- [CRC](https://en.wikipedia.org/wiki/Cyclic_redundancy_check)
- [JD GUI](http://java-decompiler.github.io)
- [DeDe](https://www.softpedia.com/get/Programming/Debuggers-Decompilers-Dissasemblers/DeDe.shtml)
- [dotPeek](https://www.jetbrains.com/ru-ru/decompiler/)
- [Ghidra](https://ghidra-sre.org)
- [Ghidra vs IDA](https://habr.com/ru/post/480824/)