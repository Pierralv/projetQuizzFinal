package projetQuizz.repositories;

import java.util.List;

public interface DaoGeneric<T, K> {
	T save(T obj);

	void delete(T obj);

	void deleteByKey(K key);

	T findByKey(K key);

	List<T> findAll();
}
