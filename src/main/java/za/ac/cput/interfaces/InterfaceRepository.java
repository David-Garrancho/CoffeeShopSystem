package za.ac.cput.interfaces;

/* InterfaceRepository.java
Class for the InterfaceRepository
Author: David Henriques Garrancho (221475982)
Date: 20 March 2023
*/

public interface InterfaceRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
