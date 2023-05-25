package lib.publication;

public class Author {
    public String[] name;

    public Author(String name) {
        this.name = name.split(" ");
        for (int i = 0; i<this.name.length; i++) {
            this.name[i] = this.name[i].strip();
        }
    }

    public String getFullName() {
        String out = "";
        for (int i = 0; i < this.name.length - 1; i++) {
            out += name[i] + " ";
        }
        out += name[name.length - 1];
        return out;
    }

    public String getNonSurnameInitials() {
        String out = "";
        for (int i = 0; i < this.name.length - 2; i++) {
            out += name[i].substring(0, 1) + ". ";
        }
        out += name[name.length - 2].substring(0, 1) + ".";
        return out;
    }

    public String getLastName() {
        return name[name.length - 1].replaceAll("\\.", "");
    }

    public String getLastInitial() {
        return name[name.length - 1].substring(0, 1);
    }

    public String getFirstName() {
        return name[0].replaceAll("\\.", "");
    }

    public String getFirstNameMiddleInitial() {
        String out = "";
        out += getFirstName();
        for (int i = 1; i < name.length - 1; i++) {
            out += " " + name[i].substring(0, 1);
        }
        return out;
    }

    public String getFirstInitial() {
        return name[0].substring(0, 1);
    }
}
