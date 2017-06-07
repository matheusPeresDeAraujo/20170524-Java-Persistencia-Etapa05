import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Atividade {
	
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable=false, length = 100)
	private String nome;
	
	@Column(nullable=false)
	private Date inicioPrevisto;
	
	@Column(nullable=false)
	private Date terminoPrevisto;
	
	private Date inicioReal;
	
	private Date terminoReal;
	
	private int duracao;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "etapa_id", nullable=false)
	private Etapa etapa;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Pessoa> pessoas = new ArrayList<>();

	public Atividade(String nome, Date inicioPrevisto, Date terminoPrevisto, int duracao) {
		super();
		this.nome = nome;
		this.inicioPrevisto = inicioPrevisto;
		this.terminoPrevisto = terminoPrevisto;
		this.duracao = duracao;
	}

	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public long getId(){
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicioPrevisto() {
		return inicioPrevisto;
	}

	public void setInicioPrevisto(Date inicioPrevisto) {
		this.inicioPrevisto = inicioPrevisto;
	}

	public Date getTerminoPrevisto() {
		return terminoPrevisto;
	}

	public void setTerminoPrevisto(Date terminoPrevisto) {
		this.terminoPrevisto = terminoPrevisto;
	}

	public Date getInicioReal() {
		return inicioReal;
	}

	public void setInicioReal(Date inicioReal) {
		this.inicioReal = inicioReal;
	}

	public Date getTerminoReal() {
		return terminoReal;
	}

	public void setTerminoReal(Date terminoReal) {
		this.terminoReal = terminoReal;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atividade [nome=" + nome + ", inicioPrevisto=" + inicioPrevisto + ", terminoPrevisto=" + terminoPrevisto
				+ ", inicioReal=" + inicioReal + ", terminoReal=" + terminoReal + ", duracao=" + duracao + "]";
	}
	
}
