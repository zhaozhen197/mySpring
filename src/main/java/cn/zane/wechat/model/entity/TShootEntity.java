package cn.zane.wechat.model.entity;

import javax.persistence.*;

/**
 * Created by zane on 2016/12/24.
 */
@Entity
@Table(name = "t_shoot", schema = "vrwechat", catalog = "")
public class TShootEntity {
    private String openId;
    private String teamName;
    private String shootEqu;
    private String imageExampleUrl;
    private String videoExampleUrl;

    @Id
    @Column(name = "openId", nullable = false, length = 100)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "teamName", nullable = true, length = 100)
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Basic
    @Column(name = "shootEqu", nullable = true, length = 100)
    public String getShootEqu() {
        return shootEqu;
    }

    public void setShootEqu(String shootEqu) {
        this.shootEqu = shootEqu;
    }

    @Basic
    @Column(name = "imageExampleUrl", nullable = true, length = 100)
    public String getImageExampleUrl() {
        return imageExampleUrl;
    }

    public void setImageExampleUrl(String imageExampleUrl) {
        this.imageExampleUrl = imageExampleUrl;
    }

    @Basic
    @Column(name = "videoExampleUrl", nullable = true, length = 100)
    public String getVideoExampleUrl() {
        return videoExampleUrl;
    }

    public void setVideoExampleUrl(String videoExampleUrl) {
        this.videoExampleUrl = videoExampleUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TShootEntity that = (TShootEntity) o;

        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (teamName != null ? !teamName.equals(that.teamName) : that.teamName != null) return false;
        if (shootEqu != null ? !shootEqu.equals(that.shootEqu) : that.shootEqu != null) return false;
        if (imageExampleUrl != null ? !imageExampleUrl.equals(that.imageExampleUrl) : that.imageExampleUrl != null)
            return false;
        if (videoExampleUrl != null ? !videoExampleUrl.equals(that.videoExampleUrl) : that.videoExampleUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openId != null ? openId.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (shootEqu != null ? shootEqu.hashCode() : 0);
        result = 31 * result + (imageExampleUrl != null ? imageExampleUrl.hashCode() : 0);
        result = 31 * result + (videoExampleUrl != null ? videoExampleUrl.hashCode() : 0);
        return result;
    }
}
