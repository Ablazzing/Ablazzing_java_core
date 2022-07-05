package lesson8;

import java.util.Objects;

public class MyCar {
    private String name;

    public MyCar(String name) {
        super();
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MyCar)) {
            return false;
        } else if (this.hashCode() != obj.hashCode()) {
            return false;
        } else if (this.getName() != ((MyCar) obj).getName()) {
            return false;
        }

        return true;
    }

    @Override
    protected MyCar clone() throws CloneNotSupportedException {
        return new MyCar(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("Машина удалена");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
