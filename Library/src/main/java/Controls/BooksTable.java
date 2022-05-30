package Controls;

import Datas.Book;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class BooksTable extends MyTable {

    public BooksTable(String[] datas) {
        super(datas);
        Class<?>[] columns = new Class<?>[]{Boolean.class, Integer.class, String.class, String.class,
                String.class, Date.class, Double.class, Integer.class};
        Vector<Class<?>> columnClass = new Vector<>(Arrays.asList(columns));
        super.model.setColumnClass(columnClass);
    }

    public void setData(List<Book> list) {
        Vector<Vector<Object>> data = new Vector<>();
        for (Book book : list) {
            Vector<Object> row = new Vector<Object>();
            row.add(false);
            row.add(book.getId());
            row.add(book.getName());
            row.add(book.getAuthor());
            row.add(book.getPublisher());
            row.add(book.getPublishDate());
            row.add(book.getPrice());
            row.add(book.getStock());
            data.add(row);
        }
        model.setRowData(data);
        selectedRows.clear();
    }
}
