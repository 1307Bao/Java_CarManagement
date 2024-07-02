package CM.view.card;

import CM.controller.service.Service;
import CM.model.ModelKhachHang;
import CM.view.admin_component.DialogPanel;
import CM.view.form.AdminKHForm;
import CM.view.form.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminInsertKHCard extends javax.swing.JPanel {

    private ModelKhachHang data;
    private MainForm main;
    private DialogPanel dialog;
    private Service service;
    
    public AdminInsertKHCard(ModelKhachHang data, DialogPanel dialog, MainForm main) throws SQLException {
        this.data = data;
        this.dialog = dialog;
        this.main = main;
        initComponents();
        service = new Service();
        init();
    }
    
    private boolean check(){
        if (!txtSDT.getText().matches("-?\\d+(\\.\\d+)?")) return false;
        if (txtSDT.getText().length() != 10) return false;
        return true;
    }
    
    private void init() throws SQLException{
        lbReport.setText("");
        if (data != null){
            lbIns.setText("Sửa khách hàng");
            cmdAdd.setText("Sửa");
            txtTenKH.setText(data.getTenKH());
            txtSDT.setText(data.getSoDT());
        }
        
        cmdAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!check()){
                    lbReport.setText("Lỗi dữ liệu");
                    return;
                } else {
                    try {
                        for (ModelKhachHang model : service.getListKH()){
                            if (model.getSoDT().equals(txtSDT.getText())){
                                if (data.getSoDT() != null && data.getMaKH() == model.getMaKH())
                                    continue;
                                lbReport.setText("Số điện thoại đã tồn tại");
                                return;
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminInsertKHCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (data != null){
                    
                    data.setTenKH(txtTenKH.getText());
                    data.setSoDT(txtSDT.getText());
                    try {
                        service.updKhachHang(data);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminInsertKHCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dialog.setVisible(false);
                    try {
                        main.showForm(new AdminKHForm(main, dialog));
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminInsertKHCard.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else{
                    try {
                        int maKH = service.getMaKH_next();
                        service.insertKH(new ModelKhachHang(maKH, txtTenKH.getText(), txtSDT.getText()));
                        dialog.setVisible(false);
                        main.showForm(new AdminKHForm(main, dialog));
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminInsertKHCard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
        
        cmdCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
            
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIns = new java.awt.Label();
        lbTenKH = new java.awt.Label();
        txtTenKH = new com.view.swing.TextField();
        lbSDT = new java.awt.Label();
        txtSDT = new com.view.swing.TextField();
        cmdAdd = new com.view.swing.Button();
        cmdCancel = new com.view.swing.Button();
        lbReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(251, 238, 215));

        lbIns.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbIns.setForeground(new java.awt.Color(183, 150, 107));
        lbIns.setText("Thêm khách hàng");

        lbTenKH.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbTenKH.setForeground(new java.awt.Color(183, 150, 107));
        lbTenKH.setText("Tên khách hàng");

        lbSDT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(183, 150, 107));
        lbSDT.setText("Số điện thoại");

        cmdAdd.setForeground(new java.awt.Color(255, 255, 255));
        cmdAdd.setText("Thêm");
        cmdAdd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cmdCancel.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel.setText("Hủy");
        cmdCancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        lbReport.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbReport.setForeground(new java.awt.Color(94, 68, 33));
        lbReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReport.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbReport, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lbReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdAdd;
    private com.view.swing.Button cmdCancel;
    private java.awt.Label lbIns;
    private javax.swing.JLabel lbReport;
    private java.awt.Label lbSDT;
    private java.awt.Label lbTenKH;
    private com.view.swing.TextField txtSDT;
    private com.view.swing.TextField txtTenKH;
    // End of variables declaration//GEN-END:variables

}
