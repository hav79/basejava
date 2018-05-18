import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int lastIndex = 0; // index after last element

    void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }

    void save(Resume r) {
        if (lastIndex < storage.length - 1)
            storage[lastIndex++] = r; // сохранить резюме в конец массива
    }

    Resume get(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        // найти нужное резюме
        // заменить его последним элементом
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[lastIndex - 1];
                storage[--lastIndex] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex);
    }

    int size() {
        return lastIndex;
    }
}
