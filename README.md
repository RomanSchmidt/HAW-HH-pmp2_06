# Java PMP2_06

```
PR06 die Javanisten
Author: Roman Schmidt, Stanislaw Brug
```

## Deque
- Wenn die firstElement null ist, dann ist die Deque leer.
- Subklasse Element wird dafür benutzt um die Elemente in der Deque fest zu halten.
- In unserem Fall bekommt jedes Element immer ein Parent und Child. Am angang ist es in beiden
Fällen das eigene Objekt.
- Jede Erweiterung der Deque führt lediglich dazu, dass das add der Subklasse aufgerufen wird. Dafür
wird vorher bestimmt, was parent und child sein sollte. Es gibt durch die Bedingung zuvor jedoch
nie einen Nullpointer.
- Jede Verkleinerung der Deque führ lediglich dazu, dass das delete der Subklasse aufgerufen wird.
Es verknüpft sein Parent mit Child und wird danach dem Garbige überlassen. Der Rückgabewert ist immer
das nächste / vorherige Element, wenn es nicht das Betroffene ist. Denn dann wäre es null.
- Last ist immer der Parent vom firstElement. Auch wenn er es selbst ist.