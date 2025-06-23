package keyin.DataAlgo.WeeklyAssignments.week04;

public class UndoRedoDemonstration {
    public static void UndoRedoDemonstration(String[] args) {
        UndoRedoManager<String> patternDesigner = new UndoRedoManager<>();

        System.out.println("Start. Current state: " + patternDesigner.getCurrentState()); // null

        patternDesigner.doAction("State 1: Cast on");
        System.out.println("Do. Current state: " + patternDesigner.getCurrentState()); // "State 1..."

        patternDesigner.doAction("State 2: Knit first row");
        System.out.println("Do. Current state: " + patternDesigner.getCurrentState()); // "State 2..."

        patternDesigner.doAction("State 3: Purl second row");
        System.out.println("Do. Current state: " + patternDesigner.getCurrentState()); // "State 3..."

        System.out.println("--- History ---");
        System.out.println("Undo! New state: " + patternDesigner.undoAction()); // "State 2..."
        System.out.println("Undo! New state: " + patternDesigner.undoAction()); // "State 1..."

        System.out.println("Redo! New state: " + patternDesigner.redoAction()); // "State 2..."

        System.out.println("--- Now, a new action ---");
        patternDesigner.doAction("State 4: Changed pattern to rib stitch");
        System.out.println("Do. Current state: " + patternDesigner.getCurrentState()); // "State 4..."

        // Let's try to redo. It should fail, because "State 3" was erased.
        System.out.println("Try to Redo... New state: " + patternDesigner.redoAction()); // "State 4..." (No change)
    }
}