package examples.model;

public enum CommandType {
    FORWARD("forward"),
    BACKWARD("backward"),
    DOWN("down"),
    UP("up");

    public final String command;

    CommandType(String command) {
        this.command = command;
    }
}
