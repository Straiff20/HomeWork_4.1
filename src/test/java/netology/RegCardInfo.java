package netology;



import java.util.Objects;

public class RegCardInfo {
    private String fullName;
    private String city;
    private String phoneNumber;

    public RegCardInfo(String city, String fullName, String phoneNumber) {
        this.city = city;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "RegCardInfo{" +
                "fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegCardInfo that = (RegCardInfo) o;
        return city.equals(that.city) &&
                fullName.equals(that.fullName) &&
                phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, fullName, phoneNumber);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}