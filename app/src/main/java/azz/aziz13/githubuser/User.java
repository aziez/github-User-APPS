package azz.aziz13.githubuser;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int avatar;
    private String username,perusahaan,lokasi,repositori,follower,followeing;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getRepositori() {
        return repositori;
    }

    public void setRepositori(String repositori) {
        this.repositori = repositori;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFolloweing() {
        return followeing;
    }

    public void setFolloweing(String followeing) {
        this.followeing = followeing;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avatar);
        dest.writeString(username);
        dest.writeString(perusahaan);
        dest.writeString(lokasi);
        dest.writeString(repositori);
        dest.writeString(follower);
        dest.writeString(followeing);
    }

    public User() {

    }

    protected User(Parcel in) {
        this.avatar = in.readInt();
        this.username = in.readString();
        this.perusahaan = in.readString();
        this.lokasi = in.readString();
        this.repositori = in.readString();
        this.follower = in.readString();
        this.followeing = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
