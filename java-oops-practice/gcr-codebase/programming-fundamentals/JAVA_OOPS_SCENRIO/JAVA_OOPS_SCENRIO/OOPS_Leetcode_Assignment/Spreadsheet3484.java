import java.util.HashMap;
import java.util.Map;

class Spreadsheet {

    private Map<String, Integer> sheet;
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        sheet = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        sheet.put(cell, value);
    }

    public int getCell(String cell) {
        return sheet.getOrDefault(cell, 0);
    }

    public int getRowCount() {
        return rows;
    }
}
