package examples.model;

public class Command {
    private String command;
    private long amount;

    public Command() {}

    public Command(String command, long amount) {
        this.command = command;
        this.amount = amount;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
