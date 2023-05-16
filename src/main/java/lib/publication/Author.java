package lib.publication;

public class Author {
    public String[] name;

    public Author(String name) {
        this.name = name.split(" ");
    }

    public String getLastName() {
        return name[name.length - 1];
    }

    public String getLastInitial() {
        return name[name.length - 1].substring(0, 1);
    }

    public String getFirstName() {
        return name[0];
    }

    public String getFirstInitial() {
        return name[0].substring(0, 1);
    }
}
