/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Paciente;
import Model.Paciente_DAO;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.text.ParseException;
import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author tsous
 */
public class Inicio_GUI extends javax.swing.JFrame {
    
    private Paciente_DAO pacienteAtual;

    /**
     * Creates new form Inicio_GUI
     */
    public Inicio_GUI() {
        initComponents();
        carregarPacientes();
    }

    private void carregarPacientes() {
        // Obter o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPacientes.getModel();
    
        // Limpar todas as linhas existentes no modelo da tabela
        modeloTabela.setRowCount(0);
        
        Paciente dao = new Paciente();
        List<Paciente_DAO> pacientes = dao.listarPacientes();
        for (Paciente_DAO paciente : pacientes) {
            modeloTabela.addRow(new Object[]{
                paciente.getId(), 
                paciente.getNome(), 
                paciente.getCpf(), 
                paciente.getDataNascimento(), 
                paciente.getSexo(), 
                paciente.getEnderecoRua() + ", " + paciente.getEnderecoNumero() + ", " + paciente.getEnderecoBairro() + ", " + paciente.getEnderecoCidade() + ", " + paciente.getEnderecoEstado(), 
                paciente.getContatoEmail(), 
                paciente.getContatoTelefone(), 
                paciente.getContatoCelular(), 
                paciente.getObservacoes()
            });
        }
    }
    
    // Método para carregar os dados do paciente no formulário
    public void carregarDadosPaciente(Paciente_DAO paciente) {
        this.pacienteAtual = paciente;
        nome_txt.setText(paciente.getNome());
        cpf_txt.setText(paciente.getCpf());
        dataNascimento_txt.setText(paciente.getDataNascimento().toString());
        sexo_txt.setSelectedItem(paciente.getSexo());
        enderecoRua_txt.setText(paciente.getEnderecoRua());
        enderecoNumero_txt.setText(paciente.getEnderecoNumero());
        enderecoBairro_txt.setText(paciente.getEnderecoBairro());
        enderecoCidade_txt.setText(paciente.getEnderecoCidade());
        enderecoEstado_txt.setText(paciente.getEnderecoEstado());
        contatoEmail_txt.setText(paciente.getContatoEmail());
        contatoTelefone_txt.setText(paciente.getContatoTelefone());
        contatoCelular_txt.setText(paciente.getContatoCelular());
        observacoes_txt.setText(paciente.getObservacoes());
    }
    
