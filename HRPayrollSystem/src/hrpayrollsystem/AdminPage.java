package hrpayrollsystem;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends javax.swing.JFrame {
    
    private Interface hrInterface;
    private AdminPage adminPage = this;

    public AdminPage(Interface hrInterface) {
        initComponents();
        this.hrInterface = hrInterface;

        String[] tableHeaders = new String[] {
            "First Name", "Last Name", "Employee ID", "Job Position", " "
        };
        
        //ArrayList<Employee> employeeList = // TODO Get employee data and put it in here then delete the bottom
        Employee employee1 = new Employee("test", "test", "test", "test", "test", "test", "test");
        Employee employee2 = new Employee("test", "test", "qwer", "wer", "test", "test", "test");
        ArrayList<Deduction> deductionList = new ArrayList<Deduction>();
        Employee employee3 = new Employee("asdf", "Asdf", "A", "B", "123", "tp123", "engineer",
            "a@email.com", 100.00, 4000.00, 4500.00, 4800.00, 10, deductionList);
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        
        DefaultTableModel tableModel = new DefaultTableModel(tableHeaders, 0);
        for(Employee employee : employeeList) {
            Object[] emp = {employee.getFirstName(), employee.getLastName(), employee.getEmployeeId(), employee.getJobPosition(), ""};
            tableModel.addRow(emp);
        }
        
        employeeListTable.setModel(tableModel);
        
        ActionButtonEvent event = new ActionButtonEvent() {
            @Override
            public void onEdit(int row) {
                EmployeeDetailsPage employeeDetailsPage = new EmployeeDetailsPage(hrInterface, adminPage, employeeList.get(row));
                employeeDetailsPage.setVisible(true);
                setAdminPageVisibility(false);
            }
            
        };
        employeeListTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());;
        employeeListTable.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        employeeListLabel = new javax.swing.JLabel();
        employeeListScrollPane = new javax.swing.JScrollPane();
        employeeListTable = new javax.swing.JTable();
        generatePayrollReportButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1076, 775));
        setPreferredSize(new java.awt.Dimension(1076, 775));

        employeeListLabel.setBackground(new java.awt.Color(255, 255, 255));
        employeeListLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        employeeListLabel.setText("Employee List");

        employeeListScrollPane.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        employeeListTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        employeeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Employee ID", "Job Position", "   "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeListTable.setRowHeight(24);
        employeeListScrollPane.setViewportView(employeeListTable);

        generatePayrollReportButton.setText("Generate Payroll Report");
        generatePayrollReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePayrollReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(employeeListLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generatePayrollReportButton))
                    .addComponent(employeeListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(employeeListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generatePayrollReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(employeeListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generatePayrollReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePayrollReportButtonActionPerformed
        AdminPayrollReportPage adminPayrollReportPage = new AdminPayrollReportPage(hrInterface, adminPage);
        adminPayrollReportPage.setVisible(true);
        setAdminPageVisibility(false);
    }//GEN-LAST:event_generatePayrollReportButtonActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void setAdminPageVisibility(boolean visibility) {
        this.setVisible(visibility);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel employeeListLabel;
    private javax.swing.JScrollPane employeeListScrollPane;
    private javax.swing.JTable employeeListTable;
    private javax.swing.JButton generatePayrollReportButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}