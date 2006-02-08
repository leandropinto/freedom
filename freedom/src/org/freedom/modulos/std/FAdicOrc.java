/**
 * @version 14/07/2003 <BR>
 * @author Setpoint Inform�tica Ltda./Fernando Oliveira da Silva <BR>
 *
 * Projeto: Freedom <BR>
 *  
 * Pacote: org.freedom.modulos.std <BR>
 * Classe: @(#)FAdicOrc.java <BR>
 * 
 * Este programa � licenciado de acordo com a LPG-PC (Licen�a P�blica Geral para Programas de Computador), <BR>
 * vers�o 2.1.0 ou qualquer vers�o posterior. <BR>
 * A LPG-PC deve acompanhar todas PUBLICA��ES, DISTRIBUI��ES e REPRODU��ES deste Programa. <BR>
 * Caso uma c�pia da LPG-PC n�o esteja dispon�vel junto com este Programa, voc� pode contatar <BR>
 * o LICENCIADOR ou ent�o pegar uma c�pia em: <BR>
 * Licen�a: http://www.lpg.adv.br/licencas/lpgpc.rtf <BR>
 * Para poder USAR, PUBLICAR, DISTRIBUIR, REPRODUZIR ou ALTERAR este Programa � preciso estar <BR>
 * de acordo com os termos da LPG-PC <BR> <BR>
 *
 * Coment�rios sobre a classe...
 */

package org.freedom.modulos.std;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.freedom.acao.RadioGroupEvent;
import org.freedom.acao.RadioGroupListener;
import org.freedom.bmps.Icone;
import org.freedom.componentes.GuardaCampo;
import org.freedom.componentes.JLabelPad;
import org.freedom.componentes.JPanelPad;
import org.freedom.componentes.JRadioGroup;
import org.freedom.componentes.JTextFieldFK;
import org.freedom.componentes.JTextFieldPad;
import org.freedom.componentes.ListaCampos;
import org.freedom.componentes.Tabela;
import org.freedom.funcoes.Funcoes;
import org.freedom.telas.Aplicativo;
import org.freedom.telas.FDialogo;


public class FAdicOrc extends FDialogo implements ActionListener, RadioGroupListener {
	
	private static final long serialVersionUID = 1L;
	
	private Tabela tab = new Tabela();
	private JScrollPane spnTab = new JScrollPane(tab);
	private Tabela tabOrc = new Tabela();
	private JScrollPane spnTabOrc = new JScrollPane(tabOrc);
	private JPanelPad pinCab = new JPanelPad(0,100);
	private JPanelPad pnRod = new JPanelPad(JPanelPad.TP_JPANEL,new BorderLayout());
	private JPanelPad pnSubRod = new JPanelPad(JPanelPad.TP_JPANEL,new BorderLayout());
	private JPanelPad pinRod = new JPanelPad(480,55);
	private JPanelPad pinSair = new JPanelPad(120,45);
	private JPanelPad pinBtSel = new JPanelPad(40,110);
	private JPanelPad pinBtSelOrc = new JPanelPad(40,110);
	private JPanelPad pnCli = new JPanelPad(JPanelPad.TP_JPANEL,new BorderLayout());
	private JPanelPad pnTabOrc = new JPanelPad(JPanelPad.TP_JPANEL,new BorderLayout());
	private JPanelPad pnCliTab = new JPanelPad(JPanelPad.TP_JPANEL,new BorderLayout());
	private JTextFieldPad txtCodCli = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
	private JTextFieldFK txtNomeCli = new JTextFieldFK(JTextFieldPad.TP_STRING,50,0);
	private JTextFieldPad txtCodConv = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
	private JTextFieldFK txtNomeConv = new JTextFieldFK(JTextFieldPad.TP_STRING,50,0);
	private JTextFieldPad txtVlrProd = new JTextFieldPad(JTextFieldPad.TP_DECIMAL,15,2);
	private JTextFieldPad txtVlrDesc = new JTextFieldPad(JTextFieldPad.TP_DECIMAL,15,2);
	private JTextFieldPad txtVlrLiq = new JTextFieldPad(JTextFieldPad.TP_DECIMAL,15,2);
	private JRadioGroup rgBusca = null;
	private JButton btBusca = new JButton("Buscar",Icone.novo("btPesquisa.gif"));
	private JButton btExec = new JButton(Icone.novo("btExecuta.gif"));
	private JButton btTudoOrc = new JButton(Icone.novo("btTudo.gif"));
	private JButton btNadaOrc = new JButton(Icone.novo("btNada.gif"));
	private JButton btTudoIt = new JButton(Icone.novo("btTudo.gif"));
	private JButton btNadaIt = new JButton(Icone.novo("btNada.gif"));
	private JButton btGerar = new JButton(Icone.novo("btGerar.gif"));
	private JButton btSair = new JButton("Sair",Icone.novo("btSair.gif"));
	private ListaCampos lcCli = new ListaCampos(this,"CL");
	private ListaCampos lcConv = new ListaCampos(this,"CV");
	private Vector vValidos = new Vector();
	private String sTipoVenda = null;
	private org.freedom.modulos.std.FVenda vendaSTD = null;
	private org.freedom.modulos.pdv.FVenda vendaPDV = null;
	
