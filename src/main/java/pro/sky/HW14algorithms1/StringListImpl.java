package pro.sky.HW14algorithms1;

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
        return null;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }

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
