package wms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class representing an object used for searching through tables.
 */
public class Search
{

    public Search()
    {

    }

    // TODO: Implement actual search functionality
    public ObservableList<Object> search(ObservableList<Object> input)
    {
        ObservableList<Object> foundItems = FXCollections.observableArrayList();
        {
            foundItems.addAll(input);
        }

        return foundItems;
    }
}
