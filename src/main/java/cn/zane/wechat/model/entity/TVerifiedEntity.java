package cn.zane.wechat.model.entity;

import javax.persistence.*;

/**
 * Created by zane on 2016/12/24.
 */
@Entity
@Table(name = "t_verified", schema = "vrwechat", catalog = "")
public class TVerifiedEntity {
    private int verifiedId;
    private int character;
    private String name;
    private String idNumber;
    private String checkProvince;
    private String checkCity;
    private String checkCounty;
    private String checkDetial;
    private int imageId;
    private String checkInfo;
    private int checkStatus;

    @Id
    @Column(name = "verifiedId", nullable = false)
    public int getVerifiedId() {
        return verifiedId;
    }

    public void setVerifiedId(int verifiedId) {
        this.verifiedId = verifiedId;
    }

    @Basic
    @Column(name = "character", nullable = false)
    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "idNumber", nullable = false, length = 50)
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "checkProvince", nullable = false, length = 50)
    public String getCheckProvince() {
        return checkProvince;
    }

    public void setCheckProvince(String checkProvince) {
        this.checkProvince = checkProvince;
    }

    @Basic
    @Column(name = "checkCity", nullable = false, length = 50)
    public String getCheckCity() {
        return checkCity;
    }

    public void setCheckCity(String checkCity) {
        this.checkCity = checkCity;
    }

    @Basic
    @Column(name = "checkCounty", nullable = false, length = 50)
    public String getCheckCounty() {
        return checkCounty;
    }

    public void setCheckCounty(String checkCounty) {
        this.checkCounty = checkCounty;
    }

    @Basic
    @Column(name = "checkDetial", nullable = false, length = 50)
    public String getCheckDetial() {
        return checkDetial;
    }

    public void setCheckDetial(String checkDetial) {
        this.checkDetial = checkDetial;
    }

    @Basic
    @Column(name = "imageID", nullable = false)
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "checkInfo", nullable = false, length = 100)
    public String getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(String checkInfo) {
        this.checkInfo = checkInfo;
    }

    @Basic
    @Column(name = "checkStatus", nullable = false)
    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TVerifiedEntity that = (TVerifiedEntity) o;

        if (verifiedId != that.verifiedId) return false;
        if (character != that.character) return false;
        if (imageId != that.imageId) return false;
        if (checkStatus != that.checkStatus) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (idNumber != null ? !idNumber.equals(that.idNumber) : that.idNumber != null) return false;
        if (checkProvince != null ? !checkProvince.equals(that.checkProvince) : that.checkProvince != null)
            return false;
        if (checkCity != null ? !checkCity.equals(that.checkCity) : that.checkCity != null) return false;
        if (checkCounty != null ? !checkCounty.equals(that.checkCounty) : that.checkCounty != null) return false;
        if (checkDetial != null ? !checkDetial.equals(that.checkDetial) : that.checkDetial != null) return false;
        if (checkInfo != null ? !checkInfo.equals(that.checkInfo) : that.checkInfo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = verifiedId;
        result = 31 * result + character;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        result = 31 * result + (checkProvince != null ? checkProvince.hashCode() : 0);
        result = 31 * result + (checkCity != null ? checkCity.hashCode() : 0);
        result = 31 * result + (checkCounty != null ? checkCounty.hashCode() : 0);
        result = 31 * result + (checkDetial != null ? checkDetial.hashCode() : 0);
        result = 31 * result + imageId;
        result = 31 * result + (checkInfo != null ? checkInfo.hashCode() : 0);
        result = 31 * result + checkStatus;
        return result;
    }
}
