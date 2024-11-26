package software.ulpgc.architecture.control;

import software.ulpgc.architecture.view.BarchartDisplay;
import software.ulpgc.architecture.io.BarchartLoader;

public class ToogleBarchartCommand implements Command{

    private final BarchartLoader loader;
    private final BarchartDisplay display;
    private int i = 1;

    public ToogleBarchartCommand(BarchartLoader loader, BarchartDisplay display) {
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(loader.load(i++ %2));
    }
}
