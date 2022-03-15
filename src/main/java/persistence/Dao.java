package persistence;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    void save(T t);
    void update(T t);
}
