package cz3002.grp14.dao;

import java.util.List;

public interface DataAccessObject<T> {

    boolean get(T t);

    List<T> getAll();

    void update(T t);

    void delete(T t);
}