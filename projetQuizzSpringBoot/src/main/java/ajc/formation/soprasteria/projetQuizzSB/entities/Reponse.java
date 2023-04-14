package ajc.formation.soprasteria.projetQuizzSB.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.soprasteria.projetQuizzSB.entities.jsonviews.JsonViews;

@Entity
@Table(name = "reponse")
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reponse_id")
    @JsonView(JsonViews.Reponse.class)
    private Long id;
    @Column(name = "reponse_enonce")
    @JsonView(JsonViews.Simple.class)
    private String enonceReponse;
    @Column(name = "bonne_reponse")
    @JsonView(JsonViews.Reponse.class)
    private boolean bonneReponse;
    @ManyToOne
    @JoinColumn(name = "reponse_id_question", foreignKey =  @ForeignKey(name = "reponse_id_question_fk"))
    @JsonView(JsonViews.ReponsesWithQuestion.class)
    private Question question;

    
    public Reponse() {
    }

    public Reponse(String enonceReponse, boolean bonneReponse) {
        this.enonceReponse = enonceReponse;
        this.bonneReponse = bonneReponse;
    }

    public Reponse(String enonceReponse, boolean bonneReponse, Question question) {
        this.enonceReponse = enonceReponse;
        this.bonneReponse = bonneReponse;
        this.question = question;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEnonceReponse() {
        return enonceReponse;
    }
    
    public void setEnonceReponse(String enonceReponse) {
        this.enonceReponse = enonceReponse;
    }
    
    public boolean isBonneReponse() {
        return bonneReponse;
    }
    
    public void setBonneReponse(boolean bonneReponse) {
        this.bonneReponse = bonneReponse;
    }
    
    public Question getQuestion() {
        return question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Reponse other = (Reponse) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    

    
}
