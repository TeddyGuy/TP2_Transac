package persistence;

public interface Dao<T> {
    void save(T t);
}