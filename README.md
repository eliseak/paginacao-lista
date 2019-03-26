# paginacao-lista
A Utils class for list pagination

## Documentation

This class has two public methods.

### getTotalPages

Description: a static method that gets the number of total pages a list can have  

Parameters list:  
|Parameter |Type      |Optional |Comment                        |
|----------|----------|---------|-------------------------------|
|list      |List<?>   |No       |The list to page               |
|limit     |Integer   |No       |The quantity of items per page |

Call example:
```java
    PageUtils.getTotalPages(list, limit);
```

### getPageContent
Description: a static method that returns the content (sublist) of a specified page  

Type parameters list:  
|Type  |Comment                               |
|------|--------------------------------------|
|\<T\> |The type of the item in the list      |

Parameters list:  
|Parameter |Type      |Optional |Comment                               |
|----------|----------|---------|--------------------------------------|
|list      |List\<T\> |No       |The list to page                      |
|page      |Integer   |No       |The number of the page to be returned |
|limit     |Integer   |No       |The quantity of items per page        |

Call example:
```java
    PageUtils.getTotalPages(list, page, limit);
```

## Downsides
- To use this class, the application needs to load the entire list at least once

## TODO
- Detail the call examples