package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Title;

import java.io.IOException;
import java.util.List;

public interface TitleLoader {
    List<Title> load() throws IOException;
}
