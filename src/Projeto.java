

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, unique=false)
	private int numero;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private int duracao;
	

	@Column(nullable=false, scale=2)
	private float orcamento;
	
	@Column(nullable=false)
	private Date inicio;
	
	private Date termino;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable=false)
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "projeto", 
			 cascade = CascadeType.ALL, 
			 orphanRemoval = true)
	private List<Etapa> etapas = new ArrayList<>();
	
	public Projeto(int numero, String nome, int duracao, float orcamento, Date inicio, Date termino) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.duracao = duracao;
		this.orcamento = orcamento;
		this.inicio = inicio;
		this.termino = termino;
	}

	public Projeto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public long getId(){
		return id;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numero;
		result = prime * result + Float.floatToIntBits(orcamento);
		result = prime * result + ((termino == null) ? 0 : termino.hashCode());
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
		Projeto other = (Projeto) obj;
		if (duracao != other.duracao)
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero != other.numero)
			return false;
		if (Float.floatToIntBits(orcamento) != Float.floatToIntBits(other.orcamento))
			return false;
		if (termino == null) {
			if (other.termino != null)
				return false;
		} else if (!termino.equals(other.termino))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [numero=" + numero + ", nome=" + nome + ", duracao=" + duracao + ", orcamento=" + orcamento
				+ ", inicio=" + inicio + ", termino=" + termino + "]";
	}
	
	
}
