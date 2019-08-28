public class Parser {

    public static Command parse(String fullCommand){
        if (fullCommand.equals("bye")) {
            return new ExitCommand();
        } else if (fullCommand.equals("list")) {
            return new ListCommand();
        } else if (fullCommand.substring(0, 4).equals("done")) {
            int do_Index = Integer.parseInt(fullCommand.substring(5));
            return new DoneCommand(do_Index);
        } else if (fullCommand.substring(0, 4).equals("find") && fullCommand.length() >= 5) {
            return new FindCommand(fullCommand.substring(5));
        } else if (fullCommand.length() >= 6 && fullCommand.substring(0, 6).equals("delete")) {
            int delete_Index = Integer.parseInt(fullCommand.substring(7));
            return new DeleteCommand(delete_Index);
        } else {
            return new AddCommand(fullCommand);
        }
    }
}