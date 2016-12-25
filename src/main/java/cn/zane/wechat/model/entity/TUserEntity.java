package cn.zane.wechat.model.entity;

import javax.persistence.*;

/**
 * Created by zane on 2016/12/24.
 */
@Entity
@Table(name = "t_user", schema = "vrwechat", catalog = "")
@IdClass(TUserEntityPK.class)
public class TUserEntity {
    private String openId;
    private String userSorted;
    private int verifiedId;
    private int shootCert;

    @Id
    @Column(name = "openId", nullable = false, length = 100)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "userSorted", nullable = false, length = 100)
    public String getUserSorted() {
        return userSorted;
    }

    public void setUserSorted(String userSorted) {
        this.userSorted = userSorted;
    }

    @Id
    @Column(name = "verifiedId", nullable = false)
    public int getVerifiedId() {
        return verifiedId;
    }

    public void setVerifiedId(int verifiedId) {
        this.verifiedId = verifiedId;
    }

    @Id
    @Column(name = "shootCert", nullable = false)
    public int getShootCert() {
        return shootCert;
    }

    public void setShootCert(int shootCert) {
        this.shootCert = shootCert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUserEntity that = (TUserEntity) o;

        if (verifiedId != that.verifiedId) return false;
        if (shootCert != that.shootCert) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (userSorted != null ? !userSorted.equals(that.userSorted) : that.userSorted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openId != null ? openId.hashCode() : 0;
        result = 31 * result + (userSorted != null ? userSorted.hashCode() : 0);
        result = 31 * result + verifiedId;
        result = 31 * result + shootCert;
        return result;
    }
}
