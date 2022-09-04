package pro.sky.HW14algorithms1;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] repository; // поле - хранилище строк в массиве
    private int size; // поле - размер массива

    public StringListImpl() { // конструктор пустой, задаем количество элементов
        repository = new String[10];
    }

    public StringListImpl(int initSize) { // через конструктор задаем стартовый размер массива
        repository = new String[initSize];
    }

    @Override
    public String add(String item) {
        checkSize();
        checkItem(item);
        repository[size++] = item;
        return item;// чтобы видеть что добавлено
    }

    @Override
    public String add(int index, String item) {
        checkSize();
        checkItem(item);
        checkIndex(index);
        if (index == size){
            repository[size++] = item; //сразу увеличиваем размер, т.к. проверки выполнены выше
            return item;
        }
        System.arraycopy(repository, index, repository, index + 1, index - size); // сдвиг всех элементов
        repository[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkItem(item);
        checkIndex(index);
        repository[index] = item; //затираем значение, новое добавляем в ячейку
        return item;
    }

    @Override
    public String remove(String item) {
        checkItem(item);
        int index = indexOf(item); // находим индекс элемента
        /* if(index == -1){
            throw new NotFoundException();
        }
        if(index != size) {
            System.arraycopy(repository, index + 1, repository, index, size - index); // сдвиг влево
        }
        size--;
        return item;*/ //этот код можно заменить:
        return remove(index);
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = repository[index]; // здесь мы берем элемент, который будем удалять
        if(index != size) {
            System.arraycopy(repository, index + 1, repository, index, size - index); // сдвиг влево
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1; // если значение отличное от дефолтного,
        // то элемент находится внутри нашей коллекции
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if(repository[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >= 0; i--) {
            if (repository[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index); // проверяем интервал
        return repository[index];
    }

    @Override
    public boolean equals(StringList otherList) {

        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() { //обнуляем
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(repository, size);
    } // метод возвращает копию
    // нашего массива по размеру size без учета пустых ячеек

    // нужно реализовать 3 дополнительных метода (1. проверка индекса, что он не выходит за границы,
    // 2. объект не равен null, 3. проверяет size на предмет свободных ячеек, т.е. не равен repository)

    private void checkItem (String item){ // проверка на null объекта
        if (item == null){
            throw new NullItemException();
        }
    }
    private void checkSize (){ // проверка size
        if (size == repository.length){
            throw new FullRepositoryException();
        }
    }
    private void checkIndex (int index){ // проверка индекса
        if (index < 0 || index > size){
            throw new InvalidIndexException();
        }
    }
}
