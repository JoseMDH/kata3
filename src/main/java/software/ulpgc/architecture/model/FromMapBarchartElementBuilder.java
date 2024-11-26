package software.ulpgc.architecture.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FromMapBarchartElementBuilder <K> implements BarchartElementsBuilder {

    private final Map<K, Integer> data;

    public FromMapBarchartElementBuilder(Map<K, Integer> data) {
        this.data = data;
    }

    @Override
    public List<BarchartElement> build() {
        List<BarchartElement> barchartElements = new ArrayList<>();
        for (K i : data.keySet()) {
            barchartElements.add(new BarchartElement(data.get(i),String.valueOf(i)));
        }
        return barchartElements;
    }
}