    private void gerarAtestado() {
        String nomePaciente = nomePaciente_txt.getText();
        String cpfPaciente = cpfPaciente_txt.getText();

        String nomeArquivo = "Atestado_" + nomePaciente.replace(" ", "_") + ".pdf";

        try {
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(nomeArquivo));
            documento.open();

            // Título
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("ATESTADO", boldFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            documento.add(new Paragraph("\n"));

            // Texto do atestado
            Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
            Paragraph atestado = new Paragraph(
                "Atesto para os devidos fins que o Sr.(a) " + nomePaciente + ", portador do CPF nº " + cpfPaciente + ", "
                + "compareceu a esta Clínica às " + new SimpleDateFormat("HH:mm").format(new Date()) + " para tratamento odontológico e necessita de repouso no dia de hoje.",
                normalFont
            );
            atestado.setAlignment(Element.ALIGN_JUSTIFIED);
            atestado.setFirstLineIndent(20);
            documento.add(atestado);

            documento.add(new Paragraph("\n"));

            // Local e data
            Paragraph localData = new Paragraph(
                "Local e data: Cidade, " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
                normalFont
            );
            localData.setAlignment(Element.ALIGN_CENTER);
            documento.add(localData);

            documento.add(new Paragraph("\n"));

            // Assinatura
            Paragraph assinatura = new Paragraph("Assinatura do Dentista", normalFont);
            assinatura.setAlignment(Element.ALIGN_CENTER);
            documento.add(assinatura);

            documento.close();

            JOptionPane.showMessageDialog(this, "Atestado gerado com sucesso: " + nomeArquivo);

            // Abrir o documento
            if (Desktop.isDesktopSupported()) {
                try {
                    File arquivo = new File(nomeArquivo);
                    Desktop.getDesktop().open(arquivo);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro ao abrir o documento.");
                }
            }

        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao gerar atestado.");
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        menu_mn = new javax.swing.JTabbedPane();
        inicio_mn = new javax.swing.JPanel();
        inicio = new javax.swing.JPanel();
        cadPaciente_btn = new javax.swing.JButton();
        gerarAtest_btn = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        cadPaciente_mn = new javax.swing.JPanel();
        cadPaciente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        nome_txt = new javax.swing.JTextField();
        cpf_txt = new javax.swing.JTextField();
        sexo_txt = new javax.swing.JComboBox<>();
        dataNascimento_txt = new javax.swing.JTextField();
        enderecoRua_txt = new javax.swing.JTextField();
        enderecoNumero_txt = new javax.swing.JTextField();
        enderecoBairro_txt = new javax.swing.JTextField();
        enderecoCidade_txt = new javax.swing.JTextField();
        enderecoEstado_txt = new javax.swing.JTextField();
        contatoEmail_txt = new javax.swing.JTextField();
        contatoTelefone_txt = new javax.swing.JTextField();
        contatoCelular_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cadastrar_btn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        observacoes_txt = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        atualizar_btn = new javax.swing.JButton();
        listaPacientes_mn = new javax.swing.JPanel();
        listaPacientes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPacientes = new javax.swing.JTable();
        excluir_btn = new javax.swing.JButton();
        editar_btn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        atestado_mn = new javax.swing.JPanel();
        atestado = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        gerarAtestado_btn = new javax.swing.JButton();
        nomePaciente_txt = new javax.swing.JTextField();
        cpfPaciente_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        sair_mn = new javax.swing.JPanel();
        sair = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        menu_mn.setBackground(new java.awt.Color(255, 255, 255));
        menu_mn.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 51)));
        menu_mn.setForeground(new java.awt.Color(0, 102, 51));
        menu_mn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_mn.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        menu_mn.setPreferredSize(new java.awt.Dimension(800, 600));

        inicio_mn.setForeground(new java.awt.Color(0, 102, 51));
        inicio_mn.setPreferredSize(new java.awt.Dimension(800, 600));

        inicio.setBackground(new java.awt.Color(255, 255, 255));

        cadPaciente_btn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cadPaciente_btn.setForeground(new java.awt.Color(0, 102, 51));
        cadPaciente_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clientes.png"))); // NOI18N
        cadPaciente_btn.setText("Cadastrar Paciente");
        cadPaciente_btn.setToolTipText("");
        cadPaciente_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        cadPaciente_btn.setContentAreaFilled(false);
        cadPaciente_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cadPaciente_btn.setFocusPainted(false);
        cadPaciente_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cadPaciente_btn.setIconTextGap(20);
        cadPaciente_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cadPaciente_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadPaciente_btnActionPerformed(evt);
            }
        });

        gerarAtest_btn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gerarAtest_btn.setForeground(new java.awt.Color(0, 102, 51));
        gerarAtest_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/atestado.png"))); // NOI18N
        gerarAtest_btn.setText("Atestado");
        gerarAtest_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        gerarAtest_btn.setContentAreaFilled(false);
        gerarAtest_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gerarAtest_btn.setFocusPainted(false);
        gerarAtest_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gerarAtest_btn.setIconTextGap(20);
        gerarAtest_btn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        gerarAtest_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarAtest_btnActionPerformed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_inicio.jpg"))); // NOI18N

        jSeparator4.setForeground(new java.awt.Color(0, 102, 51));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicioLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel24)
                .addGap(27, 27, 27)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gerarAtest_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadPaciente_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioLayout.createSequentialGroup()
                .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inicioLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadPaciente_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addComponent(gerarAtest_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inicioLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout inicio_mnLayout = new javax.swing.GroupLayout(inicio_mn);
        inicio_mn.setLayout(inicio_mnLayout);
        inicio_mnLayout.setHorizontalGroup(
            inicio_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        inicio_mnLayout.setVerticalGroup(
            inicio_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu_mn.addTab("INICIO", inicio_mn);

        cadPaciente.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CPF:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Estado:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cidade:");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Rua:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Bairro:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("nº:");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Email:");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Tel:");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cel:");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Endereço");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Dados Pessoais");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Contato");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Data de Nascimento:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Genero:");

        nome_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_txtActionPerformed(evt);
            }
        });

        sexo_txt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("CADASTRO DE PACIENTES");

        cadastrar_btn.setBackground(new java.awt.Color(0, 102, 51));
        cadastrar_btn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cadastrar_btn.setForeground(new java.awt.Color(255, 255, 255));
        cadastrar_btn.setText("CADASTRAR");
        cadastrar_btn.setFocusPainted(false);
        cadastrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrar_btnActionPerformed(evt);
            }
        });

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info.png"))); // NOI18N

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/end.png"))); // NOI18N

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/contato.png"))); // NOI18N

        observacoes_txt.setColumns(20);
        observacoes_txt.setRows(5);
        jScrollPane3.setViewportView(observacoes_txt);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Observações:");

        atualizar_btn.setBackground(new java.awt.Color(0, 102, 51));
        atualizar_btn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        atualizar_btn.setForeground(new java.awt.Color(255, 255, 255));
        atualizar_btn.setText("ATUALIZAR");
        atualizar_btn.setFocusPainted(false);
        atualizar_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadPacienteLayout = new javax.swing.GroupLayout(cadPaciente);
        cadPaciente.setLayout(cadPacienteLayout);
        cadPacienteLayout.setHorizontalGroup(
            cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadPacienteLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cadPacienteLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadPacienteLayout.createSequentialGroup()
                                .addGap(319, 319, 319)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addComponent(cpf_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(sexo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(dataNascimento_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enderecoRua_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enderecoNumero_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enderecoBairro_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadPacienteLayout.createSequentialGroup()
                                .addComponent(enderecoCidade_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enderecoEstado_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contatoEmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadPacienteLayout.createSequentialGroup()
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cadPacienteLayout.createSequentialGroup()
                                .addComponent(contatoTelefone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3))
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadPacienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contatoCelular_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadPacienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(atualizar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cadastrar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(59, 59, 59))
            .addGroup(cadPacienteLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cadPacienteLayout.setVerticalGroup(
            cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadPacienteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadPacienteLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))))
                        .addGap(11, 11, 11)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataNascimento_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadPacienteLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel4)))))
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(enderecoRua_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(enderecoNumero_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(enderecoBairro_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(enderecoCidade_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(enderecoEstado_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21))
                .addGap(6, 6, 6)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(contatoEmail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(contatoTelefone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(contatoCelular_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 36, Short.MAX_VALUE)
                .addGroup(cadPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cadPacienteLayout.createSequentialGroup()
                        .addComponent(cadastrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(atualizar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout cadPaciente_mnLayout = new javax.swing.GroupLayout(cadPaciente_mn);
        cadPaciente_mn.setLayout(cadPaciente_mnLayout);
        cadPaciente_mnLayout.setHorizontalGroup(
            cadPaciente_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cadPaciente_mnLayout.setVerticalGroup(
            cadPaciente_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu_mn.addTab("CADASTRAR PACIENTE", cadPaciente_mn);

        listaPacientes.setBackground(new java.awt.Color(255, 255, 255));

        tabelaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Data de Nascimento", "Genero", "Endereço", "Email", "Telefone", "Celular", "Observações"
            }
        ));
        jScrollPane1.setViewportView(tabelaPacientes);

        excluir_btn.setBackground(new java.awt.Color(0, 102, 51));
        excluir_btn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        excluir_btn.setForeground(new java.awt.Color(255, 255, 255));
        excluir_btn.setText("EXCLUIR");
        excluir_btn.setFocusPainted(false);
        excluir_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_btnActionPerformed(evt);
            }
        });

        editar_btn.setBackground(new java.awt.Color(0, 102, 51));
        editar_btn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        editar_btn.setForeground(new java.awt.Color(255, 255, 255));
        editar_btn.setText("EDITAR");
        editar_btn.setFocusPainted(false);
        editar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_btnActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 51));
        jLabel23.setText("Selecione o paciente para editar os dados ou excluir do cadastro:");

        javax.swing.GroupLayout listaPacientesLayout = new javax.swing.GroupLayout(listaPacientes);
        listaPacientes.setLayout(listaPacientesLayout);
        listaPacientesLayout.setHorizontalGroup(
            listaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaPacientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listaPacientesLayout.createSequentialGroup()
                .addGap(37, 347, Short.MAX_VALUE)
                .addGroup(listaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listaPacientesLayout.createSequentialGroup()
                        .addComponent(editar_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluir_btn)))
                .addGap(56, 56, 56))
        );
        listaPacientesLayout.setVerticalGroup(
            listaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaPacientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(listaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excluir_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout listaPacientes_mnLayout = new javax.swing.GroupLayout(listaPacientes_mn);
        listaPacientes_mn.setLayout(listaPacientes_mnLayout);
        listaPacientes_mnLayout.setHorizontalGroup(
            listaPacientes_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listaPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        listaPacientes_mnLayout.setVerticalGroup(
            listaPacientes_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listaPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu_mn.addTab("LISTA DE PACIENTES", listaPacientes_mn);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        gerarAtestado_btn.setBackground(new java.awt.Color(0, 102, 51));
        gerarAtestado_btn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gerarAtestado_btn.setForeground(new java.awt.Color(255, 255, 255));
        gerarAtestado_btn.setText("GERAR ATESTADO");
        gerarAtestado_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarAtestado_btnActionPerformed(evt);
            }
        });

        nomePaciente_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomePaciente_txtActionPerformed(evt);
            }
        });

        cpfPaciente_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfPaciente_txtActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("NOME:");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("CPF:");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ATESTADO DE COMPARECIMENTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomePaciente_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfPaciente_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(gerarAtestado_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nomePaciente_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cpfPaciente_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(gerarAtestado_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout atestadoLayout = new javax.swing.GroupLayout(atestado);
        atestado.setLayout(atestadoLayout);
        atestadoLayout.setHorizontalGroup(
            atestadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        atestadoLayout.setVerticalGroup(
            atestadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout atestado_mnLayout = new javax.swing.GroupLayout(atestado_mn);
        atestado_mn.setLayout(atestado_mnLayout);
        atestado_mnLayout.setHorizontalGroup(
            atestado_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        atestado_mnLayout.setVerticalGroup(
            atestado_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu_mn.addTab("ATESTADO", atestado_mn);

        sair.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.jpg"))); // NOI18N

        logout_btn.setBackground(new java.awt.Color(0, 102, 51));
        logout_btn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        logout_btn.setForeground(new java.awt.Color(255, 255, 255));
        logout_btn.setText("FAZER LOGOUT");
        logout_btn.setFocusPainted(false);
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sairLayout = new javax.swing.GroupLayout(sair);
        sair.setLayout(sairLayout);
        sairLayout.setHorizontalGroup(
            sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sairLayout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(216, 216, 216))
        );
        sairLayout.setVerticalGroup(
            sairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sairLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sair_mnLayout = new javax.swing.GroupLayout(sair_mn);
        sair_mn.setLayout(sair_mnLayout);
        sair_mnLayout.setHorizontalGroup(
            sair_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sair_mnLayout.setVerticalGroup(
            sair_mnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menu_mn.addTab("SAIR", sair_mn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_mn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu_mn, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void editar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_btnActionPerformed
        int selectedRow = tabelaPacientes.getSelectedRow();
        if (selectedRow >= 0) {
            int pacienteId = (int) tabelaPacientes.getValueAt(selectedRow, 0);
            Paciente dao = new Paciente();
            Paciente_DAO paciente = dao.obterPaciente(pacienteId);

            if (paciente != null) {
                carregarDadosPaciente(paciente);
                menu_mn.setSelectedComponent(cadPaciente_mn);
            } else {
                JOptionPane.showMessageDialog(null, "Paciente não encontrado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um paciente para editar!");
        }
    }//GEN-LAST:event_editar_btnActionPerformed

    private void excluir_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_btnActionPerformed
        int selectedRow = tabelaPacientes.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) tabelaPacientes.getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o paciente?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Paciente dao = new Paciente();
                dao.deletarPaciente(id);

                carregarPacientes(); // Recarrega os pacientes para atualizar a tabela
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um paciente para excluir.");
        }
    }//GEN-LAST:event_excluir_btnActionPerformed

    private void atualizar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizar_btnActionPerformed
        if (pacienteAtual != null) {
            pacienteAtual.setNome(nome_txt.getText());
            pacienteAtual.setCpf(cpf_txt.getText());

            // Conversão da data de nascimento
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataNascimento = sdf.parse(dataNascimento_txt.getText());
                pacienteAtual.setDataNascimento(dataNascimento);
            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd/MM/yyyy");
                return;
            }

            pacienteAtual.setSexo((String) sexo_txt.getSelectedItem());
            pacienteAtual.setEnderecoRua(enderecoRua_txt.getText());
            pacienteAtual.setEnderecoNumero(enderecoNumero_txt.getText());
            pacienteAtual.setEnderecoBairro(enderecoBairro_txt.getText());
            pacienteAtual.setEnderecoCidade(enderecoCidade_txt.getText());
            pacienteAtual.setEnderecoEstado(enderecoEstado_txt.getText());
            pacienteAtual.setContatoEmail(contatoEmail_txt.getText());
            pacienteAtual.setContatoTelefone(contatoTelefone_txt.getText());
            pacienteAtual.setContatoCelular(contatoCelular_txt.getText());
            pacienteAtual.setObservacoes(observacoes_txt.getText());

            // Criação do objeto DAO e chamada ao método atualizarPaciente
            Paciente dao = new Paciente();
            dao.atualizarPaciente(pacienteAtual);

            // Mensagem de confirmação
            JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso!");

            limparCampos(); // Limpar campos após cadastro
            carregarPacientes();  // Recarrega os pacientes para atualizar a tabela
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum paciente selecionado para atualizar!");
        }
    }//GEN-LAST:event_atualizar_btnActionPerformed

    private void cadastrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrar_btnActionPerformed
        // Criação do objeto paciente
        Paciente_DAO paciente = new Paciente_DAO();
        paciente.setNome(nome_txt.getText());
        paciente.setCpf(cpf_txt.getText());

        // Conversão da data de nascimento
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNascimento = sdf.parse(dataNascimento_txt.getText());
            paciente.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use dd/MM/yyyy");
            return;
        }

        paciente.setSexo((String) sexo_txt.getSelectedItem());
        paciente.setEnderecoRua(enderecoRua_txt.getText());
        paciente.setEnderecoNumero(enderecoNumero_txt.getText());
        paciente.setEnderecoBairro(enderecoBairro_txt.getText());
        paciente.setEnderecoCidade(enderecoCidade_txt.getText());
        paciente.setEnderecoEstado(enderecoEstado_txt.getText());
        paciente.setContatoEmail(contatoEmail_txt.getText());
        paciente.setContatoTelefone(contatoTelefone_txt.getText());
        paciente.setContatoCelular(contatoCelular_txt.getText());
        paciente.setObservacoes(observacoes_txt.getText());

        // Criação do objeto DAO e chamada ao método adicionarPaciente
        Paciente dao = new Paciente();
        dao.adicionarPaciente(paciente);

        // Mensagem de confirmação
        JOptionPane.showMessageDialog(null, "Paciente adicionado com sucesso!");

        limparCampos(); // Limpar campos após cadastro
        carregarPacientes();  // Recarrega os pacientes para atualizar a tabela
    }//GEN-LAST:event_cadastrar_btnActionPerformed

    private void nome_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_txtActionPerformed

    private void gerarAtest_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarAtest_btnActionPerformed
        menu_mn.setSelectedComponent(atestado_mn);
    }//GEN-LAST:event_gerarAtest_btnActionPerformed

    private void cadPaciente_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadPaciente_btnActionPerformed
        menu_mn.setSelectedComponent(cadPaciente_mn);
    }//GEN-LAST:event_cadPaciente_btnActionPerformed

    private void nomePaciente_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomePaciente_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomePaciente_txtActionPerformed

    private void cpfPaciente_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfPaciente_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfPaciente_txtActionPerformed

    private void gerarAtestado_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarAtestado_btnActionPerformed
        gerarAtestado();
    }//GEN-LAST:event_gerarAtestado_btnActionPerformed
        
    private void limparCampos() {
        nome_txt.setText("");
        cpf_txt.setText("");
        dataNascimento_txt.setText("");
        sexo_txt.setSelectedIndex(0); // Supondo que o índice 0 é o padrão
        enderecoRua_txt.setText("");
        enderecoNumero_txt.setText("");
        enderecoBairro_txt.setText("");
        enderecoCidade_txt.setText("");
        enderecoEstado_txt.setText("");
        contatoEmail_txt.setText("");
        contatoTelefone_txt.setText("");
        contatoCelular_txt.setText("");
        observacoes_txt.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicio_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atestado;
    private javax.swing.JPanel atestado_mn;
    private javax.swing.JButton atualizar_btn;
    private javax.swing.JPanel cadPaciente;
    private javax.swing.JButton cadPaciente_btn;
    private javax.swing.JPanel cadPaciente_mn;
    private javax.swing.JButton cadastrar_btn;
    private javax.swing.JTextField contatoCelular_txt;
    private javax.swing.JTextField contatoEmail_txt;
    private javax.swing.JTextField contatoTelefone_txt;
    private javax.swing.JTextField cpfPaciente_txt;
    private javax.swing.JTextField cpf_txt;
    private javax.swing.JTextField dataNascimento_txt;
    private javax.swing.JButton editar_btn;
    private javax.swing.JTextField enderecoBairro_txt;
    private javax.swing.JTextField enderecoCidade_txt;
    private javax.swing.JTextField enderecoEstado_txt;
    private javax.swing.JTextField enderecoNumero_txt;
    private javax.swing.JTextField enderecoRua_txt;
    private javax.swing.JButton excluir_btn;
    private javax.swing.JButton gerarAtest_btn;
    private javax.swing.JButton gerarAtestado_btn;
    private javax.swing.JPanel inicio;
    private javax.swing.JPanel inicio_mn;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel listaPacientes;
    private javax.swing.JPanel listaPacientes_mn;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTabbedPane menu_mn;
    private javax.swing.JTextField nomePaciente_txt;
    private javax.swing.JTextField nome_txt;
    private javax.swing.JTextArea observacoes_txt;
    private javax.swing.JPanel sair;
    private javax.swing.JPanel sair_mn;
    private javax.swing.JComboBox<String> sexo_txt;
    private javax.swing.JTable tabelaPacientes;
    // End of variables declaration//GEN-END:variables
}
