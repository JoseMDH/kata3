package software.ulpgc.architecture.model;

public class TsvTitleDeserializer implements TitleDeserializer{

    @Override
    public Title deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    public Title deserialize(String[] split) {
        return new Title(split[0],
                toTitleType(split[1]),
                split[2],
                split[3],
                toBoolean(split[4]),
                toInt(split[5]),
                toInt(split[6]),
                toInt(split[7]),
                split[8]);
    }

    private Title.TitleType toTitleType(String value) {
        return Title.TitleType.valueOf(value.toUpperCase());
    }

    private boolean toBoolean(String value) {
        return value.equals("1");
    }

    private int toInt(String value) {
        if (value.equals("\\N")) return 0;
        return Integer.parseInt(value);
    }

}
