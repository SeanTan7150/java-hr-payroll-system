package hrpayrollsystem;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminPayrollReportPage extends javax.swing.JFrame {
    
    private Interface hrInterface;
    private AdminPage adminPage;
    
    public AdminPayrollReportPage(Interface hrInterface, AdminPage adminPage) throws RemoteException {
        initComponents();
        this.hrInterface = hrInterface;
        this.adminPage = adminPage;
        
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        
        payrollReportTitleLabel.setText("Payroll Report - " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.getDefault()));
        
        String[] tableHeaders = new String[] {
            "No.", "Emp. ID", "Employee Name", "Basic", "Allowance", "EPF", "SOCSO", "Deduction", "Net"
        };
        
        ArrayList<Employee> employeeList = hrInterface.getAllEmployeeFullDetails(currentMonth);
        
        DefaultTableModel tableModel = new DefaultTableModel(tableHeaders, 0);
        int tableCount = 0;
        double totalBasicSalary = 0, totalAllowance = 0, totalEPF = 0, totalSOCSO = 0, totalDeduction = 0, totalNetSalary = 0;
        for(Employee employee : employeeList) {
            tableCount++;
            double empEPF = employee.getBasicSalary() * hrInterface.getEPF();
            double empSOCSO = employee.getBasicSalary() * hrInterface.getSOCSO();
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
        totalBasicSalaryLabel1 = new javax.swing.JLabel();
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
        totalBasicSalaryLabel = new javax.swing.JLabel();
        totalBasicSalaryLabel2 = new javax.swing.JLabel();
        totalBasicSalaryLabel3 = new javax.swing.JLabel();
        totalBasicSalaryLabel4 = new javax.swing.JLabel();
        totalBasicSalaryLabel5 = new javax.swing.JLabel();
        totalBasicSalaryLabel6 = new javax.swing.JLabel();

        basicSalaryTotalText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        basicSalaryTotalText1.setText("00000");

        totalBasicSalaryLabel1.setText("Basic Salary");

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

        payrollReportScrollPane.setMaximumSize(new java.awt.Dimension(800, 32767));
        payrollReportScrollPane.setPreferredSize(new java.awt.Dimension(305, 402));
        payrollReportScrollPane.setRequestFocusEnabled(false);

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
            payrollReportTable.getColumnModel().getColumn(1).setMinWidth(120);
            payrollReportTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            payrollReportTable.getColumnModel().getColumn(1).setMaxWidth(120);
            payrollReportTable.getColumnModel().getColumn(2).setMinWidth(300);
            payrollReportTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            payrollReportTable.getColumnModel().getColumn(2).setMaxWidth(300);
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
            payrollReportTable.getColumnModel().getColumn(8).setResizable(false);
            payrollReportTable.getColumnModel().getColumn(8).setPreferredWidth(120);
        }

        totalLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        totalBasicSalaryLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalBasicSalaryLabel.setText("Basic Salary");

        totalBasicSalaryLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalBasicSalaryLabel2.setText("Additional Allowance");

        totalBasicSalaryLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalBasicSalaryLabel3.setText("EPF");

        totalBasicSalaryLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalBasicSalaryLabel4.setText("SOCSO");

        totalBasicSalaryLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalBasicSalaryLabel5.setText("Deductions");

        totalBasicSalaryLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalBasicSalaryLabel6.setText("Net Salary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payrollReportScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(payrollReportTitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 613, Short.MAX_VALUE)
                        .addComponent(closePayrollReportButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalBasicSalaryLabel)
                                    .addComponent(totalBasicSalaryLabel2)
                                    .addComponent(totalBasicSalaryLabel3))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(totalEPFText)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(totalBasicSalaryText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalAllowanceText, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(115, 115, 115)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalBasicSalaryLabel4)
                                    .addComponent(totalBasicSalaryLabel5)
                                    .addComponent(totalBasicSalaryLabel6))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalNetSalaryText)
                                    .addComponent(totalDeductionText)
                                    .addComponent(totalSOCSOText))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closePayrollReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payrollReportTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payrollReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBasicSalaryLabel)
                    .addComponent(totalBasicSalaryText)
                    .addComponent(totalBasicSalaryLabel4)
                    .addComponent(totalSOCSOText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBasicSalaryLabel2)
                    .addComponent(totalAllowanceText)
                    .addComponent(totalBasicSalaryLabel5)
                    .addComponent(totalDeductionText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalBasicSalaryLabel3)
                    .addComponent(totalEPFText)
                    .addComponent(totalBasicSalaryLabel6)
                    .addComponent(totalNetSalaryText))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closePayrollReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePayrollReportButtonActionPerformed
        adminPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_closePayrollReportButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel basicSalaryTotalText1;
    private javax.swing.JButton closePayrollReportButton;
    private javax.swing.JScrollPane payrollReportScrollPane;
    private javax.swing.JTable payrollReportTable;
    private javax.swing.JLabel payrollReportTitleLabel;
    private javax.swing.JLabel totalAllowanceText;
    private javax.swing.JLabel totalBasicSalaryLabel;
    private javax.swing.JLabel totalBasicSalaryLabel1;
    private javax.swing.JLabel totalBasicSalaryLabel2;
    private javax.swing.JLabel totalBasicSalaryLabel3;
    private javax.swing.JLabel totalBasicSalaryLabel4;
    private javax.swing.JLabel totalBasicSalaryLabel5;
    private javax.swing.JLabel totalBasicSalaryLabel6;
    private javax.swing.JLabel totalBasicSalaryText;
    private javax.swing.JLabel totalDeductionText;
    private javax.swing.JLabel totalEPFText;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalNetSalaryText;
    private javax.swing.JLabel totalSOCSOText;
    // End of variables declaration//GEN-END:variables
}
