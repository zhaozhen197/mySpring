package cn.zane.wechat.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zane on 2016/12/24.
 */
@Entity
@Table(name = "t_mission", schema = "vrwechat", catalog = "")
@IdClass(TMissionEntityPK.class)
public class TMissionEntity {
    private int missionId;
    private String userNeedOpenId;
    private String userReceiveOpenId;
    private int missionSorted;
    private String missionPlace;
    private Date publishDate;
    private Date missionDeadline;
    private String missionInfo;
    private int missionStatus;
    private String workUrl;
    private int aggreeStar;
    private int overDate;

    @Id
    @Column(name = "missionId", nullable = false)
    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    @Id
    @Column(name = "userNeedOpenId", nullable = false, length = 100)
    public String getUserNeedOpenId() {
        return userNeedOpenId;
    }

    public void setUserNeedOpenId(String userNeedOpenId) {
        this.userNeedOpenId = userNeedOpenId;
    }

    @Id
    @Column(name = "userReceiveOpenId", nullable = false, length = 100)
    public String getUserReceiveOpenId() {
        return userReceiveOpenId;
    }

    public void setUserReceiveOpenId(String userReceiveOpenId) {
        this.userReceiveOpenId = userReceiveOpenId;
    }

    @Basic
    @Column(name = "missionSorted", nullable = false)
    public int getMissionSorted() {
        return missionSorted;
    }

    public void setMissionSorted(int missionSorted) {
        this.missionSorted = missionSorted;
    }

    @Basic
    @Column(name = "missionPlace", nullable = false, length = 50)
    public String getMissionPlace() {
        return missionPlace;
    }

    public void setMissionPlace(String missionPlace) {
        this.missionPlace = missionPlace;
    }

    @Basic
    @Column(name = "publishDate", nullable = false)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "missionDeadline", nullable = false)
    public Date getMissionDeadline() {
        return missionDeadline;
    }

    public void setMissionDeadline(Date missionDeadline) {
        this.missionDeadline = missionDeadline;
    }

    @Basic
    @Column(name = "missionInfo", nullable = false, length = 100)
    public String getMissionInfo() {
        return missionInfo;
    }

    public void setMissionInfo(String missionInfo) {
        this.missionInfo = missionInfo;
    }

    @Basic
    @Column(name = "missionStatus", nullable = false)
    public int getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(int missionStatus) {
        this.missionStatus = missionStatus;
    }

    @Basic
    @Column(name = "workUrl", nullable = false, length = 100)
    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl;
    }

    @Basic
    @Column(name = "aggreeStar", nullable = false)
    public int getAggreeStar() {
        return aggreeStar;
    }

    public void setAggreeStar(int aggreeStar) {
        this.aggreeStar = aggreeStar;
    }

    @Basic
    @Column(name = "overDate", nullable = false)
    public int getOverDate() {
        return overDate;
    }

    public void setOverDate(int overDate) {
        this.overDate = overDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TMissionEntity that = (TMissionEntity) o;

        if (missionId != that.missionId) return false;
        if (missionSorted != that.missionSorted) return false;
        if (missionStatus != that.missionStatus) return false;
        if (aggreeStar != that.aggreeStar) return false;
        if (overDate != that.overDate) return false;
        if (userNeedOpenId != null ? !userNeedOpenId.equals(that.userNeedOpenId) : that.userNeedOpenId != null)
            return false;
        if (userReceiveOpenId != null ? !userReceiveOpenId.equals(that.userReceiveOpenId) : that.userReceiveOpenId != null)
            return false;
        if (missionPlace != null ? !missionPlace.equals(that.missionPlace) : that.missionPlace != null) return false;
        if (publishDate != null ? !publishDate.equals(that.publishDate) : that.publishDate != null) return false;
        if (missionDeadline != null ? !missionDeadline.equals(that.missionDeadline) : that.missionDeadline != null)
            return false;
        if (missionInfo != null ? !missionInfo.equals(that.missionInfo) : that.missionInfo != null) return false;
        if (workUrl != null ? !workUrl.equals(that.workUrl) : that.workUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = missionId;
        result = 31 * result + (userNeedOpenId != null ? userNeedOpenId.hashCode() : 0);
        result = 31 * result + (userReceiveOpenId != null ? userReceiveOpenId.hashCode() : 0);
        result = 31 * result + missionSorted;
        result = 31 * result + (missionPlace != null ? missionPlace.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (missionDeadline != null ? missionDeadline.hashCode() : 0);
        result = 31 * result + (missionInfo != null ? missionInfo.hashCode() : 0);
        result = 31 * result + missionStatus;
        result = 31 * result + (workUrl != null ? workUrl.hashCode() : 0);
        result = 31 * result + aggreeStar;
        result = 31 * result + overDate;
        return result;
    }
}
