package CM.view.form;

import CM.controller.service.Service;
import CM.model.ModelKhachHang;
import CM.view.admin_component.DialogPanel;
import CM.view.card.AdminInsertKHCard;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminKHForm extends javax.swing.JPanel {

    private MainForm main;
    private DialogPanel dialog;
    private ArrayList<ModelKhachHang> list;
    private Service service;
    
    public AdminKHForm(MainForm main, DialogPanel dialog) throws SQLException {
        service = new Service();
        list = service.getListKH();
        this.main = main;
        this.dialog = dialog;
        initComponents();
        table.fixTable(scroll);
        init();
    }
    
    private void init(){
        txtSearch.setText("");
        txtSearch.setHint("Tên khách hàng");
        for (ModelKhachHang data : list){
            table.addRow(new Object[]{data.getMaKH(), data.getTenKH(), data.getSoDT(), data.getLoaiKH()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbKH = new javax.swing.JLabel();
        txtSearch = new com.view.swing.TextField();
        cmdAdd = new com.view.swing.Button();
        roundPanel1 = new com.view.swing.RoundPanel();
        roundPanel2 = new com.view.swing.RoundPanel();
        scroll = new javax.swing.JScrollPane();
        table = new com.view.swing.Table();
        cmdUpd = new com.view.swing.Button();

        setBackground(new java.awt.Color(251, 238, 215));

        lbKH.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lbKH.setForeground(new java.awt.Color(94, 68, 33));
        lbKH.setText("Khách hàng");
        lbKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbKHMouseClicked(evt);
            }
        });

        txtSearch.setSuffixIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/Finding.png"))); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        cmdAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/+.png"))); // NOI18N
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        roundPanel1.setBackground(new java.awt.Color(183, 150, 107));

        roundPanel2.setBackground(new java.awt.Color(251, 238, 215));

        scroll.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "SDT", "Loại khách hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(255, 255, 255));
        scroll.setViewportView(table);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        cmdUpd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/view/icon/NotePencil.png"))); // NOI18N
        cmdUpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbKH, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(171, 171, 171)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdUpd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbKH)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdUpd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String name = txtSearch.getText().toLowerCase();
        table.removeAllRow();
        for (ModelKhachHang data : list){
            if (data.getTenKH().toLowerCase().contains(name)){
                table.addRow(new Object[]{data.getMaKH(), data.getTenKH(), data.getSoDT(), data.getLoaiKH()});
            }
        }
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchActionPerformed

    private void lbKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbKHMouseClicked
        table.removeAllRow();
        init();
    }//GEN-LAST:event_lbKHMouseClicked

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        try {
            dialog.showForm(new AdminInsertKHCard(null, dialog, main));
        } catch (SQLException ex) {
            Logger.getLogger(AdminKHForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdUpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdActionPerformed
        try {
            int maKH = table.getFirstCol_RowSelected(table.getSelectedRow());
            for (ModelKhachHang data : service.getListKH()){
                if (data.getMaKH() == maKH){
                    dialog.showForm(new AdminInsertKHCard(data, dialog, main));
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminKHForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdUpdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.view.swing.Button cmdAdd;
    private com.view.swing.Button cmdUpd;
    private javax.swing.JLabel lbKH;
    private com.view.swing.RoundPanel roundPanel1;
    private com.view.swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private com.view.swing.Table table;
    private com.view.swing.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