	public FAdicOrc(Object vd,String tipo) {
		// Monta a tela
		//super(false);
		super();
		sTipoVenda = tipo;
		if(sTipoVenda.equals("V"))
			vendaSTD = (org.freedom.modulos.std.FVenda)vd;
		else if(sTipoVenda.equals("E"))
			vendaPDV = (org.freedom.modulos.pdv.FVenda)vd;
		
		setTitulo("Nova venda de or�amento");
		setAtribos(700,440);
		
		//Container c = getTela();
		c.setLayout(new BorderLayout());
		c.add(pnRod,BorderLayout.SOUTH);
		c.add(pnCli,BorderLayout.CENTER);
		c.add(pinCab,BorderLayout.NORTH);
		
		lcCli.add(new GuardaCampo( txtCodCli, "CodCli", "C�d.cli.", ListaCampos.DB_PK, null, false));
		lcCli.add(new GuardaCampo( txtNomeCli, "NomeCli", "Raz�o social do cliente", ListaCampos.DB_SI,false));
		txtCodCli.setTabelaExterna(lcCli);
		txtCodCli.setNomeCampo("CodCli");
		txtCodCli.setFK(true);
		lcCli.setReadOnly(true);
		lcCli.montaSql(false, "CLIENTE", "VD");
		    
		lcConv.add(new GuardaCampo( txtCodConv, "CodConv", "C�d.conv.", ListaCampos.DB_PK, null, false));
		lcConv.add(new GuardaCampo( txtNomeConv, "NomeConv", "Nome do conveniado", ListaCampos.DB_SI, null, false));
		txtCodConv.setTabelaExterna(lcConv);
		txtCodConv.setNomeCampo("CodConv");
		txtCodConv.setFK(true);
		lcConv.setReadOnly(true);
		lcConv.montaSql(false, "CONVENIADO", "AT");
		
		Vector vVals = new Vector();
		vVals.addElement("L");
		vVals.addElement("O");
		Vector vLabs = new Vector();
		vLabs.addElement("Cliente");
		vLabs.addElement("Conveniado");
		rgBusca = new JRadioGroup(2,1,vLabs,vVals);
		
		pinCab.adic(new JLabelPad("C�d.cli."),7,5,70,20);
		pinCab.adic(txtCodCli,7,25,70,20);
		pinCab.adic(new JLabelPad("Raz�o social do cliente"),80,5,200,20);
		pinCab.adic(txtNomeCli,80,25,200,20);
		pinCab.adic(new JLabelPad("C�d.conv."),7,45,70,20);
		pinCab.adic(txtCodConv,7,65,70,20);
		pinCab.adic(new JLabelPad("Nome do conveniado"),80,45,200,20);
		pinCab.adic(txtNomeConv,80,65,200,20);
		pinCab.adic(new JLabelPad("Buscar por:"),300,5,120,20);
		pinCab.adic(rgBusca,300,25,120,60);
		pinCab.adic(btBusca,480,35,150,40);
		
		pnRod.setPreferredSize(new Dimension(600,50));
		
		pnSubRod.setPreferredSize(new Dimension(600,50));
		pnRod.add(pnSubRod,BorderLayout.SOUTH);
		
		pinSair.tiraBorda();
		pinSair.adic(btSair,10,10,100,30);
		btSair.setPreferredSize(new Dimension(120,30));
		
		pnSubRod.add(pinSair,BorderLayout.EAST);
		pnSubRod.add(pinRod,BorderLayout.CENTER);
		
		pinRod.tiraBorda();
		pinRod.adic(new JLabelPad("Vlr.bruto"),7,0,100,20);
		pinRod.adic(txtVlrProd,7,20,100,20);
		pinRod.adic(new JLabelPad("Vlr.desc."),110,0,97,20);
		pinRod.adic(txtVlrDesc,110,20,97,20);
		pinRod.adic(new JLabelPad("Vlr.liq."),210,0,97,20);
		pinRod.adic(txtVlrLiq,210,20,97,20);
		
		pnTabOrc.setPreferredSize(new Dimension(600,130));
		
		pnTabOrc.add(spnTabOrc, BorderLayout.CENTER);
		pnTabOrc.add(pinBtSelOrc, BorderLayout.EAST);
		
		pinBtSelOrc.adic(btTudoOrc,5,5,30,30);
		pinBtSelOrc.adic(btNadaOrc,5,38,30,30);
		pinBtSelOrc.adic(btExec,5,71,30,30);
		
		pnCliTab.add(spnTab, BorderLayout.CENTER);
		pnCliTab.add(pinBtSel,BorderLayout.EAST);
		
		pinBtSel.adic(btTudoIt,5,5,30,30);
		pinBtSel.adic(btNadaIt,5,38,30,30);
		pinBtSel.adic(btGerar,5,71,30,30);
		
		pnCli.add(pnTabOrc, BorderLayout.NORTH);
		pnCli.add(pnCliTab, BorderLayout.CENTER);
		
		txtCodConv.setAtivo(false);
		txtVlrProd.setAtivo(false);
		txtVlrDesc.setAtivo(false);
		txtVlrLiq.setAtivo(false);
		
		//Seta os coment�rios    
		
		btExec.setToolTipText("Executar montagem");
		btTudoOrc.setToolTipText("Selecionar tudo");
		btNadaOrc.setToolTipText("Limpar sele��o");
		btGerar.setToolTipText("Gerar no banco");
		
		
		//Monta as tabelas
		
		tabOrc.adicColuna("S/N");
		tabOrc.adicColuna("C�d.orc.");
		tabOrc.adicColuna("C�d.cli.");
		tabOrc.adicColuna("Nome do conveniado");
		tabOrc.adicColuna("N� itens.");
		tabOrc.adicColuna("N� lib.");
		tabOrc.adicColuna("Valor total");
		tabOrc.adicColuna("Valor liberado");
		
		tabOrc.setTamColuna(30,0);
		tabOrc.setTamColuna(60,1);
		tabOrc.setTamColuna(60,2);
		tabOrc.setTamColuna(160,3);
		tabOrc.setTamColuna(60,4);
		tabOrc.setTamColuna(60,5);
		tabOrc.setTamColuna(100,6);
		tabOrc.setTamColuna(100,7);
		
		tabOrc.setColunaEditavel(0,true);
		
		tab.adicColuna("S/N");
		tab.adicColuna("�tem");
		tab.adicColuna("C�d.prod.");
		tab.adicColuna("Descri��o");
		tab.adicColuna("Qtd.");
		tab.adicColuna("Preco.");
		tab.adicColuna("Valor desc.");
		tab.adicColuna("Valor liq.");
		
		tab.setTamColuna(35,0);
		tab.setTamColuna(35,1);
		tab.setTamColuna(80,2);
		tab.setTamColuna(160,3);
		tab.setTamColuna(50,4);
		tab.setTamColuna(90,5);
		tab.setTamColuna(100,6);
		tab.setTamColuna(100,7);
		    
		tab.setColunaEditavel(0,true);
		    
		btSair.addActionListener(this);
		btBusca.addActionListener(this);
		btExec.addActionListener(this);
		btGerar.addActionListener(this);
		btTudoOrc.addActionListener(this);
		btNadaOrc.addActionListener(this);
		btTudoIt.addActionListener(this);
		btNadaIt.addActionListener(this);
		rgBusca.addRadioGroupListener(this);
		
	}
	
