package cn.zane.wechat.model.entity;

import javax.persistence.*;

/**
 * Created by zane on 2016/12/24.
 */
@Entity
@Table(name = "t_weixinuser", schema = "vrwechat", catalog = "")
public class TWeixinuserEntity {
    private String openId;
    private String nickname;
    private int sex;
    private String province;
    private String city;
    private String country;
    private String headimgur;
    private String privilege;
    private String unionid;
    private String loginDate;
    private int finish;

    @Id
    @Column(name = "openId", nullable = false, length = 100)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 100)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "sex", nullable = false)
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "province", nullable = false, length = 50)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "headimgur", nullable = false, length = 50)
    public String getHeadimgur() {
        return headimgur;
    }

    public void setHeadimgur(String headimgur) {
        this.headimgur = headimgur;
    }

    @Basic
    @Column(name = "privilege", nullable = false, length = 50)
    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Basic
    @Column(name = "unionid", nullable = false, length = 50)
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Basic
    @Column(name = "loginDate", nullable = false, length = 50)
    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    @Basic
    @Column(name = "finish", nullable = false)
    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TWeixinuserEntity that = (TWeixinuserEntity) o;

        if (sex != that.sex) return false;
        if (finish != that.finish) return false;
        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (headimgur != null ? !headimgur.equals(that.headimgur) : that.headimgur != null) return false;
        if (privilege != null ? !privilege.equals(that.privilege) : that.privilege != null) return false;
        if (unionid != null ? !unionid.equals(that.unionid) : that.unionid != null) return false;
        if (loginDate != null ? !loginDate.equals(that.loginDate) : that.loginDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openId != null ? openId.hashCode() : 0;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + sex;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (headimgur != null ? headimgur.hashCode() : 0);
        result = 31 * result + (privilege != null ? privilege.hashCode() : 0);
        result = 31 * result + (unionid != null ? unionid.hashCode() : 0);
        result = 31 * result + (loginDate != null ? loginDate.hashCode() : 0);
        result = 31 * result + finish;
        return result;
    }
}
