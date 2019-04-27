# TestTape
It is very important to add a space character when creating new nodes. This had me banging my head on the wall for hours.

```
public Tape(){
        head = new Cell();
        head.prev = new Cell();
        head.prev.content = ' ';
        head.prev.next = head;
        current = head.prev;
    }
```
