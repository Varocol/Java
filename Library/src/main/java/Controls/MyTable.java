package Controls;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.Serial;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class MyTable extends JPanel {
    static Comparator<String> cmp = new Comparator<>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        }
    };
    MyTableModel model;
    JScrollPane scrollPane;
    JTable table;
    String[] datas;
    Vector<Vector<Object>> dataVector = new Vector<>();
    Vector<String> columnNames = new Vector<String>();
    Vector<String> selectedRows = new Vector<>();

    public MyTable(String[] datas) {
        this.datas = datas;
        Init();
    }

    public void Init() {
        columnNames.addAll(Arrays.asList(datas));
        model = new MyTableModel(columnNames, dataVector);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        table.setDefaultRenderer(Integer.class, renderer);
        table.setDefaultRenderer(Double.class, renderer);
        table.setFont(new Font("Arial,sans-serif;",
                Font.BOLD, 18));
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(new Font("Arial,sans-serif;",
                Font.BOLD, 16));
        table.getTableHeader().setBackground(Color.WHITE);
        table.getSelectionModel().addListSelectionListener(e -> {

        });
        add(scrollPane, BorderLayout.CENTER);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
    }

    public Vector<String> getSelectedRows() {
        return selectedRows;
    }

    class MyTableModel extends AbstractTableModel {

        @Serial
        private static final long serialVersionUID = 1L;
        Vector<String> columnNames;
        Vector<Class<?>> types;
        private Vector<Vector<Object>> rowData;

        public MyTableModel(Vector<String> columnNames, Vector<Vector<Object>> rowData) {
            setColumnNames(columnNames);
            setRowData(rowData);
        }

        public Vector<Vector<Object>> getRowData() {
            return rowData;
        }

        public void setRowData(Vector<Vector<Object>> rowData) {
            this.rowData = rowData;
            fireTableDataChanged();
        }

        public void setColumnNames(Vector<String> columnNames) {
            this.columnNames = columnNames;
        }

        public int getColumnCount() {
            return columnNames.size();
        }

        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        public int getRowCount() {
            return rowData.size();
        }

        public Object getValueAt(int row, int column) {
            return rowData.get(row).get(column);
        }

        public Class<?> getColumnClass(int column) {
            return types.get(column);
        }
        public void setColumnClass(Vector<Class<?>> types) {
            this.types = types;
        }
        public void setValueAt(Object value, int row, int column) {
            rowData.get(row).set(column, value);
            if (column == 0) {
                if (value.equals(true) && !selectedRows.contains(String.valueOf(row))) {
                    selectedRows.add(String.valueOf(row));
                } else if (value.equals(false)) {
                    selectedRows.remove(String.valueOf(row));
                }
                selectedRows.sort(cmp);
            }
            fireTableCellUpdated(row, column);
        }

        public boolean isCellEditable(int row, int column) {
            return column == 0;
        }
    }
}
