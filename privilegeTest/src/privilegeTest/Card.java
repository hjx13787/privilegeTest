package privilegeTest;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Card entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="card"
    ,schema="dbo"
    ,catalog="privilegetest"
)

public class Card  implements java.io.Serializable {


    // Fields    

     private Long cid;
     private String identifire;
     private String uploadno;
     private String deleteno;
     private String searchno;
     private Set<Task> tasks = new HashSet<Task>(0);


    // Constructors

    /** default constructor */
    public Card() {
    }

	/** minimal constructor */
    public Card(Long cid) {
        this.cid = cid;
    }
    
    /** full constructor */
    public Card(Long cid, String identifire, String uploadno, String deleteno, String searchno, Set<Task> tasks) {
        this.cid = cid;
        this.identifire = identifire;
        this.uploadno = uploadno;
        this.deleteno = deleteno;
        this.searchno = searchno;
        this.tasks = tasks;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="cid", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCid() {
        return this.cid;
    }
    
    public void setCid(Long cid) {
        this.cid = cid;
    }
    
    @Column(name="identifire", length=16)

    public String getIdentifire() {
        return this.identifire;
    }
    
    public void setIdentifire(String identifire) {
        this.identifire = identifire;
    }
    
    @Column(name="uploadno", length=160)

    public String getUploadno() {
        return this.uploadno;
    }
    
    public void setUploadno(String uploadno) {
        this.uploadno = uploadno;
    }
    
    @Column(name="deleteno", length=160)

    public String getDeleteno() {
        return this.deleteno;
    }
    
    public void setDeleteno(String deleteno) {
        this.deleteno = deleteno;
    }
    
    @Column(name="searchno", length=160)

    public String getSearchno() {
        return this.searchno;
    }
    
    public void setSearchno(String searchno) {
        this.searchno = searchno;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="card")

    public Set<Task> getTasks() {
        return this.tasks;
    }
    
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
   








}