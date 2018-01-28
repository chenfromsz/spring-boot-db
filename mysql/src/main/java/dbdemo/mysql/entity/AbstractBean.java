package dbdemo.mysql.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * The abstract bean
 *
 * @author <a href="https://github.com/XieEDeHeiShou">XieEDeHeiShou</a>;
 * @since 2018/1/28
 */
//Add AuditingEntityListener to EntityListeners to enabled jpa auditing function
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public abstract class AbstractBean implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(timezone = "GMT+8")
    @CreatedDate
    private Date createDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(timezone = "GMT+8")
    @LastModifiedDate
    private Date laseModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLaseModifiedDate() {
        return laseModifiedDate;
    }

    public void setLaseModifiedDate(Date laseModifiedDate) {
        this.laseModifiedDate = laseModifiedDate;
    }
}
