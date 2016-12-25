package cn.zane.wechat.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zane on 2016/12/24.
 */
public class TMissionEntityPK implements Serializable {
    private int missionId;
    private String userNeedOpenId;
    private String userReceiveOpenId;

    @Column(name = "missionId", nullable = false)
    @Id
    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    @Column(name = "userNeedOpenId", nullable = false, length = 100)
    @Id
    public String getUserNeedOpenId() {
        return userNeedOpenId;
    }

    public void setUserNeedOpenId(String userNeedOpenId) {
        this.userNeedOpenId = userNeedOpenId;
    }

    @Column(name = "userReceiveOpenId", nullable = false, length = 100)
    @Id
    public String getUserReceiveOpenId() {
        return userReceiveOpenId;
    }

    public void setUserReceiveOpenId(String userReceiveOpenId) {
        this.userReceiveOpenId = userReceiveOpenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMissionEntityPK that = (TMissionEntityPK) o;

        if (missionId != that.missionId) return false;
        if (userNeedOpenId != null ? !userNeedOpenId.equals(that.userNeedOpenId) : that.userNeedOpenId != null)
            return false;
        if (userReceiveOpenId != null ? !userReceiveOpenId.equals(that.userReceiveOpenId) : that.userReceiveOpenId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = missionId;
        result = 31 * result + (userNeedOpenId != null ? userNeedOpenId.hashCode() : 0);
        result = 31 * result + (userReceiveOpenId != null ? userReceiveOpenId.hashCode() : 0);
        return result;
    }
}
