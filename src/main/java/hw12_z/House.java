package hw12_z;

public class House extends Construction {
    public House(String type, int yearOfBuild, String style, Architect architect) {
        super(type, yearOfBuild, style, architect);
    }

    @Override
    public String toString() {
        return "House{" +
                "type='" + type + '\'' +
                ", yearOfBuild=" + yearOfBuild +
                ", style='" + style + '\'' +
                ", architect=" + architect +
                '}';
    }
}