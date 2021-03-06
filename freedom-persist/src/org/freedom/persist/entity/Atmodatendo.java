package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Atmodatendo generated by hbm2java
 */
@Entity
@Table(name = "ATMODATENDO")
public class Atmodatendo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AtmodatendoId id;
	private Sgfilial sgfilial;
	private Attipoatendo attipoatendo;
	private Atsetor atsetor;
	private Vdcliente vdcliente;
	private Atespecatend atespecatend;
	private Crchamado crchamado;
	private Vditcontrato vditcontrato;
	private Atclasatendo atclasatendo;
	private Atconveniado atconveniado;
	private String descmodel;
	private String obsatendo;
	private String obsinterno;
	private String statusatendo;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set sgprefere3sForSgprefere3atmodmc = new HashSet(0);
	private Set sgprefere3sForSgprefere3atmodme = new HashSet(0);
	private Set sgprefere3sForSgprefere3atmodor = new HashSet(0);
	private Set sgprefere3sForSgprefere3atmodfi = new HashSet(0);
	private Set sgprefere3sForSgprefere3atmodfj = new HashSet(0);
	private Set sgprefere3sForSgprefere3atmodmi = new HashSet(0);
	private Set sgprefere3sForSgprefere3atmodap = new HashSet(0);

	public Atmodatendo() {
	}

	public Atmodatendo(AtmodatendoId id, Sgfilial sgfilial, String descmodel,
			Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.descmodel = descmodel;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Atmodatendo(AtmodatendoId id, Sgfilial sgfilial,
			Attipoatendo attipoatendo, Atsetor atsetor, Vdcliente vdcliente,
			Atespecatend atespecatend, Crchamado crchamado,
			Vditcontrato vditcontrato, Atclasatendo atclasatendo,
			Atconveniado atconveniado, String descmodel, String obsatendo,
			String obsinterno, String statusatendo, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt,
			Set sgprefere3sForSgprefere3atmodmc,
			Set sgprefere3sForSgprefere3atmodme,
			Set sgprefere3sForSgprefere3atmodor,
			Set sgprefere3sForSgprefere3atmodfi,
			Set sgprefere3sForSgprefere3atmodfj,
			Set sgprefere3sForSgprefere3atmodmi,
			Set sgprefere3sForSgprefere3atmodap) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.attipoatendo = attipoatendo;
		this.atsetor = atsetor;
		this.vdcliente = vdcliente;
		this.atespecatend = atespecatend;
		this.crchamado = crchamado;
		this.vditcontrato = vditcontrato;
		this.atclasatendo = atclasatendo;
		this.atconveniado = atconveniado;
		this.descmodel = descmodel;
		this.obsatendo = obsatendo;
		this.obsinterno = obsinterno;
		this.statusatendo = statusatendo;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.sgprefere3sForSgprefere3atmodmc = sgprefere3sForSgprefere3atmodmc;
		this.sgprefere3sForSgprefere3atmodme = sgprefere3sForSgprefere3atmodme;
		this.sgprefere3sForSgprefere3atmodor = sgprefere3sForSgprefere3atmodor;
		this.sgprefere3sForSgprefere3atmodfi = sgprefere3sForSgprefere3atmodfi;
		this.sgprefere3sForSgprefere3atmodfj = sgprefere3sForSgprefere3atmodfj;
		this.sgprefere3sForSgprefere3atmodmi = sgprefere3sForSgprefere3atmodmi;
		this.sgprefere3sForSgprefere3atmodap = sgprefere3sForSgprefere3atmodap;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codmodel", column = @Column(name = "CODMODEL", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public AtmodatendoId getId() {
		return this.id;
	}

	public void setId(AtmodatendoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Sgfilial getSgfilial() {
		return this.sgfilial;
	}

	public void setSgfilial(Sgfilial sgfilial) {
		this.sgfilial = sgfilial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODTPATENDO", referencedColumnName = "CODTPATENDO"),
			@JoinColumn(name = "CODFILIALTO", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPTO", referencedColumnName = "CODEMP") })
	public Attipoatendo getAttipoatendo() {
		return this.attipoatendo;
	}

	public void setAttipoatendo(Attipoatendo attipoatendo) {
		this.attipoatendo = attipoatendo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODSETAT", referencedColumnName = "CODSETAT"),
			@JoinColumn(name = "CODFILIALSA", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPSA", referencedColumnName = "CODEMP") })
	public Atsetor getAtsetor() {
		return this.atsetor;
	}

	public void setAtsetor(Atsetor atsetor) {
		this.atsetor = atsetor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI"),
			@JoinColumn(name = "CODFILIALCL", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPCL", referencedColumnName = "CODEMP") })
	public Vdcliente getVdcliente() {
		return this.vdcliente;
	}

	public void setVdcliente(Vdcliente vdcliente) {
		this.vdcliente = vdcliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODESPEC", referencedColumnName = "CODESPEC"),
			@JoinColumn(name = "CODFILIALEA", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPEA", referencedColumnName = "CODEMP") })
	public Atespecatend getAtespecatend() {
		return this.atespecatend;
	}

	public void setAtespecatend(Atespecatend atespecatend) {
		this.atespecatend = atespecatend;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCHAMADO", referencedColumnName = "CODCHAMADO"),
			@JoinColumn(name = "CODFILIALCH", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPCH", referencedColumnName = "CODEMP") })
	public Crchamado getCrchamado() {
		return this.crchamado;
	}

	public void setCrchamado(Crchamado crchamado) {
		this.crchamado = crchamado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCONTR", referencedColumnName = "CODCONTR"),
			@JoinColumn(name = "CODITCONTR", referencedColumnName = "CODITCONTR"),
			@JoinColumn(name = "CODFILIALCT", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPCT", referencedColumnName = "CODEMP") })
	public Vditcontrato getVditcontrato() {
		return this.vditcontrato;
	}

	public void setVditcontrato(Vditcontrato vditcontrato) {
		this.vditcontrato = vditcontrato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCLASATENDO", referencedColumnName = "CODCLASATENDO"),
			@JoinColumn(name = "CODFILIALCA", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPCA", referencedColumnName = "CODEMP") })
	public Atclasatendo getAtclasatendo() {
		return this.atclasatendo;
	}

	public void setAtclasatendo(Atclasatendo atclasatendo) {
		this.atclasatendo = atclasatendo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCONV", referencedColumnName = "CODCONV"),
			@JoinColumn(name = "CODFILIALCV", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPCV", referencedColumnName = "CODEMP") })
	public Atconveniado getAtconveniado() {
		return this.atconveniado;
	}

	public void setAtconveniado(Atconveniado atconveniado) {
		this.atconveniado = atconveniado;
	}

	@Column(name = "DESCMODEL", nullable = false, length = 100)
	public String getDescmodel() {
		return this.descmodel;
	}

	public void setDescmodel(String descmodel) {
		this.descmodel = descmodel;
	}

	@Column(name = "OBSATENDO", length = 10000)
	public String getObsatendo() {
		return this.obsatendo;
	}

	public void setObsatendo(String obsatendo) {
		this.obsatendo = obsatendo;
	}

	@Column(name = "OBSINTERNO", length = 10000)
	public String getObsinterno() {
		return this.obsinterno;
	}

	public void setObsinterno(String obsinterno) {
		this.obsinterno = obsinterno;
	}

	@Column(name = "STATUSATENDO", length = 2)
	public String getStatusatendo() {
		return this.statusatendo;
	}

	public void setStatusatendo(String statusatendo) {
		this.statusatendo = statusatendo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINS", nullable = false, length = 10)
	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HINS", nullable = false, length = 8)
	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	@Column(name = "IDUSUINS", nullable = false, length = 8)
	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTALT", length = 10)
	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HALT", length = 8)
	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "atmodatendoBySgprefere3atmodmc")
	public Set getSgprefere3sForSgprefere3atmodmc() {
		return this.sgprefere3sForSgprefere3atmodmc;
	}

	public void setSgprefere3sForSgprefere3atmodmc(
			Set sgprefere3sForSgprefere3atmodmc) {
		this.sgprefere3sForSgprefere3atmodmc = sgprefere3sForSgprefere3atmodmc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atmodatendoBySgprefere3atmodme")
	public Set getSgprefere3sForSgprefere3atmodme() {
		return this.sgprefere3sForSgprefere3atmodme;
	}

	public void setSgprefere3sForSgprefere3atmodme(
			Set sgprefere3sForSgprefere3atmodme) {
		this.sgprefere3sForSgprefere3atmodme = sgprefere3sForSgprefere3atmodme;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atmodatendoBySgprefere3atmodor")
	public Set getSgprefere3sForSgprefere3atmodor() {
		return this.sgprefere3sForSgprefere3atmodor;
	}

	public void setSgprefere3sForSgprefere3atmodor(
			Set sgprefere3sForSgprefere3atmodor) {
		this.sgprefere3sForSgprefere3atmodor = sgprefere3sForSgprefere3atmodor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atmodatendoBySgprefere3atmodfi")
	public Set getSgprefere3sForSgprefere3atmodfi() {
		return this.sgprefere3sForSgprefere3atmodfi;
	}

	public void setSgprefere3sForSgprefere3atmodfi(
			Set sgprefere3sForSgprefere3atmodfi) {
		this.sgprefere3sForSgprefere3atmodfi = sgprefere3sForSgprefere3atmodfi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atmodatendoBySgprefere3atmodfj")
	public Set getSgprefere3sForSgprefere3atmodfj() {
		return this.sgprefere3sForSgprefere3atmodfj;
	}

	public void setSgprefere3sForSgprefere3atmodfj(
			Set sgprefere3sForSgprefere3atmodfj) {
		this.sgprefere3sForSgprefere3atmodfj = sgprefere3sForSgprefere3atmodfj;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atmodatendoBySgprefere3atmodmi")
	public Set getSgprefere3sForSgprefere3atmodmi() {
		return this.sgprefere3sForSgprefere3atmodmi;
	}

	public void setSgprefere3sForSgprefere3atmodmi(
			Set sgprefere3sForSgprefere3atmodmi) {
		this.sgprefere3sForSgprefere3atmodmi = sgprefere3sForSgprefere3atmodmi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "atmodatendoBySgprefere3atmodap")
	public Set getSgprefere3sForSgprefere3atmodap() {
		return this.sgprefere3sForSgprefere3atmodap;
	}

	public void setSgprefere3sForSgprefere3atmodap(
			Set sgprefere3sForSgprefere3atmodap) {
		this.sgprefere3sForSgprefere3atmodap = sgprefere3sForSgprefere3atmodap;
	}
*/
}
