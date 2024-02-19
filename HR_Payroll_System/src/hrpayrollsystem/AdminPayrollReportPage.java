package hrpayrollsystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminPayrollReportPage extends javax.swing.JFrame {
    
    private Interface hrInterface;
    private AdminPage adminPage;
    
    public AdminPayrollReportPage(Interface hrInterface, AdminPage adminPage) {
        initComponents();
        this.hrInterface = hrInterface;
        this.adminPage = adminPage;
        
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        
        payrollReportTitleLabel.setText("Payroll Report - " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.getDefault()));
        
        String[] tableHeaders = new String[] {
            "No.", "Emp. ID", "Employee Name", "Basic", "Allowance", "EPF", "SOCSO", "Deduction", "Net"
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
        int tableCount = 0;
        double totalBasicSalary = 0, totalAllowance = 0, totalEPF = 0, totalSOCSO = 0, totalDeduction = 0, totalNetSalary = 0;
        for(Employee employee : employeeList) {
            tableCount++;
            double empEPF = employee.getBasicSalary() * 0.09;
            double empSOCSO = employee.getBasicSalary() * 0.005;
            Object[] emp = {tableCount, employee.getEmployeeId(), employee.getFirstName() + " " + employee.getLastName(), employee.getBasicSalary(),
            employee.getAllowance(), empEPF, empSOCSO, employee.getDeduction(currentMonth), employee.getNetSalary()};
            tableModel.addRow(emp);
            
            // Calculate totals
            totalBasicSalary += employee.getBasicSalary();
            totalAllowance += employee.getAllowance();
            totalEPF += empEPF;
            totalSOCSO += empSOCSO;
            totalDeduction += employee.getDeduction(currentMonth);
            totalNetSalary += employee.getNetSalary();
        }
        
        payrollReportTable.setModel(tableModel);
        formatPayrollTable();
        totalBasicSalaryText.setText(Double.toString(totalBasicSalary));
        totalAllowanceText.setText(Double.toString(totalAllowance));
        totalEPFText.setText(Double.toString(totalEPF));
        totalSOCSOText.setText(Double.toString(totalSOCSO));
        totalDeductionText.setText(Double.toString(totalDeduction));
        totalNetSalaryText.setText(Double.toString(totalNetSalary));
    }
    
    private void formatPayrollTable() {
        payrollReportTable.getColumnModel().getColumn(0).setMinWidth(50);
            payrollReportTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            payrollReportTable.getColumnModel().getColumn(0).setMaxWidth(50);
            payrollReportTable.getColumnModel().getColumn(1).setMinWidth(110);
            payrollReportTable.getColumnModel().getColumn(1).setPreferredWidth(110);
            payrollReportTable.getColumnModel().getColumn(1).setMaxWidth(110);
            payrollReportTable.getColumnModel().getColumn(2).setMinWidth(400);
            payrollReportTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            payrollReportTable.getColumnModel().getColumn(2).setMaxWidth(400);
            payrollReportTable.getColumnModel().getColumn(3).setMinWidth(120);
            payrollReportTable.getColumnModel().getColumn(3).setPreferredWidth(120);
            payrollReportTable.getColumnModel().getColumn(3).setMaxWidth(120);
            payrollReportTable.getColumnModel().getColumn(4).setMinWidth(100);
            payrollReportTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            payrollReportTable.getColumnModel().getColumn(4).setMaxWidth(100);
            payrollReportTable.getColumnModel().getColumn(5).setMinWidth(70);
            payrollReportTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            payrollReportTable.getColumnModel().getColumn(5).setMaxWidth(70);
            payrollReportTable.getColumnModel().getColumn(6).setMinWidth(70);
            payrollReportTable.getColumnModel().getColumn(6).setPreferredWidth(70);
            payrollReportTable.getColumnModel().getColumn(6).setMaxWidth(70);
            payrollReportTable.getColumnModel().getColumn(7).setMinWidth(100);
            payrollReportTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            payrollReportTable.getColumnModel().getColumn(7).setMaxWidth(100);
            payrollReportTable.getColumnModel().getColumn(8).setMinWidth(120);
            payrollReportTable.getColumnModel().getColumn(8).setPreferredWidth(120);
            payrollReportTable.getColumnModel().getColumn(8).setMaxWidth(120);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basicSalaryTotalText1 = new javax.swing.JLabel();
        payrollReportTitleLabel = new javax.swing.JLabel();
        closePayrollReportButton = new javax.swing.JButton();
        payrollReportScrollPane = new javax.swing.JScrollPane();
        payrollReportTable = new javax.swing.JTable();
        totalLabel = new javax.swing.JLabel();
        totalBasicSalaryText = new javax.swing.JLabel();
        totalAllowanceText = new javax.swing.JLabel();
        totalEPFText = new javax.swing.JLabel();
        totalSOCSOText = new javax.swing.JLabel();
        totalDeductionText = new javax.swing.JLabel();
        totalNetSalaryText = new javax.swing.JLabel();

        basicSalaryTotalText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        basicSalaryTotalText1.setText("00000");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        payrollReportTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        payrollReportTitleLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        payrollReportTitleLabel.setText("Payroll Report - January");

        closePayrollReportButton.setText("Close Payroll Report");
        closePayrollReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closePayrollReportButtonActionPerformed(evt);
            }
        });

        payrollReportTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        payrollReportTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 18));
        payrollReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Emp. ID", "Employee Name", "Basic", "Additional", "EPF", "SOCSO", "Deductions", "Net"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        payrollReportTable.setRowHeight(24);
        payrollReportTable.getTableHeader().setReorderingAllowed(false);
        payrollReportScrollPane.setViewportView(payrollReportTable);
        if (payrollReportTable.getColumnModel().getColumnCount() > 0) {
            payrollReportTable.getColumnModel().getColumn(0).setMinWidth(50);
            payrollReportTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            payrollReportTable.getColumnModel().getColumn(0).setMaxWidth(50);
            payrollReportTable.getColumnModel().getColumn(1).setMinWidth(110);
            payrollReportTable.getColumnModel().getColumn(1).setPreferredWidth(110);
            payrollReportTable.getColumnModel().getColumn(1).setMaxWidth(110);
            payrollReportTable.getColumnModel().getColumn(2).setMinWidth(400);
            payrollReportTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            payrollReportTable.getColumnModel().getColumn(2).setMaxWidth(400);
            payrollReportTable.getColumnModel().getColumn(3).setMinWidth(120);
            payrollReportTable.getColumnModel().getColumn(3).setPreferredWidth(120);
            payrollReportTable.getColumnModel().getColumn(3).setMaxWidth(120);
            payrollReportTable.getColumnModel().getColumn(4).setMinWidth(100);
            payrollReportTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            payrollReportTable.getColumnModel().getColumn(4).setMaxWidth(100);
            payrollReportTable.getColumnModel().getColumn(5).setMinWidth(100);
            payrollReportTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            payrollReportTable.getColumnModel().getColumn(5).setMaxWidth(100);
            payrollReportTable.getColumnModel().getColumn(6).setMinWidth(100);
            payrollReportTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            payrollReportTable.getColumnModel().getColumn(6).setMaxWidth(100);
            payrollReportTable.getColumnModel().getColumn(7).setMinWidth(100);
            payrollReportTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            payrollReportTable.getColumnModel().getColumn(7).setMaxWidth(100);
            payrollReportTable.getColumnModel().getColumn(8).setMinWidth(120);
            payrollReportTable.getColumnModel().getColumn(8).setPreferredWidth(120);
            payrollReportTable.getColumnModel().getColumn(8).setMaxWidth(120);
        }

        totalLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalLabel.setText("Total");

        totalBasicSalaryText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalBasicSalaryText.setText("00000");

        totalAllowanceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalAllowanceText.setText("00000");

        totalEPFText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalEPFText.setText("00000");

        totalSOCSOText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalSOCSOText.setText("00000");

        totalDeductionText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalDeductionText.setText("00000");

        totalNetSalaryText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalNetSalaryText.setText("00000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(519, 519, 519)
                        .addComponent(totalLabel)
                        .addGap(30, 30, 30)
                        .addComponent(totalBasicSalaryText)
                        .addGap(73, 73, 73)
                        .addComponent(totalAllowanceText)
                        .addGap(56, 56, 56)
                        .addComponent(totalEPFText)
                        .addGap(41, 41, 41)
                        .addComponent(totalSOCSOText)
                        .addGap(59, 59, 59)
                        .addComponent(totalDeductionText)
                        .addGap(44, 44, 44)
                        .addComponent(totalNetSalaryText)
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(payrollReportScrollPane)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(payrollReportTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closePayrollReportButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closePayrollReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payrollReportTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payrollReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalBasicSalaryText)
                    .addComponent(totalAllowanceText)
                    .addComponent(totalEPFText)
                    .addComponent(totalSOCSOText)
                    .addComponent(totalDeductionText)
                    .addComponent(totalNetSalaryText))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closePayrollReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePayrollReportButtonActionPerformed
        adminPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_closePayrollReportButtonActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPayrollReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPayrollReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPayrollReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPayrollReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel basicSalaryTotalText1;
    private javax.swing.JButton closePayrollReportButton;
    private javax.swing.JScrollPane payrollReportScrollPane;
    private javax.swing.JTable payrollReportTable;
    private javax.swing.JLabel payrollReportTitleLabel;
    private javax.swing.JLabel totalAllowanceText;
    private javax.swing.JLabel totalBasicSalaryText;
    private javax.swing.JLabel totalDeductionText;
    private javax.swing.JLabel totalEPFText;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalNetSalaryText;
    private javax.swing.JLabel totalSOCSOText;
    // End of variables declaration//GEN-END:variables
}
