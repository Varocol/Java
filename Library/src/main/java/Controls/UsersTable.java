package Controls;

import Datas.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class UsersTable extends MyTable {
    public UsersTable(String[] datas) {
        super(datas);
        Class<?>[] columns = new Class<?>[]{Boolean.class, Integer.class, String.class, String.class,
                String.class, String.class, Date.class, String.class};
        Vector<Class<?>> columnClass = new Vector<>(Arrays.asList(columns));
        super.model.setColumnClass(columnClass);
    }

    public void setData(List<User> list) {
        Vector<Vector<Object>> data = new Vector<>();
        for (User user : list) {
            Vector<Object> row = new Vector<Object>();
            row.add(false);
            row.add(user.getId());
            row.add(user.getName());
            row.add(user.getSex());
            row.add(user.getPhoneNumber());
            row.add(user.getState());
            row.add(user.getBirthday());
            row.add(user.getRegisterDate().toString().substring(0,
                    user.getRegisterDate().toString().length() - 2));
            data.add(row);
        }
        model.setRowData(data);
        selectedRows.clear();
    }
}
