package cn.zane.wechat.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zane on 2016/12/24.
 */
public class TUserEntityPK implements Serializable {
    private String openId;
    private int verifiedId;
    private int shootCert;

    @Column(name = "openId", nullable = false, length = 100)
    @Id
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Column(name = "verifiedId", nullable = false)
    @Id
    public int getVerifiedId() {
        return verifiedId;
    }

    public void setVerifiedId(int verifiedId) {
        this.verifiedId = verifiedId;
    }

    @Column(name = "shootCert", nullable = false)
    @Id
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

        TUserEntityPK that = (TUserEntityPK) o;

        if (verifiedId != that.verifiedId) return false;
        if (shootCert != that.shootCert) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openId != null ? openId.hashCode() : 0;
        result = 31 * result + verifiedId;
        result = 31 * result + shootCert;
        return result;
    }
}
