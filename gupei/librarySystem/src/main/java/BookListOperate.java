public interface BookListOperate {
    Book search(int id);

    void insert(String name);

    Book update(Book book);

    void remove(String name);
}
