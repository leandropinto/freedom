package org.freedom.persist.entity;

// Generated 18/02/2014 15:53:28 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Vdvendaentrega generated by hbm2java
 */
public class Vdvendaentrega implements java.io.Serializable {

	private VdvendaentregaId id;
	private Vdvenda vdvenda;
	private Date dtentrega;
	private String obsentrega;
	private String recebedor;
	private String entregador;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;

	public Vdvendaentrega() {
	}

	public Vdvendaentrega(Vdvenda vdvenda, Date dtentrega, Date dtins,
			Date hins, String idusuins) {
		this.vdvenda = vdvenda;
		this.dtentrega = dtentrega;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Vdvendaentrega(Vdvenda vdvenda, Date dtentrega, String obsentrega,
			String recebedor, String entregador, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt) {
		this.vdvenda = vdvenda;
		this.dtentrega = dtentrega;
		this.obsentrega = obsentrega;
		this.recebedor = recebedor;
		this.entregador = entregador;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
	}

	public VdvendaentregaId getId() {
		return this.id;
	}

	public void setId(VdvendaentregaId id) {
		this.id = id;
	}

	public Vdvenda getVdvenda() {
		return this.vdvenda;
	}

	public void setVdvenda(Vdvenda vdvenda) {
		this.vdvenda = vdvenda;
	}

	public Date getDtentrega() {
		return this.dtentrega;
	}

	public void setDtentrega(Date dtentrega) {
		this.dtentrega = dtentrega;
	}

	public String getObsentrega() {
		return this.obsentrega;
	}

	public void setObsentrega(String obsentrega) {
		this.obsentrega = obsentrega;
	}

	public String getRecebedor() {
		return this.recebedor;
	}

	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}

	public String getEntregador() {
		return this.entregador;
	}

	public void setEntregador(String entregador) {
		this.entregador = entregador;
	}

	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

}
