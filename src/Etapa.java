import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Etapa {
	
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable=false)
	private Projeto projeto;

	@OneToMany(mappedBy = "etapa", 
			 cascade = CascadeType.ALL, 
			 orphanRemoval = true)
	private List<Atividade> atividades = new ArrayList<>();

	public Etapa(String nome, Date inicioPrevisto, Date terminoPrevisto, Projeto projeto) {
		super();
		this.nome = nome;
		this.inicioPrevisto = inicioPrevisto;
		this.terminoPrevisto = terminoPrevisto;
		this.projeto = projeto;
	}

	public Etapa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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
		Etapa other = (Etapa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Etapa [nome=" + nome + ", inicioPrevisto=" + inicioPrevisto + ", terminoPrevisto=" + terminoPrevisto
				+ ", inicioReal=" + inicioReal + ", terminoReal=" + terminoReal + ", projeto=" + projeto + "]";
	}
		
}
