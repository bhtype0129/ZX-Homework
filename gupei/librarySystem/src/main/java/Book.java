import java.io.*;

public class Book {
    private String name;
    private long number;
    private String author;
    private String catalogue;
    private String intro;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public static void main(String[] args) {
        try {
            Book test1 = new Book();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + "\'" +
                ", number=" + number +
                ", author='" + author + '\'' +
                ", catalogue='" + catalogue + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}

