package keyin.DataAlgo.WeeklyAssignments.week04;

import java.util.LinkedList;

/**
 * Undo redo manager using doubly linked lists
 **/

public class UndoRedoManager<dataType> {
    private LinkedList<dataType> undoHistory;
    private LinkedList<dataType> redoHistory;


    public UndoRedoManager() {
        this.undoHistory = new LinkedList<>();
        this.redoHistory = new LinkedList<>();
    }

    /**
     * Gets the current state without changing the lists
     * @return the current state
     */
    public dataType getCurrentState() {
        if (undoHistory.isEmpty()) {
            return null;
        }
        return undoHistory.getLast();
    }

    /**
     * performs new action.
     * @param newState - the state to be added to the history
     */
    public void doAction(dataType newState) {
        undoHistory.addLast(newState);

        //clear redo history
        if (!redoHistory.isEmpty()) {
            redoHistory.clear();
        }
    }

    /**
     * Undoes the last action
     * @return the new current state
     **/
    public dataType undoAction() {
        //only undo if there is a state in the history
        if (undoHistory.size() > 1) {
            dataType undoState = undoHistory.removeLast();
            redoHistory.addLast(undoState);
        }
        return getCurrentState();
    }
    /**
     * Redo the most recently undone action
     * @return the new current state
     **/
    public dataType redoAction() {
        //only redo if there is a redo history
        if (!redoHistory.isEmpty()) {
            dataType redoState = redoHistory.removeLast();
            undoHistory.addLast(redoState);
        }
        return getCurrentState();
    }

    //getter and setter
    public LinkedList<dataType> getUndoHistory() {return undoHistory;}

    public void setUndoHistory(LinkedList<dataType> undoHistory) {this.undoHistory = undoHistory;}

    public LinkedList<dataType> getRedoHistory() {return redoHistory;}

    public void setRedoHistory(LinkedList<dataType> redoHistory) {this.redoHistory = redoHistory;}
}
