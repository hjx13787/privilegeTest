package privilegeTest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="task"
    ,schema="dbo"
    ,catalog="privilegetest"
)

public class Task  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Card card;
     private String ip;
     private String statustype;


    // Constructors

    /** default constructor */
    public Task() {
    }

	/** minimal constructor */
    public Task(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public Task(Long id, Card card, String ip, String statustype) {
        this.id = id;
        this.card = card;
        this.ip = ip;
        this.statustype = statustype;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="id", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="cid")

    public Card getCard() {
        return this.card;
    }
    
    public void setCard(Card card) {
        this.card = card;
    }
    
    @Column(name="ip", length=160)

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    @Column(name="statustype", length=160)

    public String getStatustype() {
        return this.statustype;
    }
    
    public void setStatustype(String statustype) {
        this.statustype = statustype;
    }
}