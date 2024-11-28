package software.ulpgc.app.windows;

import software.ulpgc.architecture.control.ToogleBarchartCommand;
import software.ulpgc.architecture.io.FileTitleLoader;
import software.ulpgc.architecture.io.MoviesBarchartLoader;
import software.ulpgc.architecture.model.FromMapBarchartElementBuilder;
import software.ulpgc.architecture.model.Title;
import software.ulpgc.architecture.model.TsvTitleDeserializer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Proyectos IS2\\title.basics.tsv");
        List<Title> titles = new FileTitleLoader(file, new TsvTitleDeserializer()).load();
        HashMap<Integer, Integer> titlesPerYearStats = new HashMap<>();
        HashMap<Title.TitleType, Integer> titlesTypeCountStats = new HashMap<>();
        for (Title title : titles) {
            titlesTypeCountStats.put(title.titleType(), titlesTypeCountStats.getOrDefault(title.titleType(), 0) + 1);
            if (title.start_year() != 0) {
                titlesPerYearStats.put(title.start_year(), titlesPerYearStats.getOrDefault(title.start_year(), 0) + 1);
            }
        }
        MainFrame mainFrame = new MainFrame();
        MoviesBarchartLoader loader = new MoviesBarchartLoader(new FromMapBarchartElementBuilder<>(titlesPerYearStats).build(), new FromMapBarchartElementBuilder<>(titlesTypeCountStats).build());
        mainFrame.put("Toogle", new ToogleBarchartCommand(loader, mainFrame.getDisplay()));
        mainFrame.getDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}
