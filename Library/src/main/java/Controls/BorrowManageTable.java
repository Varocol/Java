package Controls;

import Datas.Operation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class BorrowManageTable extends MyTable {

    public BorrowManageTable(String[] columnNames) {
        super(columnNames);
        Class<?>[] columns = new Class<?>[]{Boolean.class, Integer.class, String.class, String.class,
                String.class, String.class, Date.class, Double.class, Integer.class, String.class};
        Vector<Class<?>> columnClass = new Vector<>(Arrays.asList(columns));
        super.model.setColumnClass(columnClass);
    }

    public void setData(List<Operation> list) {
        Vector<Vector<Object>> data = new Vector<>();
        for (Operation operation : list) {
            Vector<Object> row = new Vector<Object>();
            row.add(false);
            row.add(operation.getId());
            row.add(operation.getUserName());
            row.add(operation.getBookName());
            row.add(operation.getOperation());
            row.add(operation.getDate().toString().substring(0,
                    operation.getDate().toString().length() - 2));
            row.add(operation.getDateReturn());
            row.add(operation.getFine());
            row.add(operation.getQuantity());
            row.add(operation.getStatus());
            data.add(row);
        }
        model.setRowData(data);
        selectedRows.clear();
    }
}
