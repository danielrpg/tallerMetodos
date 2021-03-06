package uinterface;

import model.ObservacionModel;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dany
 */
public class ObservacionTable extends AbstractTableModel {

    private final List<ObservacionModel> tableModelList;

    private final String[] columnNames = new String[]{
        "OBSERVACION", "HORAS", "PARADA", "FUNCIONANDO"
    };

    private final Class[] columnClass = new Class[]{
        Integer.class, String.class, String.class, String.class
    };

    public ObservacionTable(){
        this.tableModelList = new ArrayList<>();
    }

    public ObservacionTable(List<ObservacionModel> tableModelList) {
        this.tableModelList = tableModelList;
    }

    public void addRow(ObservacionModel observacionModel){
        this.tableModelList.add(observacionModel);
        this.fireTableDataChanged();
    }

    public void clearDataTableModel(){
        this.tableModelList.clear();
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getRowCount() {
        return tableModelList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ObservacionModel row = tableModelList.get(rowIndex);
        if(0 == columnIndex){
            return row.getObservacion();
        }
        else if(1 == columnIndex){
            return row.getHora();
        }
        else if(2 == columnIndex){
            return row.getParada();
        }
        else if(3 == columnIndex){
            return row.getFunctionando();
        }
        return null;
    }
}
