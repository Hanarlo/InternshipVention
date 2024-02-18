package step;

import page.TablePage;

public class TableStep{

    private TablePage tablePage;

    public TableStep(TablePage tablePage) {
        this.tablePage = tablePage;
    }

    public String getTextFromCell(int row, int column) {
       return tablePage.getTable().tableBody.getCellByRowAndColumn(row, column).getText();
    }

    public String getTextFromHeaderCell(int row) {
        return tablePage.getTable().tableHeader.getColumnHeaderTextByIndex(row);
    }
}