	private void carregar() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector vVals = null;
		String sSQL = null;
		float fValProd = 0;
		float fValDesc = 0;
		float fValLiq = 0;
		
		try {
			tab.limpa();
			vValidos.clear();
			
			for (int i=0; i<tabOrc.getNumLinhas();i++) {
		  		
				if (!((Boolean)tabOrc.getValor(i,0)).booleanValue())
					continue;
				
				sSQL = "SELECT IT.CODORC,IT.CODITORC,IT.CODPROD,P.DESCPROD," +
					   "IT.QTDITORC,IT.PRECOITORC,IT.VLRDESCITORC,IT.VLRLIQITORC," +
					   "IT.VLRPRODITORC FROM VDITORCAMENTO IT, EQPRODUTO P " +
					   "WHERE P.CODPROD=IT.CODPROD AND P.CODFILIAL=IT.CODFILIALPD " +
					   "AND P.CODEMP=IT.CODEMPPD AND IT.ACEITEITORC='S' AND IT.EMITITORC='N' " +
					   "AND IT.APROVITORC='S' AND IT.CODORC=? AND IT.CODFILIAL=? AND it.CODEMP=?";
				try {
					ps = con.prepareStatement(sSQL);
					ps.setInt(1,((Integer)tabOrc.getValor(i,1)).intValue());
					ps.setInt(2,ListaCampos.getMasterFilial("VDORCAMENTO"));
					ps.setInt(3,Aplicativo.iCodEmp);
					rs = ps.executeQuery();
					while(rs.next()) { 
						vVals = new Vector();
						vVals.addElement(new Boolean("true"));
						vVals.addElement(new Integer(rs.getInt("CodItOrc")));
						vVals.addElement(new Integer(rs.getInt("CodProd")));
						vVals.addElement(rs.getString("DescProd").trim());
						vVals.addElement(new Integer(rs.getInt("QtdItOrc")));
						vVals.addElement(Funcoes.strDecimalToStrCurrencyd(2,rs.getString("PrecoItOrc") != null ? rs.getString("PrecoItOrc") : "0"));
						vVals.addElement(Funcoes.strDecimalToStrCurrencyd(2,rs.getString("VlrDescItOrc") != null ? rs.getString("VlrDescItOrc") : "0"));
						vVals.addElement(Funcoes.strDecimalToStrCurrencyd(2,rs.getString("VlrLiqItOrc") != null ? rs.getString("VlrLiqItOrc") : "0"));
						fValProd += rs.getFloat("VlrProdItOrc");
						fValDesc += rs.getFloat("VlrDescItOrc");
						fValLiq += rs.getFloat("VlrLiqItOrc");
						
						vValidos.addElement(new int[] {
											rs.getInt("CodOrc"),
											rs.getInt("CodItOrc")
											});							
						tab.adicLinha(vVals);				
					}
					txtVlrProd.setVlrBigDecimal(new BigDecimal(fValProd));
					txtVlrDesc.setVlrBigDecimal(new BigDecimal(fValDesc));
					txtVlrLiq.setVlrBigDecimal(new BigDecimal(fValLiq));
				}
				catch(SQLException err) {
					Funcoes.mensagemErro(this,"Erro ao processar �tem '"+i+"'!\n"+err.getMessage(),true,con,err);
					err.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ps = null;
			rs = null;
			vVals = null;
			sSQL = null;			
		}
	}
	
	private boolean gerar() {
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String sSQL = null;
		boolean bPrim = true;
		int iCodVenda = 0;
		int[] iVals = null;
		JTextFieldPad txtNewCodVenda = null;
		FDialogo diag = null;
		
		try {
			
			boolean usaPedSeq = (getUsaPedSeq());
			diag = new FDialogo();
			txtNewCodVenda = new JTextFieldPad(JTextFieldPad.TP_INTEGER,8,0);
			
			diag.setTitulo("Confirma��o");
			if(usaPedSeq || sTipoVenda.equals("E")) {
				diag.setAtribos(235, 120);
				diag.adic(new JLabelPad("DEJEJA CRIAR UMA VENDA AGORA?"), 7, 17, 220, 20);
			}
			else {
				diag.setAtribos(235, 140);
				diag.adic(new JLabelPad("DEJEJA CRIAR UMA VENDA AGORA?"), 7, 15, 220, 20);
				diag.adic(new JLabelPad("N� Pedido"), 7, 40, 80, 20);
				diag.adic(txtNewCodVenda, 87, 40, 120, 20);
			}
			
			diag.setVisible(true);
			
			if (diag.OK) {
				if(!usaPedSeq && sTipoVenda.equals("V"))
					iCodVenda = txtNewCodVenda.getVlrInteger().intValue();
			}
			else
				return false;
			
			for (int i=0;i<vValidos.size();i++) {
				if (!((Boolean)tab.getValor(i,0)).booleanValue())
					continue;
				
				iVals = (int[])vValidos.elementAt(i);
				
				if (bPrim) {
					try {
						sSQL = "SELECT IRET FROM VDADICVENDAORCSP(?,?,?,?,?)";
						ps = con.prepareStatement(sSQL);
						ps.setInt(1,iVals[0]);
						ps.setInt(2,ListaCampos.getMasterFilial("VDORCAMENTO"));
						ps.setInt(3,Aplicativo.iCodEmp);
						ps.setString(4,sTipoVenda);
						ps.setInt(5,iCodVenda);
						rs = ps.executeQuery();
						if (rs.next()) {
							iCodVenda = rs.getInt(1);
						}
						rs.close();
						ps.close();
					} catch (SQLException err) {
						if(err.getErrorCode() == 335544665) {
							Funcoes.mensagemErro(this,"N�mero de pedido j� existe.\n" + 
									"Escolha outro numero.");
							return gerar();
						}
						else
							Funcoes.mensagemErro(this,"Erro ao gerar venda!\n"+err.getMessage(),true,con,err);
						
						err.printStackTrace();
						return false;
					}
					bPrim = false;
				}
				try {
					sSQL = "EXECUTE PROCEDURE VDADICITVENDAORCSP(?,?,?,?,?,?,?)";
					ps2 = con.prepareStatement(sSQL);
					ps2.setInt(1,Aplicativo.iCodFilial);
					ps2.setInt(2,iCodVenda);
					ps2.setInt(3,iVals[0]);
					ps2.setInt(4,iVals[1]);
					ps2.setInt(5,ListaCampos.getMasterFilial("VDORCAMENTO"));
					ps2.setInt(6,Aplicativo.iCodEmp);
					ps2.setString(7,sTipoVenda);
					ps2.execute();
					ps2.close();
				} catch (SQLException err) {
					Funcoes.mensagemErro(this,"Erro ao gerar itvenda: '"+(i+1)+"'!\n"+err.getMessage(),true,con,err);
					try {
						con.rollback();
					}
					catch(SQLException err1) { }
						return false;
				}
			}
			try {
				if (!con.getAutoCommit())
					con.commit();
				carregar();
			} catch(SQLException err) {
				Funcoes.mensagemErro(this,"Erro ao realizar commit!!"+"\n"+err.getMessage(),true,con,err);
				return false;
			}
			String opt[] = {"Sim","N�o"}; 
			if (JOptionPane.showOptionDialog(null, 
					"Venda '"+iCodVenda+"' gerada com sucesso!!!\n\n"+
					"Deseja edita-la?","Confirma��o", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null, opt, opt[0])==JOptionPane.YES_OPTION){
				if(sTipoVenda.equals("V"))
					vendaSTD.exec(iCodVenda);
				if(sTipoVenda.equals("E"))
					vendaPDV.exec(iCodVenda);
				btSair.doClick();			                             	
			
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ps = null;
			ps2 = null;
			rs = null;
			sSQL = null;
			iVals = null;
			txtNewCodVenda = null;
			diag = null;
		}
		
		return true;
	}
	
	private void buscar() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		String sWhere = null;
		Vector vVals = null;
		boolean bConv = false;
		int iCod = 0;
		try {
			if (rgBusca.getVlrString().equals("L")) {
				iCod = txtCodCli.getVlrInteger().intValue();
				if (iCod == 0) {
					Funcoes.mensagemInforma(this,"C�digo do cliente inv�lido!");
					txtCodCli.requestFocus();
					return;
				}
				sWhere = ", VDCLIENTE C WHERE C.CODCLI=? AND C.CODFILIAL=? AND C.CODEMP=?" +
						 " AND O.CODCLI=C.CODCLI AND O.CODFILIALCL=C.CODFILIAL AND O.CODEMPCL=C.CODEMP";
			}
			else if (rgBusca.getVlrString().equals("O")) {
				iCod = txtCodConv.getVlrInteger().intValue();
				if (iCod == 0) {
					Funcoes.mensagemInforma(this,"C�digo do conveniado inv�lido!");
					txtCodConv.requestFocus();
					return;
				}
				sWhere = ", ATCONVENIADO C WHERE C.CODCONV=? AND C.CODFILIAL=? AND C.CODEMP=?" +
						 " AND O.CODCONV=C.CODCONV AND O.CODFILIALCV=C.CODFILIAL AND O.CODEMPCV=C.CODEMP";
				bConv = true;
			}
			String sSQL = "SELECT O.CODORC,"+(bConv ? "O.CODCONV,C.NOMECONV," : "O.CODCLI,C.NOMECLI,")+
						  "(SELECT COUNT(IT.CODITORC) FROM VDITORCAMENTO IT WHERE IT.CODORC=O.CODORC " +
						  "AND IT.CODFILIAL=O.CODFILIAL AND IT.CODEMP=O.CODEMP),"+	
						  "(SELECT COUNT(IT.CODITORC) FROM VDITORCAMENTO IT WHERE IT.CODORC=O.CODORC " +
						  "AND IT.CODFILIAL=O.CODFILIAL AND IT.CODEMP=O.CODEMP " +
						  "AND IT.ACEITEITORC='S' AND IT.APROVITORC='S'),"+	
						  "(SELECT SUM(IT.VLRLIQITORC) FROM VDITORCAMENTO IT WHERE IT.CODORC=O.CODORC " +
						  "AND IT.CODFILIAL=O.CODFILIAL AND IT.CODEMP=O.CODEMP),"+	
						  "(SELECT SUM(IT.VLRLIQITORC) FROM VDITORCAMENTO IT WHERE IT.CODORC=O.CODORC " +
						  "AND IT.CODFILIAL=O.CODFILIAL AND IT.CODEMP=O.CODEMP " +
						  "AND IT.ACEITEITORC='S' AND IT.APROVITORC='S') " +
						  "FROM VDORCAMENTO O"+sWhere+" AND O.STATUSORC='OL'";
			try {
				ps = con.prepareStatement(sSQL);
				ps.setInt(1,iCod);	
				ps.setInt(2,ListaCampos.getMasterFilial(bConv ? "ATCONVENIADO" : "VDCLIENTE"));
				ps.setInt(3,Aplicativo.iCodEmp);
				rs = ps.executeQuery();
				tabOrc.limpa();	
				while (rs.next()) {
					vVals = new Vector();
					vVals.addElement(new Boolean(true));
					vVals.addElement(new Integer(rs.getInt("CodOrc")));
					vVals.addElement(new Integer(rs.getInt(2)));
					vVals.addElement(rs.getString(3).trim());
					vVals.addElement(new Integer(rs.getInt(4)));
					vVals.addElement(new Integer(rs.getInt(5)));
					vVals.addElement(Funcoes.strDecimalToStrCurrencyd(2,rs.getString(6) != null ? rs.getString(6) : "0"));
					vVals.addElement(Funcoes.strDecimalToStrCurrencyd(2,rs.getString(7) != null ? rs.getString(7) : "0"));
					tabOrc.adicLinha(vVals);
				}
				rs.close();
				ps.close();
			}
			catch(SQLException err) {
				Funcoes.mensagemErro(this,"Erro ao buscar or�amentos!\n"+err.getMessage(),true,con,err);
				err.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ps = null;
			rs = null;
			sWhere = null;
			vVals = null;			
		}
	}
	
	private boolean getUsaPedSeq() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sSQL = null;
		boolean ret = false;
		try {
			sSQL = "SELECT USAPEDSEQ FROM SGPREFERE1 WHERE CODEMP=? AND CODFILIAL=?";
			ps = con.prepareStatement(sSQL);
			ps.setInt(1,Aplicativo.iCodEmp);
			ps.setInt(2,ListaCampos.getMasterFilial("SGPREFERE1"));
			rs = ps.executeQuery();
			if (rs.next()) {
				if(rs.getString(1).equals("S"))
					ret = true;
			}
			rs.close();
			ps.close();
		} catch(SQLException err) {
			Funcoes.mensagemErro(this,"Erro ao buscar or�amentos!\n"+err.getMessage(),true,con,err);
			err.printStackTrace();
		} finally {
			ps = null;
			rs = null;
			sSQL = null;
		}
		return ret;
	}
	
	private void carregaTudo(Tabela tb) {
		for (int i=0; i<tb.getNumLinhas(); i++) {
			tb.setValor(new Boolean(true),i,0);
		}
	}
	
	private void carregaNada(Tabela tb) {
		for (int i=0; i<tb.getNumLinhas(); i++) {
			tb.setValor(new Boolean(false),i,0);
		}
	}
	
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btSair) {
			dispose();
		}
		else if (evt.getSource() == btBusca) {
			buscar();
		}
		else if (evt.getSource() == btExec) {
			carregar();
		}
		else if (evt.getSource() == btGerar) {
			if (!gerar()) {
				try {
					con.rollback();
				}
				catch(SQLException err) {
					Funcoes.mensagemErro(this,"Erro ao realizar rollback!!\n"+err.getMessage(),true,con,err);
				}
			}
		}
		else if (evt.getSource() == btTudoOrc) {
			carregaTudo(tabOrc);
		}
		else if (evt.getSource() == btNadaOrc) {
			carregaNada(tabOrc);
		}
		else if (evt.getSource() == btTudoIt) {
			carregaTudo(tab);
		}
		else if (evt.getSource() == btNadaIt) {
			carregaNada(tab);
		}
	}
	
	public void valorAlterado(RadioGroupEvent rgevt) {
		if (rgBusca.getVlrString().equals("O")) {
			txtCodConv.setAtivo(true);
			txtCodCli.setAtivo(false);
			lcCli.limpaCampos(true);
		}
		else if (rgBusca.getVlrString().equals("L")) {
			txtCodConv.setAtivo(false);
			txtCodCli.setAtivo(true);
			lcConv.limpaCampos(true);
		}
	}
	
	public void setConexao(Connection cn) {
		super.setConexao(cn);
		lcCli.setConexao(cn);
		lcConv.setConexao(cn);
	}
}
