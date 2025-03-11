package kuis.pages;

import java.awt.*;
import java.awt.desktop.OpenFilesEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainPage extends JFrame implements ItemListener, ActionListener{
    private JLabel namaDepan, namaBelakang, divisi, jenisKelamin, textArea; 
    private JTextField tfNamaDepan, tfNamaBelakang; 
    private JRadioButton rb1,rb2; 
    private String div[] = {"IT", "HRD", "Finance", "Marketing"}; 
    private JComboBox cb; 
    private JTextArea ta; 
    private JButton btnSave, eksportBtn, importBtn; 
    private JPanel panel1, panel2, panel3, panel4;
    private JScrollPane sp;
    private ButtonGroup grup; 
    private ArrayList<String[]> data;
    private JCheckBox cekbok;
    public MainPage(String username){
        super("Input Member by " + username);
        setLayout(new BorderLayout(0,0)); 
        data = new ArrayList<String[]>();
        panel1 = new  JPanel(new GridLayout(3,3)); 
        namaDepan = new JLabel("Nama Depan : "); 
        namaBelakang = new JLabel("Nama Belakang"); 
        tfNamaDepan = new JTextField(10); 
        tfNamaBelakang = new JTextField(10); 
        jenisKelamin = new JLabel("Jenis Kelamin"); 
        divisi = new JLabel("Divisi"); 
        panel2 = new JPanel(new GridLayout(10,2)); 
        panel3 = new JPanel(new GridLayout(1,2)); 
        btnSave = new JButton("Simpan Data"); 
        btnSave.addActionListener(this);
        rb1 = new JRadioButton("Laki - Laki"); 
        rb2 = new JRadioButton("Perempuan"); 
        cb = new JComboBox(div); 
        cb.addItemListener(this); 
        ta = new JTextArea();
        sp = new JScrollPane(ta); 
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        grup = new ButtonGroup();
        textArea = new JLabel("List Data");
        eksportBtn = new JButton("Export to Txt"); 
        eksportBtn.addActionListener(this);
        importBtn = new JButton("Import from Txt"); 
        importBtn.addActionListener(this);
        
        panel4 = new JPanel();
        panel3.add(rb1);
        panel3.add(rb2); 
        
        panel4.add(eksportBtn); 
        panel4.add(importBtn);
        
        panel2.add(divisi);
        panel2.add(cb);
        grup.add(rb1);
        grup.add(rb2);
        panel2.add(jenisKelamin);
        panel2.add(panel3); 
        panel2.add(btnSave); 
        panel2.add(textArea);
        panel2.add(sp);
        panel2.add(panel4);
        
        panel1.add(namaDepan);
        panel1.add(namaBelakang);
        panel1.add(tfNamaDepan);
        panel1.add(tfNamaBelakang); 
        panel1.add(panel2); 
        
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER); 
        add(cekbok, BorderLayout.SOUTH);
        pack();
        setSize(600,600); 
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    public void bacaFile(){
//        ta.read(new FileWriter(JDesktopPane.POPUP_LAYER));
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSave)
        {
            if(tfNamaDepan.getText().isEmpty() || tfNamaBelakang.getText().isEmpty() || grup.getSelection()==null){
                JOptionPane.showMessageDialog(null, "Data Belum Lengkap","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            { 
                //if(cb.getSelectedItem())
                data.add(new String[]{tfNamaDepan.getText() + " " + tfNamaBelakang.getText(), rb1.isSelected()?rb1.getText():rb2.getText(),cb.getSelectedItem().toString()}); 
                for(String[] x:data)
                {
                    ta.append(String.join("|", x) + "\n");
                }
            }
        } 
        if(e.getSource() == eksportBtn)
        {
            try{
                if(ta.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "List Kosong","Error",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    ta.write(new FileWriter("result.txt")); 
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        } 
        if(e.getSource()==importBtn)
        {
            //bacaFile();
        }
    } 
    
}
