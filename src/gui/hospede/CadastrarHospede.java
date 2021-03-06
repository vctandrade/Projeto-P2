package gui.hospede;

import gui.Sistema;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import utils.Internet;
import core.hotel.Hospede;

public class CadastrarHospede extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JFormattedTextField tfTelefone;
	private MaskFormatter ftmTelefone;
	private JFormattedTextField tfCpf;
	private MaskFormatter ftmCpf;
	private JTextField tfEmail;
	private JTextField tfCidade;
	private JTextField tfEndereco;
	private JLabel errorLabel;

	public CadastrarHospede(final JPanel tela) {
		setName("Cadastra H\u00F3spede");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] {0, 0, 0};
		gridBagLayout.columnWidths = new int[] {30, 0, 30};
		gridBagLayout.columnWeights = new double[] { 1.0, 0.25, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.25, 1.0 };
		setLayout(gridBagLayout);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(10, 20, 10, 20)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 10, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0};
		gbl_panel_1.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 1.0, 1.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel label_1 = new JLabel("Nome:");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 10);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);

		tfNome = new JTextField();
		tfNome.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(tfNome, gbc_textField);

		JLabel label_3 = new JLabel("CPF:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 10);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);

		try {
			ftmCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			errorLabel.setText("CPF inv\u00E1lido");
			errorLabel.setVisible(true);
		}

		ftmCpf.setValidCharacters("0123456789");

		tfCpf = new JFormattedTextField(ftmCpf);
		tfCpf.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 1;
		panel_1.add(tfCpf, gbc_textField_2);

		JLabel label_2 = new JLabel("Telefone:");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 10);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel_1.add(label_2, gbc_label_2);

		try {
			ftmTelefone = new MaskFormatter("(##) ####-####");
		} catch (ParseException e2) {
			errorLabel.setText("Telefone inv\u00E1lido");
			errorLabel.setVisible(true);
		}

		ftmTelefone.setValidCharacters("0123456789");

		tfTelefone = new JFormattedTextField(ftmTelefone);
		tfTelefone.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_1.add(tfTelefone, gbc_textField_1);

		JLabel label_4 = new JLabel("E-mail:");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 10);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 3;
		panel_1.add(label_4, gbc_label_4);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		panel_1.add(tfEmail, gbc_textField_3);

		JLabel label_5 = new JLabel("Cidade:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 10);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 4;
		panel_1.add(label_5, gbc_label_5);

		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		panel_1.add(tfCidade, gbc_textField_4);

		JLabel label_6 = new JLabel("Endere\u00E7o:");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 0, 10);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 5;
		panel_1.add(label_6, gbc_label_6);

		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		panel_1.add(tfEndereco, gbc_textField_5);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.anchor = GridBagConstraints.NORTH;
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.rowHeights = new int[] {0};
		gbl_panel_2.columnWidths = new int[] {200, 0, 0};
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gbl_panel_2.rowWeights = new double[] { 0.0 };
		panel_2.setLayout(gbl_panel_2);

		errorLabel = new JLabel("<erro>");
		errorLabel.setVisible(false);
		errorLabel.setForeground(Color.RED);
		errorLabel.setIcon(new ImageIcon(CadastrarHospede.class
				.getResource("/gui/resources/error.png")));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.anchor = GridBagConstraints.WEST;
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 0;
		panel_2.add(errorLabel, gbc_lblError);

		JButton btnCancela = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancela = new GridBagConstraints();
		gbc_btnCancela.anchor = GridBagConstraints.EAST;
		gbc_btnCancela.insets = new Insets(0, 0, 0, 10);
		gbc_btnCancela.gridx = 1;
		gbc_btnCancela.gridy = 0;
		panel_2.add(btnCancela, gbc_btnCancela);
		btnCancela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(tela);
			}
		});

		JButton btnConfirma = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirma = new GridBagConstraints();
		gbc_btnConfirma.gridx = 2;
		gbc_btnConfirma.gridy = 0;
		panel_2.add(btnConfirma, gbc_btnConfirma);
		btnConfirma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (cadastra())
						Sistema.setTela(tela);
				} catch (Exception e1) {
					errorLabel.setText(e1.getMessage());
					errorLabel.setVisible(true);
				}

			}
		});

	}

	private boolean cadastra() throws Exception {

		String nome = tfNome.getText();
		if (nome.equals("") || nome.length() < 3) {
			errorLabel.setText("Nome inv\u00E1lido");
			errorLabel.setVisible(true);
			return false;
		}

		String telefone = tfTelefone.getText();
		String phone = "\\(\\d{2}\\) \\d{4}-\\d{4}";
		if (!Pattern.matches(phone,telefone)){
			errorLabel.setText("Telefone inv\u00E1lido");
			errorLabel.setVisible(true);
			return false;
		}

		String cpf = tfCpf.getText();
		String cpf1 = cpf.replace("-", "");
		String cpf2 = cpf1.replace(".", "");

		if (cpf2.equals("") || !checaValorString(cpf2) || !Hospede.verificaCpf(cpf2)) {
			errorLabel.setText("CPF inv\u00E1lido");
			errorLabel.setVisible(true);
			return false;
		}

		String email = tfEmail.getText();
		if (!Internet.isEmailValido(email)) {
			errorLabel.setText("E-mail inv\u00E1lido");
			errorLabel.setVisible(true);
			return false;
		}

		String cidade = tfCidade.getText();

		if (cidade.equals("") || cidade.length() < 3) {
			errorLabel.setText("Cidade inv\u00E1lida");
			errorLabel.setVisible(true);
			return false;
		}

		String endereco = tfEndereco.getText();

		if (endereco.equals("") || endereco.length() < 3) {
			errorLabel.setText("Endereco inv\u00E1lido");
			errorLabel.setVisible(true);
			return false;
		}

		Sistema.getHotel().adicionaHospede(nome, telefone, cpf2, email, cidade,
				endereco);
		errorLabel.setVisible(false);
		return true;
	}

	private boolean checaValorString(String str) {
		for (int i = 0; i < str.length(); i++)
			if ("0123456789".lastIndexOf(str.charAt(i)) == -1)
				return false;
		return true;
	}

}