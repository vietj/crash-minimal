package my;

import org.crsh.cli.Command;
import org.crsh.cli.Usage;
import org.crsh.command.BaseCommand;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class hello extends BaseCommand {

  @Usage("list the repl or change the current repl")
  @Command
  public String main() throws Exception {
    return "Hello world";
  }

}
