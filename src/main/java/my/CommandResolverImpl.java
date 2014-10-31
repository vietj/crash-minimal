package my;

import org.crsh.cli.impl.descriptor.IntrospectionException;
import org.crsh.lang.impl.java.ClassShellCommand;
import org.crsh.plugin.CRaSHPlugin;
import org.crsh.shell.ErrorKind;
import org.crsh.shell.impl.command.spi.Command;
import org.crsh.shell.impl.command.spi.CommandException;
import org.crsh.shell.impl.command.spi.CommandResolver;

import java.util.Collections;
import java.util.Map;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class CommandResolverImpl extends CRaSHPlugin<CommandResolver> implements CommandResolver {

  @Override
  public CommandResolver getImplementation() {
    return this;
  }

  @Override
  public Iterable<Map.Entry<String, String>> getDescriptions() {
    return Collections.singletonMap("hello", "hello world example").entrySet();
  }

  @Override
  public Command<?> resolveCommand(String name) throws CommandException, NullPointerException {
    if ("hello".equals(name)) {
      try {
        return new ClassShellCommand<hello>(hello.class);
      }
      catch (IntrospectionException e) {
        throw new CommandException(ErrorKind.EVALUATION, "Invalid cli annotations", e);
      }
    }
    return null;
  }
}
