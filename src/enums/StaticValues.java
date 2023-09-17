package enums;

public enum StaticValues {
    FILE_PATH("random-word.txt"),
    GET_API_URL("https://random-word-api.herokuapp.com/word");

    StaticValues(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private  String path;

}
