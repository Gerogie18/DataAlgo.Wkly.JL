package week01;

/*
This class analyzes an array of temps of any size. It can return the average temp as well as a list of
temperatures above the average.
*/

public class TempAnalysis {
    private Temp[] tempArray;
    private double tempAverage;
    private Temp[] aboveAverage;

    public TempAnalysis(Temp[] tempArray) {
        if (tempArray == null || tempArray.length == 0) {
            throw new IllegalArgumentException("Input temperature array cannot be empty or null for analysis.");
        }
        this.tempArray = tempArray;
        setAverage();
        setAboveAverage();
    }

    public void updateTemps(Temp[] tempArray) {
        this.tempArray = tempArray;
        setAverage();
        setAboveAverage();
    }

    private void setAverage() {
        //parses through tempArray to get average temp
        double tempTotal = 0;
        for (Temp temp : tempArray) {
            tempTotal += temp.getTemperature();
        }
        this.tempAverage = tempTotal / tempArray.length;

    }

    public double getAverage() {
        return tempAverage;
    }

    public void setAboveAverage() {
        //parses through tempArray to get the number of temps above average to set the array size.
        //could use arraylist to be more dynamic.
        int count = 0;
        for (Temp temp : tempArray) {
            if (temp.getTemperature() > this.tempAverage) {
                count++;
            }
        }

        aboveAverage = new Temp[count]; // Create the aboveAverage array with the correct size
        int index = 0;
        // Then, populate the aboveAverage array
        for (Temp temp : tempArray) {
            if (temp.getTemperature() > this.tempAverage) {
                aboveAverage[index++] = temp;
            }
        }
    }

    public Temp[] getAboveAverage() {
        return aboveAverage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Temperature Analysis:\n-------------------\nTemperatures: ");
        for (Temp temp : tempArray) {
            sb.append(temp.toString()).append(" ");
        }
        sb.append("\nAverage: ").append(String.format("%.2f°C", tempAverage));
        sb.append("\nAbove Average: ");
        for (Temp temp : aboveAverage) {
            sb.append(temp.toString()).append(" ");
        }
        return sb.toString();
    }
}
