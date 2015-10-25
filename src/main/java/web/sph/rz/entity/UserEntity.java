package web.sph.rz.entity;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserEntity {

	@Id
	@Column(name = "USR_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@SequenceGenerator(name = "user_sequence", sequenceName = "SEQ_USER", allocationSize = 1)
	private long id;

	@Column(name = "USR_USR_ID")
	private String userId;

	@Column(name = "USR_START_DATE")
	private Date startDate;

	@Column(name = "USR_END_DATE")
	private Date endDate;

	@Column(name = "USR_PASSWORD")
	private String password;

	public UserEntity() {
	}

	public UserEntity(String userId, Date startDate, Date endDate,
			String password) {
		this.userId = userId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserEntity [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		try {
			final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			int value = random.nextInt();
			int unValue = Math.abs(value);

			return unValue;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof UserEntity)) {
			return false;
		}

		UserEntity usr = (UserEntity) obj;

		if (this.getUserId().compareToIgnoreCase(usr.getUserId()) == 0) {
			return true;
		} else {
			return false;
		}
	}

}
