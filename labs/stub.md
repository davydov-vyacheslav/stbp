## Підміна віддаленого серверу
### Мета

Дослідити особливості підміни віддаленого серверу

### Передмова

Інколи бувають ситуації, коли програмне забезпечення отримує додаткову інформацію з віддалених (remote) ресурсів. Якщо цю інформацію потрібно перехопити та підмінити, використовують сервера - заглушки (stub servers), що при певних запитах видають завідомо відомий результат.

### Завдання

Використовуючи сервер-заглушку (рекомендовано stubby4j), зробити так, щоб програма (https://github.com/davydov-vyacheslav/stbp/raw/master/assets/victim.jar) видавала результат:

```
	Reading plaintext data from external resources: 
	<Ваш П.І.Б.>
	Сучасні технології безпечного програмування
	(подальші строки можуть бути без змін)
```

Для виконання даної лабораторної роботи слід зробити підміну а) dns адреси, б) ip адреси. 

У звіті навести:
- хід дій для створення серверу-заглушки
- хід дій для підміни серверу
- запропоновані варіанти уникнення можливостей підміни серверу

Інше:
- Для запуску додатку можна використовувати команду `java -jar victim.jar` та необхідно мати проінстальований jdk1.8 (або новіше)
- Змінювати наведений .jar файл категорично заборонено!


### Література

- [Stubby4j](https://github.com/azagniotov/stubby4j)
