package cn.zane.wechat.model.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by zane on 2016/12/24.
 */
@Entity
@Table(name = "t_userimage", schema = "vrwechat", catalog = "")
public class TUserimageEntity {
    private int imageId;
    private String imageUrl;
    private double imageSize;
    private Date imageDate;

    @Id
    @Column(name = "imageId", nullable = false)
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "imageUrl", nullable = false, length = 50)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "imageSize", nullable = false, precision = 0)
    public double getImageSize() {
        return imageSize;
    }

    public void setImageSize(double imageSize) {
        this.imageSize = imageSize;
    }

    @Basic
    @Column(name = "imageDate", nullable = false)
    public Date getImageDate() {
        return imageDate;
    }

    public void setImageDate(Date imageDate) {
        this.imageDate = imageDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TUserimageEntity that = (TUserimageEntity) o;

        if (imageId != that.imageId) return false;
        if (Double.compare(that.imageSize, imageSize) != 0) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (imageDate != null ? !imageDate.equals(that.imageDate) : that.imageDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = imageId;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        temp = Double.doubleToLongBits(imageSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (imageDate != null ? imageDate.hashCode() : 0);
        return result;
    }
}
