package spots.useCases;

import java.util.ArrayList;

public interface RecsOutBoundary {
    /**
     * Method can be over-ridden
     *
     * @param rec recommendation list
     */
    void update(ArrayList<String> rec);
}