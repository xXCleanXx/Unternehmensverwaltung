package views;

import components.abstractions.Subject;
import components.interfaces.IObserver;
import management.Unternehmensverwaltung;
import management.employees.abstractions.Employee;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class MainWindow extends JFrame implements IObserver {
    private final JButton _btnNew = new JButton();
    private final JTable _table = new JTable();

    public MainWindow() {
        super();
        this.initializeComponents();
    }

    private void initializeComponents() {
        // _newButton
        this._btnNew.setText("Add Employee");
        this._btnNew.addActionListener(e -> new EmployeeWindow(this));

        Panel leftPanel = new Panel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(this._btnNew, BorderLayout.NORTH);

        // _table
        DefaultTableModel tableModel = new DefaultTableModel(new String[] { "Id", "Name", "Typ", "Gehalt" }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        for(Employee item : Unternehmensverwaltung.getInstance().getEmployees())
            tableModel.addRow(new Object[] { item.getId(), item.getName(), item.getClass().getSimpleName(), item.income() });

        this._table.setModel(tableModel);
        Panel rightPanel = new Panel();
        rightPanel.add(new JScrollPane(this._table));

        // Window
        super.add(leftPanel, BorderLayout.WEST);
        super.add(rightPanel, BorderLayout.EAST);
        super.setTitle("Administration");
        super.pack();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    @Override
    public void update(Subject subject) {
        DefaultTableModel tm = (DefaultTableModel)this._table.getModel();

        Unternehmensverwaltung uv = (Unternehmensverwaltung)subject;
        uv.getEmployees();
    }
}