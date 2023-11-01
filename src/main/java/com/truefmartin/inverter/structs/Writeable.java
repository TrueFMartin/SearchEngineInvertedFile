package com.truefmartin.inverter.structs;

public abstract class Writeable {

    protected int NUM_COLUMNS;
    protected String[] columns;
    private int next = 0;

    Writeable(String... columns) {
        this.columns = columns;
        this.NUM_COLUMNS = columns.length;
    }
    public String getNext() {
        return columns[next++];
    }

    public void setNext(String data) {
        columns[next++] = data;
        // After all columns have been set, reassign the field variables with columns values
        if (next == NUM_COLUMNS) {
            reassignFields();
        }
    }

    public boolean hasNext() {
        return next < NUM_COLUMNS;
    }

    public void resetNext() {
        next = 0;
    }

    abstract protected void reassignFields();
    abstract public void print();

}
