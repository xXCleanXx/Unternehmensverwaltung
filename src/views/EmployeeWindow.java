package views;

import enums.DialogResult;
import management.Unternehmensverwaltung;
import management.employees.ShiftEmployee;
import management.employees.abstractions.Employee;

import javax.swing.*;
import java.awt.*;

public class EmployeeWindow extends JDialog {
    private final JButton _btnSave = new JButton();
    private final JButton _btnAbort = new JButton();
    private final JTextField _tfdId = new JTextField();
    private final JTextField _tfdName = new JTextField();
    private final JTextField _tfdPayment = new JTextField();
    private final JComboBox<String> _cmbType = new JComboBox<>();
    private Employee _employee;
    private DialogResult _dialogResult;
    public enum Test { h, hh, hhh }

    public EmployeeWindow(JFrame parent) {
        super(parent, true);
        this.initializeComponents();

        this._employee = new ShiftEmployee(3000, null, 0, 0);
    }

    public EmployeeWindow(JFrame parent, Employee employee) {
        this(parent);
    }

    private void initializeComponents() {
        // _tfdId
        this._tfdId.setSize(new Dimension(150, 60));

        // _tfdName
        this._tfdName.setSize(new Dimension(150, 60));

        // _tfdPayment
        this._tfdPayment.setSize(new Dimension(150, 60));
        for (Test item : Test.values()) {
            this._cmbType.addItem(item.name());
        }
        // _cmbType
        for(String item : new String[] { "Bueroarbeiter", "Schichtarbeiter", "Manager"})
            this._cmbType.addItem(item);

        // _btnSave
        this._btnSave.setText("Save");
        this._btnSave.addActionListener(e -> {
            if (Unternehmensverwaltung.getInstance().addPersonal(this.getEmployee())) {
                this.dispose();
            }
        });

        // _btnAbort
        this._btnAbort.setText("Abort");
        this._btnAbort.addActionListener(e -> this.dispose());

        // Window
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(this._btnSave, BorderLayout.EAST);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPane.add(this._btnAbort, BorderLayout.EAST);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
        panel1.add(Box.createHorizontalGlue());
        panel1.add(this._tfdId, BorderLayout.NORTH);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        panel1.add(this._tfdName, BorderLayout.NORTH);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        panel1.add(this._tfdPayment, BorderLayout.NORTH);
        buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
        panel1.add(this._cmbType, BorderLayout.NORTH);

        super.add(panel1, BorderLayout.NORTH);
        super.add(buttonPane, BorderLayout.SOUTH);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    public DialogResult getDialogResult() {
        return this._dialogResult;
    }

    private void setDialogResult(DialogResult dialogResult) {
        this._dialogResult = dialogResult;
    }

    private void close(DialogResult dialogResult) {
        this.setDialogResult(dialogResult);
        this.dispose();
    }

    public Employee getEmployee() {
        return this._employee;
    }

    public void setEmployee(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee cannot be null!");

        this._employee = employee;
    }
}