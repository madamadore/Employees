package employees.it.matteoavanzini.examples.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="titles")
public class Title {
	
	@EmbeddedId
    private TitlePK titlePK;
	
	@Column(name="to_date")
	private Date toDate;

	public TitlePK getTitlePK() {
		return titlePK;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setTitlePK(TitlePK titlePK) {
		this.titlePK = titlePK;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
}
