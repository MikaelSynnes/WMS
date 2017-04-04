package wms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class representing an object used for searching through tables.
 *
 * DENNE KLASSEN SKAL FORHÅPENTLIGVIS TA SEG AV ALT AV SØK NÅR PROSJEKTET ER FERDIG.
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
