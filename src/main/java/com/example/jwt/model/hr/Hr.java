package com.example.jwt.model.hr;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hr")
public class Hr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="purchasing_doc_no")

    private String purchasingDocNo;

    @Column(name="action_type")
    private String actionType;

    @Column(name="file_name")
    private String fileName;

    @Column(name="file_path")
    private String filePath;

    @Column(name="remarks")
    private String remarks;

    @Column(name="status")
    private String status;

    @Column(name="updated_by")
    private String updatedby;

    @Column(name="created_at")
    private long createdAt;

    @Column(name="created_by_id")
    private String createdById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchasingDocNo() {
        return purchasingDocNo;
    }

    public void setPurchasingDocNo(String purchasingDocNo) {
        this.purchasingDocNo = purchasingDocNo;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }
}
