package uinterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author dany
 */
public class ObservacionTable extends JTable {

    private Object[][] rowDatas;
    private Object[] columnNames;

    private DefaultTableModel model;

    public ObservacionTable(){
        columnNames = new Object[]{"Observación", "Horas", "Parada", "Funcionado"};
        model = new DefaultTableModel(0, 0);
        model.setColumnIdentifiers(columnNames);
        this.setModel(model);
    }

    public void addRowData(DefaultTableModel newModel, Object[] data){
        newModel.addRow(data);
    }

    public Object[][] getRowDatas() {
        return rowDatas;
    }

    public void setRowDatas(Object[][] rowDatas) {
        this.rowDatas = rowDatas;
    }

    public Object[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(Object[] columnNames) {
        this.columnNames = columnNames;
    }

    @Override
    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
